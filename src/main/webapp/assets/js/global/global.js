var redirectHomeLink = document.getElementById("redirectHomeLink");


redirectHomeLink.onclick = function(){
    window.location.href = "http://localhost:8080/HibernateWebApp1-Netbeans";
};



function clearForm(listOfIdsInput){
    listOfIdsInput.forEach(function(x){
        $(x).val("");
    });
}
window.onresize = function(){
    var topNavbar = document.getElementById("top-navbar");
    if(window.innerWidth > 768){
        topNavbar.style.height  = "40px";
    }
};