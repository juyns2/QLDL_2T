<%-- 
    Document   : run
    Created on : Aug 29, 2022, 8:57:44 PM
    Author     : Lenovo
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="formj" uri="http://www.springframework.org/tags/form" %>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        
    <formj:form method="post" action="/qldl/hello-post" modelAttribute="user_j">	
        <formj:input path="firtName" />					
        <formj:input path="lastName" />
        <input type="submit" value="send" />
    </formj:form>

</body>
</html>
