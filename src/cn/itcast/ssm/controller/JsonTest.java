package cn.itcast.ssm.controller;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.sun.jmx.snmp.SnmpStringFixed;

import cn.itcast.ssm.po.Administrator;
import cn.itcast.ssm.po.ItemsCustom;
import cn.itcast.ssm.service.ItemsService;

/*
 * json交互
 */
@Controller
public class JsonTest 
{
	@Autowired
	private ItemsService itemsService;

@RequestMapping("/responseJson")
public @ResponseBody  ItemsCustom responseJson(HttpServletRequest request ,ItemsCustom itemsCustom) throws Exception
{

	
//	String a=(String) request.getParameter("name");
//	System.out.println(a);
//	itemsCustom.setName("bcd");
	
	
	//从数据库查到的用户
	    String a=(String) request.getParameter("name");
	    System.out.println(a);
		Administrator ad=itemsService.queryadmini1(a);
		
		
	    if(ad!=null)
		{
	    	itemsCustom.setName("失败");
	    
		}
	  
	    else
	    {	  	
	    	
	    	itemsCustom.setName("成功");
	    	
	    }
		
	
	
	return itemsCustom;
	}




@RequestMapping("/responseJson3")
public @ResponseBody  Administrator responseJson3(HttpServletRequest request ,Administrator administrator) throws Exception
{

//	System.out.println(itemsCustom.getName());
//	System.out.println(itemsCustom.getPrice());
	
	
	
	//从数据库查到的用户
    String a=(String) request.getParameter("username");
    System.out.println(a);
	Administrator ad=itemsService.queryadmini1(a);
	
	
    if(ad!=null)
	{
    	administrator.setUsername("失败");
    
	}
  
    else
    {	  	
    	itemsService.insertadmini(administrator);
    	administrator.setUsername("成功");
    	
    }
	
	return administrator;
	}


@RequestMapping("/responseJson4")
public @ResponseBody  Administrator responseJson4(HttpServletRequest request ,Administrator administrator) throws Exception
{


	
	
	
	//从数据库查到的用户
    String a=(String) request.getParameter("username");
    System.out.println(a);
	Administrator ad=itemsService.queryadmini1(a);
	
	
    if(ad!=null&&ad.getPassword().equals(administrator.getPassword()))
	{
    	administrator.setUsername("成功");
    
	}
  
    else
    {	  	
    	
    	administrator.setUsername("失败");
    	
    }
	
	return administrator;
	}










@RequestMapping("/abc")
public String abc(HttpServletRequest request ,ItemsCustom itemsCustom)
{

	
	return "success";
}


}
