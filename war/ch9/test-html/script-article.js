"use strict";

var myModule = Object.create({
ajaxHandler : function (e) {
 if(this.readyState == 4 && this.status == 200) {
   var selected = document.querySelectorAll('article');
   selected.item(0).innerHTML = this.responseText;
 } else if (this.readyState == 4 && this.status != 200) {
   // error handling
 } else {
   // status handling
 }
},
hasClicked : function(e) {
  if(e.target.nodeName == "H1") {
    var xhr = new XMLHttpRequest();
    xhr.onreadystatechange = myModule.ajaxHandler;
    xhr.open("GET", "values.html");
    xhr.send();
  }
},
initEvents : function() {
  var bodyEl = document.getElementsByTagName('body');
  if(bodyEl.length > 0) bodyEl.item(0).addEventListener('click', myModule.hasClicked, false);
}});

document.addEventListener('DOMContentLoaded', myModule.initEvents, false);
