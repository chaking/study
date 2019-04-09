'use strict';
/*
document.addEventListener('DOMContentLoaded', function() {
    var h1 = document.getElementsByTagName('h1');
    if (h1.length > 0) {
        h1[0].innerText = h1[0].innerText + ' \'Allo';
    }
}, false);
*/
document.addEventListener('DOMContentLoaded', function() {
    // Request or load a cached token
    chrome.identity.getAuthToken({ 'interactive': true }, function(token) {
        console.log(token);
    });
}, false);
