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
  /*  function deleteItems(){
	   //提交form
	   document.itemsForm.action="${pageContext.request.contextPath }/items/deleteItems.action"
	   document.itemsForm.submit();
   } */
   
   function queryItems(){
	   //提交form
	   document.itemsForm.action="${pageContext.request.contextPath }/items/queryItems5.action"
	   document.itemsForm.submit();
   }
  
  /* function addItems(){
	   //提交form
	   document.itemsForm.action="${pageContext.request.contextPath }/items/insertItems.action"
	   document.itemsForm.submit();
  } */
   
   function querymycar(){
	   //提交form
	   document.itemsForm.action="${pageContext.request.contextPath }/items/querycar.action"
	   document.itemsForm.submit();
   } 
   
   function querymyorder(){
	   //提交form
	   document.itemsForm.action="${pageContext.request.contextPath }/items/queryorders.action"
	   document.itemsForm.submit();
   } 
   
   function login(){
	   //提交form
	   document.itemsForm.action="${pageContext.request.contextPath }/items/login.action"
	   document.itemsForm.submit();
   } 
   
   function register(){
	   //提交form
	   document.itemsForm.action="${pageContext.request.contextPath }/items/register.action"
	   document.itemsForm.submit();
   } 
   
   
  
   
   
   
   
   
</script>


</head>
<body>

   <form name="itemsForm" action="${pageContext.request.contextPath }/items/queryItems5.action" method="post">
                   查询条件
       <table width="100%" border=1>
             
         <tr>
               <td>
                                                               商品名称:<input name="itemsCustom.name"/>
          
          
          
               </td>
         
         
                 <td><input type="button" value="查询" onclick="queryItems()"/>
                     <!-- <input type="button" value="批量删除" onclick="deleteItems()"/> -->
                    <!--  <input type="button" value="添加" onclick="addItems()"/> -->
                      <input type="button" value="我的购物车" onclick="querymycar()"/>
                       <input type="button" value="我的订单" onclick="querymyorder()"/>
                        <input type="button" value="管理员登陆" onclick="login()"/>
                          <input type="button" value="管理员注册" onclick="register()"/>
                            
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
              <img src="/pic/${item.pic }" width=100 height=100 />
              </td>
                 
              
              
              <td>${item.detail }</td>
              
             <%--  <td><a href="${pageContext.request.contextPath }/items/editItems.action?id=${item.id}">修改</a></td> --%>
              <td><a href="${pageContext.request.contextPath }/items/addtobuycarSubmit.action?name=${item.name}&price=${ item.price}&detail=${item.detail}&pic=${item.pic}&createtime=${item.createtime}">添加购物车</a></td>
              <td><a href="${pageContext.request.contextPath }/items/editbuy.action?id=${item.id}">购买</a></td>
           </tr>
         </c:forEach>
      </table>
   
   </form>


</body>
</html>