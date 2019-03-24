/**
 * This module is used to manage the health view.
 * 
 *  Author: Lorenzo Cozza
 */

var Health = {	
	getInstance : __getInstance	
}

function __getInstance(){
	return {
		VERSION : 'HEALTH_001',
		PARENT_ID : '#healthContent', 
		version : __version,
		initHealthView : __initHealthView 
	}
}

function __version(){
	return this.VERSION;
}

function __initHealthView(){
	$(this.PARENT_ID).html("hello health!");
}