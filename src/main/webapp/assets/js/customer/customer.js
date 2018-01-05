
$("#ajax-response").hide();

// function disable(){
//     $("#button-purchase").prop("disabled","true");
//     $("#button-purchase").css("backgroundColor","grey");
// }
//
// function enable(){
//     $("#button-purchase").prop("disabled","false");
//     $("#button-purchase").css("backgroundColor","#2196F3");
// }
//
//
// disable();

// function onValidCustomer(event){
//     if(event.keyCode === 13 && event.target.value !== "" && event.target.value !== undefined){
//         $.ajax({
//            url:"http://localhost:8080/HibernateWebApp1-Netbeans/search/customer?customer_id="+event.target.value,
//            method:"GET",
//            success : function (data,status,xhr) {
//                if(data === "OK"){
//                    enable();
//                }else{
//                    disable();
//                }
//            },
//            error : function(xhr,status,error){
//                 console.log(error);
//            }
//         });
//     }
// }

$("#button-purchase").click(function(){
    var pcCustomerId = $("#pc_customer_id").val();
    var pcProductId = $("#pc_product_id").val();

    if(pcProductId === "" || pcCustomerId === ""
    || pcCustomerId === undefined || pcProductId === undefined){
        alert("field empty");
    }else{
        $.ajax({
            url:"http://localhost:8080/HibernateWebApp1-Netbeans/product-customer/purchase",
            method : "POST",
            headers : {"Content-type":"application/x-www-form-urlencoded"},
            data : {
                customer_id : pcCustomerId,
                product_id : pcProductId
            },
            success : function(data,status,xhr){
                console.log("request complete");
                console.log(data);
                alert(data);
            },
            error : function(xhr,status,error){
                console.log(error);
                console.log("Error request to server");
                alert("Error request to server");
            }
        });
    }


});

// function purchaseAProduct(){
//     var pcCustomerId = $("#pc_customer_id").val();
//     var pcProductId = $("#pc_product_id").val();
//
//     console.log("test click");
// }

// function purchaseAProduct(){
//     var pcCustomerId = $("#pc_customer_id").val();
//     var pcProductId = $("#pc_product_id").val();
//
//     console.log("clicked button-purchase id");
//
//     if(pcCustomerId === '' || pcCustomerId === undefined
//     || pcProductId === '' || pcProductId === undefined){
//         alert("field empty");
//         console.log("clicked_empty");
//     }else{
//         console.log("clicked before ajax");
//         $.ajax({
//             url:"http://localhost:8080/HibernateWebApp1-Netbeans/product-customer/purchase",
//             method : "POST",
//             headers : {"Content-type":"application/x-www-form-urlencoded"},
//             data : {
//                 customer_id : pcCustomerId,
//                 product_id : pcProductId
//             },
//             success : function(data,status,xhr){
//                 console.log("request complete");
//                 console.log(data);
//             },
//             error : function(xhr,status,error){
//                 console.log(error);
//                 console.log("Error request to server");
//             }
//         });
//     }
// }


function saveCustomer(){
    var customerId = $("#customer_id").val();
    var customerName = $("#customer_name").val();
    
    if(customerId === ''|| customerId === undefined 
            || customerName === '' || customerName === undefined){
        alert("Field still empty");
    }else{
        console.log("ID : " + customerId + " Name :" + customerName);
        $.ajax({
            url: "http://localhost:8080/HibernateWebApp1-Netbeans/customer/form",
            method : "post",
            data: {
                customer_id  : customerId,
                customer_name : customerName
            },
            success: function (data, textStatus, jqXHR) {
                console.log(data);
                console.log("on_success");
                clearForm(["#customer_id","#customer_name"]);
                window.location.reload();
            },
            error: function (jqXHR, textStatus, errorThrown) {
                console.log(errorThrown);
                console.log("on_error");
            }
        });
    }
}