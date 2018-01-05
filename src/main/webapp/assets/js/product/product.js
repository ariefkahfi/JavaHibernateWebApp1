
function saveProduct(){
    var productId = $("#product_id").val();
    var productName = $("#product_name").val();
    var productPrice = $("#product_price").val();
    
    if(productId === ''
            || productId === undefined 
            || productName === ''
            || productName === undefined
            || productPrice === ''
            || productPrice === undefined){
        alert("Field still empty");
    }else{
        $.ajax({
            url: "http://localhost:8080/HibernateWebApp1-Netbeans/product/form",
            method : "post",
            headers: {"Content-type":"application/x-www-form-urlencoded"},
            data: {
                product_id : productId,
                product_name : productName,
                product_price  :productPrice
            },
            success: function (data, textStatus, jqXHR) {
                clearForm(["#product_id","#product_name","#product_price"]);
                $("#ajax-response").html(data);
                window.location.reload();
            },
            error: function (jqXHR, textStatus, errorThrown) {
                $("#ajax-response").html("Error save data");
                console.log(errorThrown);
            }
        });
    }
    
}