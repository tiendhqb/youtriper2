// JavaScript Document


$(document).ready(function() {
/*
  $('img').each(function(index, value){
	  $(this).error(function() {
		//var img_src = $(this).attr('src');
	  	//$(this).attr('src', scr_domain+img_src.replace('../', ''));
	  });
	  
	  $(this).load(function() {
		  
	  });
	  
	  var img_src = $(this).attr('src');
	  var img_ptc = img_src.substring(0, 4);
	  if(img_ptc != "http" && img_ptc != "//"){
		var img_src = $(this).attr('src');
	  	$(this).attr('src', scr_domain+img_src.replace('../', ''));
	  }
  });*/
});

function createScript(v, path){	
    document.write('<script type="text/javascript" src="'+scr_domain+path+v.replace('../', '')+'"></script>');
}

function getScreenSizes(){
	var viewportwidth;
	var viewportheight;
	
	// the more standards compliant browsers (mozilla/netscape/opera/IE7) use window.innerWidth and window.innerHeight
	
	if (typeof window.innerWidth != 'undefined'){
	  viewportwidth = window.innerWidth,
	  viewportheight = window.innerHeight
	}
	
	// IE6 in standards compliant mode (i.e. with a valid doctype as the first line in the document)
	
	else if (typeof document.documentElement != 'undefined' && typeof document.documentElement.clientWidth != 'undefined' && document.documentElement.clientWidth != 0){
	   viewportwidth = document.documentElement.clientWidth,
	   viewportheight = document.documentElement.clientHeight
	}
	
	// older versions of IE
	
	else{
	   viewportwidth = document.getElementsByTagName('body')[0].clientWidth,
	   viewportheight = document.getElementsByTagName('body')[0].clientHeight
	}
	
	//this.printTest("viewport: "+viewportwidth+", "+viewportheight);
	
	//return new Array(window.screen.width, window.screen.height);
	return new Array(viewportwidth, viewportheight);
}