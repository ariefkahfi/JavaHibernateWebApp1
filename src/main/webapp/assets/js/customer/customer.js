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
            },
            error: function (jqXHR, textStatus, errorThrown) {
                console.log(errorThrown);
                console.log("on_error");
            }
        });
    }
}