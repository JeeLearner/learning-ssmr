<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" 
    "http://www.w3.org/TR/html4/loose.dtd">
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Insert title here</title>
    </head>
    <body>
       <%
       //设置请求属性
       request.setAttribute("id", 1L);
       //转发给控制器
       request.getRequestDispatcher("./attribute/requestAttribute.do").forward(request, response);
       %>
    </body>
</html>