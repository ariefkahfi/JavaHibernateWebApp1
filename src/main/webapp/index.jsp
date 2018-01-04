<%@page import="com.arief.hibernatewebapp1.netbeans.consts.PathConsts"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8"/>
        <meta name="viewport" content="width=device-width, initial-scale=1"/>
        <link rel="stylesheet" href="https://fonts.googleapis.com/css?family=Raleway"/>
        <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/font-awesome/4.7.0/css/font-awesome.min.css"/>
        <title>Home Page</title>
        
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
            href="<%=PathConsts.CP%>/assets/css/index/index.css"
        />
        
    </head>
    <body>
        
        <%--start top navbar--%>
        <%@include file="assets/html/top-navbar.html" %>
        <%--end top navbar--%>
        
        
        <%--start left navbar fixed--%>
        <%@include file="assets/html/left-navbar.html" %>
        <%--end left navbar fixed--%>
        
        <%--start right container--%>
        <div class="right-container">
            <div class="container-inner">
                <h2 class="title container-inner-title">
                    Hello First Container
                </h2>
                <div class="container-inner-content-container">
                    <p>
                        Lorem Ipsum
                        "Neque porro quisquam est qui dolorem ipsum quia dolor sit amet, consectetur, adipisci velit..."
                        "There is no one who loves pain itself, who seeks after it and wants to have it, simply because it is pain..."
                    </p>
                </div>
            </div>
            <div class="container-inner">
                <h2 class="title container-inner-title">
                    Hello Second Container
                </h2>
                <div class="container-inner-content-container">
                    <h2>What is Lorem Ipsum ? </h2>
                    <p>
                        Lorem Ipsum is simply dummy text of the printing and typesetting industry. Lorem Ipsum has been the industry's standard dummy text ever since the 1500s, when an unknown printer took a galley of type and scrambled it to make a type specimen book. It has survived not only five centuries, but also the leap into electronic typesetting, remaining essentially unchanged. It was popularised in the 1960s with the release of Letraset sheets containing Lorem Ipsum passages, and more recently with desktop publishing software like Aldus PageMaker including versions of Lorem Ipsum.
                    </p>
                </div>
            </div>
            <div class="container-inner">
                <h2 class="title container-inner-title">Hello Third Container</h2>
                <div class="container-inner-content-container">
                    <h2>What is Lorem Ipsum ? </h2>
                    <p>
                        Lorem Ipsum is simply dummy text of the printing and typesetting industry. Lorem Ipsum has been the industry's standard dummy text ever since the 1500s, when an unknown printer took a galley of type and scrambled it to make a type specimen book. It has survived not only five centuries, but also the leap into electronic typesetting, remaining essentially unchanged. It was popularised in the 1960s with the release of Letraset sheets containing Lorem Ipsum passages, and more recently with desktop publishing software like Aldus PageMaker including versions of Lorem Ipsum.
                    </p>
                </div>
            </div>
        </div>
        <%--end right container--%>
        
        
        
    </body>
    <script src="<%=PathConsts.CP%>/assets/js/navbar/top-navbar.js"></script>
    <script src="<%=PathConsts.CP%>/assets/js/global/global.js"></script>
</html>
