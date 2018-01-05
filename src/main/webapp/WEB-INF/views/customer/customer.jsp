<%@page import="com.arief.hibernatewebapp1.netbeans.entity.Customer"%>
<%@page import="com.arief.hibernatewebapp1.netbeans.dao.CustomerDAO"%>
<%@page import="com.arief.hibernatewebapp1.netbeans.entity.Product"%>
<%@page import="java.util.List"%>
<%@page import="com.arief.hibernatewebapp1.netbeans.dao.ProductDAO"%>
<%@page import="com.arief.hibernatewebapp1.netbeans.consts.PathConsts"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8"/>
        <meta name="viewport" content="width=device-width, initial-scale=1"/>
        <link rel="stylesheet" href="https://fonts.googleapis.com/css?family=Raleway"/>
        <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/font-awesome/4.7.0/css/font-awesome.min.css"/>
        <script type="text/javascript" src="https://code.jquery.com/jquery-3.2.1.min.js"></script>
        <title>Customer Page</title>
        
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
            <form method="post" action="<%=PathConsts.CP%>/customer/form">
                <input type="submit" value="Test Submit"/>
            </form>
            <div class="container-inner">
                
                <div class="accordion-container">
                    <h3 class="accordion-container-title">Form Customer</h3>
                    <div class="accordion-container-content-container">
                        <div class="accordion-content">
                            <div class="form-wrapper">
                                <form method="POST" action="<%=PathConsts.CP%>/customer/form">
                                    <div class="form-row cleafix">
                                        <label for="customer_id" class="form-label">Customer ID</label>
                                        <input type="text" class="form-input-type" name="customer_id"  id="customer_id"/>
                                    </div>
                                    <div class="form-row cleafix">
                                        <label for="customer_name" class="form-label">Customer Name</label>
                                        <input type="text" class="form-input-type" name="customer_name"  id="customer_name"/>
                                    </div>
                                    <div class="form-row">
                                        <button class="form-button form-button-blue" >Submit</button>
                                    </div>
                                </form>
                            </div>
                        </div>
                    </div>
                </div>
                
                <div class="accordion-container">
                    <h3 class="accordion-container-title">List Customer</h3>
                    <div class="accordion-container-content-container">
                        <div class="accordion-content">
                            <h2>Our Customer List</h2>
                            <div class="table-container">
                                <table class="table-full-width" border="2">
                                    <tr>
                                        <td>Customer ID</td>
                                        <td>Customer Name</td>
                                    </tr>
                                    <%
                                       CustomerDAO cDAO = (CustomerDAO)request.getServletContext().getAttribute("customerDAO");
                                       List<Customer> customerList = cDAO.findAll();
                                    %>
                                    <%
                                        for (Customer c : customerList){
                                    %>
                                            <tr>
                                                <td><%=c.getCustomerId()%></td>
                                                <td><%=c.getCustomerName()%></td>
                                            </tr>
                                    <%
                                        }
                                    %>
                                </table>
                            </div>
                        </div>
                    </div>
                </div>
                
            </div>
        </div>
        
        
    </body>
    <script src="<%=PathConsts.CP%>/assets/js/navbar/top-navbar.js"></script>
    <script src="<%=PathConsts.CP%>/assets/js/global/global.js"></script>
    <script src="<%=PathConsts.CP%>/assets/js/accordion/accordion.js"></script>
    <script src="<%=PathConsts.CP%>/assets/js/customer/customer.js"></script>
</html>
