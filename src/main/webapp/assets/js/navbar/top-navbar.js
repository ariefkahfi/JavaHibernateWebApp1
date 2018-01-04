var toggleTopNavbar = document.getElementById("toggle-top-navbar");


toggleTopNavbar.onclick = function(event){
    var currentHeightOfTopNavbar = document.getElementById("top-navbar");
    if(currentHeightOfTopNavbar.offsetHeight === 40){
        currentHeightOfTopNavbar.style.height = "159px";
    }else{
        currentHeightOfTopNavbar.style.height = "40px";
    }
};






