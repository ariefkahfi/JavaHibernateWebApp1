$(".accordion-container-content-container").hide();

$(".accordion-container").click(function(){
    $(this).children(".accordion-container-content-container").slideToggle();
});