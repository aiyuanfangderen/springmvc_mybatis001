<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>查询商品列表</title>

<script type="text/javascript">
   
   
   function queryItems(){
	   //提交form
	   document.itemsForm.action="${pageContext.request.contextPath }/items/queryItems6.action"
	   document.itemsForm.submit();
   }
  
   function addItems(){
	   //提交form
	   document.itemsForm.action="${pageContext.request.contextPath }/items/insertItems.action"
	   document.itemsForm.submit();
   } 
   
  
   
   function querymyorder(){
	   //提交form
	   document.itemsForm.action="${pageContext.request.contextPath }/items/queryorders.action"
	   document.itemsForm.submit();
   } 
   
   function deleteItems(){
	   //提交form
	   document.itemsForm.action="${pageContext.request.contextPath }/items/deleteItems.action"
	   document.itemsForm.submit();
   }
   
   
</script>


</head>
<body>

   <form name="itemsForm" action="${pageContext.request.contextPath }/items/queryItems6.action" method="post">
         管理员界面：
       <table width="100%" border=1>
             
         <tr>
               <td>
                                                               商品名称:<input name="itemsCustom.name"/>
          
          
          
               </td>
         
         
                 <td><input type="button" value="查询" onclick="queryItems()"/>
                     
                      <input type="button" value="批量删除" onclick="deleteItems()"/>
                     <input type="button" value="添加" onclick="addItems()"/>
                      
                       <input type="button" value="订单信息" onclick="querymyorder()"/>
                      
                 </td>
   
         </tr>
   
   
      </table>
   
 
                 商品列表
      <table>
           <tr>
               <td>选择</td>
               <td>商品名称</td>
               <td>商品价格</td>
               <td>生产日期</td>
               <td>商品图片</td>
               <td>商品描述</td>
               <td>操作</td>
           </tr>
           
           <c:forEach items="${itemsList }" var="item">
           
           <tr>
              <td><input type="checkbox" name="items_id" value="${item.id}"/></td>
              <td>${item.name }</td>
              <td>${item.price }</td>
              
              <td>${item.createtime }</td>
              
              <td>
              
            
              
            <%-- <c:if test="${itemsCustom.pic!=null }"> --%>
                      <img src="/pic/${item.pic }" width=50 height=50 />
                  
                  <%-- </c:if> --%>
              
              
              
              
              </td>
              
              <td>${item.detail }</td>
              
              <td><a href="${pageContext.request.contextPath }/items/editItems.action?id=${item.id}">修改</a></td>
              <td><a href="${pageContext.request.contextPath }/items/deletethisItem.action?id=${item.id}">删除</a></td>
             
           </tr>
         </c:forEach>
      </table>
   
   </form>


</body>
</html>