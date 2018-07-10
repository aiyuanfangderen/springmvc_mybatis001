<%@page import="cn.itcast.ssm.po.Orders"%>

<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
       
  
      
    
       
       
       <%
       List<Orders> orders=(List<Orders>)request.getAttribute("orderList");
      
        if(orders!=null&&orders.size()>0)
        {        
      %>
      
      <hr>
      <br><br>
      
         <table border="1" cellpadding="10" cellspacing="0">
         
            <tr>
               
               <th>订单id</th>
               <th>用户id</th>
               <th>编号</th>
               <th>订单时间</th>
               <th>订单描述</th>
              
               
               
               <th>删除我的订单记录</th>
            </tr>
            
            
            <%
            for(Orders order:orders)
            {
            
            %>
            
            
            <tr>
              
               <td><%=order.getId()%></td>
               <td><%=order.getUserId()%></td>
               <td><%=order.getNumber()%></td>
                <td><%=order.getCreatetime()%></td>
              <td><%=order.getNote()%></td>
               
               
               
               
                <!-- 删除时存在联级情况，可能导致有些订单无法删除，在此未做处理，数据表设计不合理 -->
               <td>
                <a href="deleteorder.action?id=<%= order.getId() %>" class="deleteorder">从订单删除</a>
                
               
               </td>
               
            </tr>
            
            
            <%
            }
            %>
         
         </table>
      
      
      <%
            }
      %>



</body>
</html>