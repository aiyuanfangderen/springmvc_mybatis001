<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
 <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>   
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>添加商品信息</title>
<body>
   
   
   
   
   


    <form id="itemForm" action="${pageContext.request.contextPath }/items/buySubmit.action" method="post">
         
                        添加商品信息：
         <table width="100%" border=1>
            <tr>
                <td>用户id</td>
                <td><input type="text" name="userId"></td>
            </tr>
         
           <tr>
               <td>编号</td>
                <td><input type="text" name="number"></td>
           </tr>
         
         <tr>
               <td>商品生产日期</td>
                <td><input type="text" name="createtime"></td>
           </tr>
         
        
         
         <tr>
            <td>留言</td>
             <td>
                <textarea rows="3" cols="30" name="note"></textarea>
             
             </td>
         </tr>
         
         <tr>
             <td colspan="2" align="center"><input type="submit" value="提交"/>
             
             </td>
         </tr>
         
         
         </table>
   
    </form>





</body>
</html>