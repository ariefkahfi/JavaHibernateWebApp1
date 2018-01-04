<%@page import="com.arief.hibernatewebapp1.netbeans.consts.PathConsts"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8"/>
        <meta name="viewport" content="width=device-width, initial-scale=1"/>
        <title>Product Page</title>
        <link rel="stylesheet" href="https://fonts.googleapis.com/css?family=Raleway"/>
        <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/font-awesome/4.7.0/css/font-awesome.min.css"/>
        <script type="text/javascript" src="https://code.jquery.com/jquery-3.2.1.min.js"></script>
        
        <link
            rel="stylesheet"
            href="<%=PathConsts.CP%>/assets/css/global/left-navbar-fixed.css"
            />
        <link
            rel="stylesheet"
            href="<%=PathConsts.CP%>/assets/css/global/top-navbar.css"
            />
        <link 
            rel="stylesheet" 
            href="<%=PathConsts.CP%>/assets/css/global/font.css"
        />
        <link
            rel="stylesheet"
            href="<%=PathConsts.CP%>/assets/css/global/global.css"
            />
        <link
            rel="stylesheet"
            href="<%=PathConsts.CP%>/assets/css/global/accordion.css"
            />
        <link
            rel="stylesheet"
            href="<%=PathConsts.CP%>/assets/css/global/form.css"
            />
        
    </head>
    <body>
        <%--start top navbar--%>
        <%@include file="../../../assets/html/top-navbar.html" %>
        <%--end top navbar--%>
        
        
        <%--start left navbar fixed--%>
        <%@include file="../../../assets/html/left-navbar.html" %>
        <%--end left navbar fixed--%>
        
        
        <div class="right-container">
            <div class="container-inner">
                
                <div class="accordion-container">
                    <h3 class="accordion-container-title">Form Product</h3>
                    <div class="accordion-container-content-container">
                        <div class="accordion-content">
                            <div class="form-wrapper">
                                <form>
                                    <div class="form-row cleafix">
                                        <label class="form-label" for="product_id">Product ID</label>
                                        <input type="text" class="form-input-type" id="product_id"/>
                                    </div>
                                    <div class="form-row cleafix">
                                        <label class="form-label" for="product_name">Product Name</label>
                                        <input type="text" class="form-input-type" id="product_name"/>
                                    </div>
                                    <div class="form-row cleafix">
                                        <label for="product_price" class="form-label">Product Price</label>
                                        <input type="number" class="form-input-type" id="product_price"/>
                                    </div>
                                    <div class="form-row">
                                        <button class="form-button-blue form-button">Save</button>
                                    </div>
                                </form>
                            </div>
                        </div>
                    </div>
                </div>
                
                <div class="accordion-container">
                    <h3 class="accordion-container-title">List Product</h3>
                    <div class="accordion-container-content-container">
                        <div class="accordion-content">
                            <h2>Our Product List</h2>
                        </div>
                    </div>
                </div>
                
            </div>
        </div>
        
    </body>
    <script src="<%=PathConsts.CP%>/assets/js/navbar/top-navbar.js"></script>
    <script src="<%=PathConsts.CP%>/assets/js/global/global.js"></script>
    <script src="<%=PathConsts.CP%>/assets/js/accordion/accordion.js"></script>
</html>