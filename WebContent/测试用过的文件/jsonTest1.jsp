<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>json的交互测试</title>
<script type="text/javascript" src="${pageContext.request.contextPath }/js/jquery-1.7.2.min.js"></script>
<script type="text/javascript">



//请求的是key/value，输出的是json
function responseJson(){
	
	 var a=document.getElementById("username").value;
	 
	 $.ajax({
			type:"post",
			url:'${pageContext.request.contextPath }/responseJson.action',
			dataType:"json",
			//json格式是json串
			data:"name="+a,
			success:function(data){
				 if(data.name="bcd")
					{
					$("#message").text("该账号已经存在，请重新注册");
					}
				else
					{
					$("#message").text("注册成功");
					} 
			}
		}); 
	 
}

</script>
</head>
<body>
       <input type="text" id="username"><span><font id="message"></font></span>
     <br>
     <input type="password" id="password">
     <br>
     
  <input id="123" type="button" onclick="responseJson()" value="注册"/>
   <a href="abc.action">去登陆页面</a>
</body>
</html>