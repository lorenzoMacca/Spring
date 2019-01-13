var selectedItem = "-1";
var backgroundColorSelectItem = "#4d4dff";
var defaultColor = "white"

function setColor(element, color){
	$(element).parent().css({"background-color": color});
}

$(".clickableImg").on( "mouseenter", function( event ) {
	setColor(this, backgroundColorSelectItem);
});

$(".clickableImg").on( "mouseleave", function( event ) {
	if(selectedItem != this.id){
		setColor(this, defaultColor);
	}
});

$(".clickableImg").click(function(){
	$(".clickableImg").parent().css({"background-color": "white"});
	selectedItem = this.id;
	setColor(this, backgroundColorSelectItem);
});