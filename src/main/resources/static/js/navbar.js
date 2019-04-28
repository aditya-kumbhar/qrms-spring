/**
 * 		var navBar = document.getElementById("nav-bar");		
		var current = navBar.getElementsByClassName("active");
	    // If there's any other active nav, make it inactive
	    if (current.length > 0) { 
	      current[0].className = current[0].className.replace(" active", "");
	    }
		//set current page nav as active
		document.getElementById("home-nav").className+=" active";
 */

function navbar_activation(strNavId){
	var navBar = document.getElementById("nav-bar");		
	var current = navBar.getElementsByClassName("active");
    // If there's any other active nav, make it inactive
    if (current.length > 0) { 
      current[0].className = current[0].className.replace(" active", "");
    }
	//set current page nav as active
	document.getElementById(strNavId).className+=" active";
}