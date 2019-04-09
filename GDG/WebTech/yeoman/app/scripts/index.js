'use strict';
document.addEventListener('DOMContentLoaded', function() {
    // Request or load a cached token
    chrome.identity.getAuthToken({ 'interactive': true }, function(token) {
        console.log(token);
    });
}, false);

 // Add event handler to remove cached token if we've got an errors
document.getElementsByTagName('x-thumbnail')[0].addEventListener('on-error', function(e) {
    console.log('error', e.detail.token);
    chrome.identity.removeCachedAuthToken({'token': e.detail.token});
});

// Add event handler to handle event for downloading image
document.getElementsByTagName('x-thumbnail')[0].addEventListener('on-download', function(e) {
    console.log('Downloaded images');
});

// Request or reading cache a token
chrome.identity.getAuthToken({ 'interactive': true }, function(token) {
    document.getElementsByTagName('x-thumbnail')[0].token = token;
});
