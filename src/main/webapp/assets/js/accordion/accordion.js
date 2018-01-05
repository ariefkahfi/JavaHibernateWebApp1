$(".accordion-container-content-container").hide();

$(".accordion-container-title").click(function(){
    $(this).next(".accordion-container-content-container").slideToggle();
});