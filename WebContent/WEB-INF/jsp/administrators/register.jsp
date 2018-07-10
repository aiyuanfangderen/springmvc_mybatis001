<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>

     <form id="itemForm" action="${pageContext.request.contextPath }/items/registerexamine.action" method="post">
   输入账号：
  <input type="text" name="username"/><br><br>
  输入密码：
  <input type="text" name="password"/><br><br>
  <input type="submit" value="注册"/>
 </form>


   <br><br>

 <%
    String msg=(String)request.getAttribute("msg");
   %>
   
   
   <%
   if(msg==null)
   {
	 msg="";
	 
   %>
	 <%=msg%>
	  
	 <%
   }
	 %>
	<%
	if(msg!=null)
	{
	%> 
	   <%=msg %>
	   
    <%
	}
    %>

      
      
</body>
</html>