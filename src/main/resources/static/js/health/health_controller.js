
$('#bodyMeasurementButton').click(function(){
	let page = PageManager.getInstance();
	page.clearPage();
	page.showPage({
		showPage : switchToHealthBodyMEasurement()
	});
});

function switchToHealthBodyMEasurement(){
	console.log("hello");
	//load  date and manage the page
}