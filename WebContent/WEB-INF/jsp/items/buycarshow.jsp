<%@page import="cn.itcast.ssm.po.Buycar"%>
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
       List<Buycar> buycars=(List<Buycar>)request.getAttribute("buycarList");
      
        if(buycars!=null&&buycars.size()>0)
        {        
      %>
      
      <hr>
      <br><br>
      
         <table border="1" cellpadding="10" cellspacing="0">
         
            <tr>
               
               <th>商品名称</th>
               <th>商品价格</th>
               <th>商品描述</th>
               <th>图片</th>
               <th>生产日期</th>
              
               
               
               <th>删除我的订单记录</th>
            </tr>
            
            
            <%
            for(Buycar buycar:buycars)
            {
            
            %>
            
            
            <tr>
              
               <td><%=buycar.getName()%></td>
               <td><%=buycar.getPrice()%></td>
               <td><%=buycar.getDetail()%></td>
               
               
               
                <td>
                
                <%-- <%=buycar.getPic()%> --%>
                 <img src="/pic/<%=buycar.getPic()%>" width=50 height=50 />
                </td>
                
                
                
              <td><%=buycar.getCreatetime()%></td>
               
               
               
               
        
               <td>
                <a href="deletebuycar.action?id=<%= buycar.getId() %>" class="deletebuycar">从购物车删除</a>
                <a href="editbuy.action?id=<%= buycar.getId() %>" class="editbuy">购买</a>
               
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