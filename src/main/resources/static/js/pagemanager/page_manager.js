/**
 * This module is used to manage the views.
 * 
 *  Author: Lorenzo Cozza
 */

var PageManager = {	
	getInstance : __getInstance	
}

function __getInstance(){
	return {
		VERSION : 'PM_001',
		ELEMENTS : '.rightContainerElement',
		currentPage : null,
		version : __version,
		clearPage : __clearPage,
		showPage : __showPage
	}
}

function __version(){
	return this.VERSION;
}

function __clearPage(){
	$(this.ELEMENTS).children().html('');
}

function __showPage(page){
	//this.clearPage();
	page['showPage'];
}