

  // upgrade polymer-body last so that it can contain other imported elements
  document.addEventListener('polymer-ready', function() {
    
    Polymer('polymer-body', Platform.mixin({

      created: function() {
        this.template = document.createElement('template');
        var body = wrap(document).body;
        var c$ = body.childNodes.array();
        for (var i=0, c; (c=c$[i]); i++) {
          if (c.localName !== 'script') {
            this.template.content.appendChild(c);
          }
        }
        // snarf up user defined model
        window.model = this;
      },

      parseDeclaration: function(elementElement) {
        this.lightFromTemplate(this.template);
      }

    }, window.model));

  });

  ;



function downloadImage(src, token, cb) {
    var xhr = new XMLHttpRequest();
    xhr.open('GET', src, true);
    xhr.responseType = 'blob';
    xhr.setRequestHeader('Authorization', 'Bearer ' + token);
    xhr.onload = function() {
        cb(window.webkitURL.createObjectURL(this.response));
    }
    xhr.send();
}

Polymer('x-thumbnail', {
viewerClicked: function() {
this.$.viewerframe.style.backgroundImage = 'none';
this.$.viewerframe.style.display = 'none';
},
imageSelected: function(event, detail, sender) {
var src = 'https://drive.google.com/uc?id=' + sender.getAttribute('data-id')
downloadImage(src, this.token, function(src) {
    this.$.viewerframe.style.backgroundImage = 'url(' + src + ')';
        this.$.viewerframe.style.display = 'block';
        }.bind(this));
    },
metadata: [],
token: '',
tokenChanged: function(oldVal, newVal) {
// https://github.com/GoogleChrome/chrome-app-samples/blob/master/gdrive/js/gdocs.js
var token = newVal;
var metadata = this.metadata;
var url = 'https://www.googleapis.com/drive/v2/files?q=fullText contains \'jpg\'';

var fireError = function (token) {
this.fire('on-error', {token: token});
}.bind(this);

var fireDownloaded = function () {
this.fire('on-download');
}.bind(this);

var downloadThumbnails = function (images, cb) {
var image = images.shift();
cb = cb || function() {};

if (!image) {
    cb();
    return;
}

console.log('Downloading thumbnail', image.thumbnailLink);
downloadImage(image.thumbnailLink, token, function(src) {
        metadata.push({
id: image.id,
thumbnail: src
});

        downloadThumbnails(images, cb);
        });
};


var xhr = new XMLHttpRequest();
xhr.open('GET', url);
xhr.setRequestHeader('Authorization', 'Bearer ' + token);
xhr.onload = function () {
    if (this.status === 401) {
        console.error('Will remove auth token');
        fireError(token);
        return;
    } else if ((this.status & 0xC8) !== 200) {
        console.error('We\'ve got an error', this.status);
        return;
    }

    downloadThumbnails(JSON.parse(xhr.responseText).items, fireDownloaded);
}
xhr.send();
}
});
