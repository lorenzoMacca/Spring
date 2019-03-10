$(document).ready(function() {
	//add behaviour to the pinned sidebar
	unpinSideBar();
});

$("#setPinnedSidebar").change(function(){
	pinUnpinSideBar();
});

function pinUnpinSideBar(){
	if ($(".page-wrapper").hasClass("pinned")) {
		pinSideBar();
    } else {
    	unpinSideBar();
    }
}

function pinSideBar(){
	// unpin sidebar when hovered
    $(".page-wrapper").removeClass("pinned");
    $("#sidebar").unbind( "hover");
}

function unpinSideBar(){
	$(".page-wrapper").addClass("pinned");
    $("#sidebar").hover(
        function () {
            $(".page-wrapper").addClass("sidebar-hovered");
        },
        function () {
            $(".page-wrapper").removeClass("sidebar-hovered");
        }
    )
}