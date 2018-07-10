package cn.itcast.ssm.controller;

import java.io.File;
import java.util.List;
import java.util.UUID;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;

import cn.itcast.ssm.po.Administrator;
import cn.itcast.ssm.po.Buycar;
import cn.itcast.ssm.po.Items;
import cn.itcast.ssm.po.ItemsCustom;
import cn.itcast.ssm.po.ItemsQueryVo;
import cn.itcast.ssm.po.Orderdetail;
import cn.itcast.ssm.po.Orders;
import cn.itcast.ssm.service.ItemsService;

/**
 * 商品的Controller
 * @author ch928
 *
 */
@Controller
//为了对url进行分类管理，可以在这里定义根路径
//比如：商品列表：/items/queryItems.action
@RequestMapping("/items")
public class ItemsController 
{
	@Autowired
	private ItemsService itemsService;
    //商品的查询
	
		//@RequestMapping实现对queryItems方法和url进行映射，一个方法对应一个url
		//一般建议将url和方法写成一样，这里因为和非注解的一个url一样，所以稍微改一下
		@RequestMapping("/queryItems5")
		public ModelAndView queryItems(HttpServletRequest request,ItemsQueryVo itemsQueryVo) throws Exception
		{
			//测试forward后request是否可以共享
			System.out.println(request.getParameter("id"));
			//调用sevvice查询数据库，查询商品列表，这里使用静态数据模拟
			 List<ItemsCustom> itemsList=itemsService.findItemsList(itemsQueryVo);
		      
		     
			
			
			
			//返回modelandview
			 ModelAndView modelAndView=new ModelAndView();
			 //箱单与request的setAttribut，在jsp页面通过iemsList取数据
			 modelAndView.addObject("itemsList", itemsList);
			 
			 //指定视图
			 modelAndView.setViewName("items/itemsList");
			 return modelAndView;			 
			 //可以定义其他方法
			 //商品添加，商品删除		 
		}
		
		
		
		//管理员的查询界面
		@RequestMapping("/queryItems6")
		public ModelAndView queryItems6(HttpServletRequest request,ItemsQueryVo itemsQueryVo) throws Exception
		{
			//测试forward后request是否可以共享
			System.out.println(request.getParameter("id"));
			//调用sevvice查询数据库，查询商品列表，这里使用静态数据模拟
			 List<ItemsCustom> itemsList=itemsService.findItemsList(itemsQueryVo);
		      
		     
			
			
			
			//返回modelandview
			 ModelAndView modelAndView=new ModelAndView();
			 //箱单与request的setAttribut，在jsp页面通过iemsList取数据
			 modelAndView.addObject("itemsList", itemsList);
			 
			 //指定视图
			 modelAndView.setViewName("administrators/administrator");
			 return modelAndView;
			 
			 
			 //可以定义其他方法
			 //商品添加，商品删除
			 
		}
		
		
		
		
		
		
		
		
		
	//商品的信息修改页面提示
		//限制http请求方法
//		@RequestMapping("/editItems")
//		public ModelAndView editItems() throws Exception
//		{
//			//调用service根据商品id查询商品信息
//			ItemsCustom itemsCustom=itemsService.findItemsById(1);
//			
//			//返回modelandview
//			 ModelAndView modelAndView=new ModelAndView();
//			 
//			 //将商品信息放到model
//			 modelAndView.addObject("itemsCustom", itemsCustom);
//			 
//			//指定视图
//			 modelAndView.setViewName("items/editItems");
//			 
//			 
//			 return modelAndView;
//		}
		
		
		
		
		//商品的信息修改页面提示
		@RequestMapping(value="/editItems",method={RequestMethod.POST,RequestMethod.GET})
		//@RequestParam里面指定request传入参数名称和形参进行绑定
		//通过request属性指定参数是否必须要传入
		public String editItems(Model model,@RequestParam(value="id",required=true)Integer items_id) throws Exception
		{
			//调用service根据商品id查询商品信息
			ItemsCustom itemsCustom=itemsService.findItemsById(items_id);
			
			//返回modelandview
//			 ModelAndView modelAndView=new ModelAndView();
//			 
//			 //将商品信息放到model
//			 modelAndView.addObject("itemsCustom", itemsCustom);
//			 
//			//指定视图
//			 modelAndView.setViewName("items/editItems");
			 //通过形参中的model将model数据传到页面
			model.addAttribute("itemsCustom", itemsCustom);
			 
			 return "items/editItems";
		}
		
		
		
		
		
			
		
		//商品信息修改提交
		@RequestMapping("/editItemsSubmit")
		public String editItemsSubmit(HttpServletRequest request,Integer id,ItemsCustom itemsCustom,
				MultipartFile items_pic//接收商品的图片
				) throws Exception
		{
//			ModelAndView modelAndView=new ModelAndView();
//			 //返回一个成功页面
//			modelAndView.setViewName("success");
			
			//图片的原始名称
			String originalFilename=items_pic.getOriginalFilename();
			
			//上传图片
			if(items_pic!=null&&originalFilename!=null&&originalFilename.length()>0)
			{
				String pic_path="E:\\upload\\temp\\";
				
				
				//新的图片名称
				String newFileName=UUID.randomUUID()+originalFilename.substring(originalFilename.lastIndexOf("."));
				
				File newFile=new java.io.File(pic_path+newFileName);
				
				//将内存中的数据写入磁盘
				items_pic.transferTo(newFile);
				//将新图片写入名称itemsCustom中
				itemsCustom.setPic(newFileName);
				
						
			}
			
			else
			{
               ItemsCustom itemsCustom1=itemsService.findItemsById(itemsCustom.getId());
				
				itemsCustom.setPic(itemsCustom1.getPic());
			}
			
			
			
			
			
			
			//调用service更新商品信息，页面需要将商品传到此方法
			itemsService.updateItems(id, itemsCustom);
			
			
			//转发
			return "redirect:queryItems6.action";
//			 return modelAndView;
		}
		
		
		//商品的添加页面
		@RequestMapping("/insertItems")
		public String insertItems(HttpServletRequest request) throws Exception
		{
				 
			return "items/add";
		}
		
		
		
		
		
		
		//商品添加提交
		@RequestMapping("/addItemsSubmit")
		public String addItemsSubmit(HttpServletRequest request,Items items,
				MultipartFile items_pic//接收图片
				) throws Exception
		{
			//图片的原始名称
			String originalFilename=items_pic.getOriginalFilename();
			
			//上传图片
			if(items_pic!=null&&originalFilename!=null&&originalFilename.length()>0)
			{
				String pic_path="E:\\upload\\temp\\";
				
				
				//新的图片名称
				String newFileName=UUID.randomUUID()+originalFilename.substring(originalFilename.lastIndexOf("."));
				
				File newFile=new java.io.File(pic_path+newFileName);
				
				//将内存中的数据写入磁盘
				items_pic.transferTo(newFile);
				//将新图片写入名称itemsCustom中
				items.setPic(newFileName);
				
				
			}
			
			itemsService.addItems(items);
			
			
			
			
			return "forward:queryItems5.action";
		}
		
		
		
		
		
		
		
		
		//添加到购物车
		@RequestMapping("/addtobuycarSubmit")
		public String addtobuycarSubmit(HttpServletRequest request,Buycar buycar) throws Exception
		{
			itemsService.addtobuycar(buycar);
			
//			return "forward:queryItems5.action";
			return "success";
		}
		
		
		
		//购商品的信息填写
		@RequestMapping("/editbuy")
		public String editbuy(HttpSession request,Integer id) throws Exception
		{
			request.setAttribute("id",id);
			return "items/editbuy";
		}
		
		
		
		
		
		//购买商品
		@RequestMapping("/buySubmit")
		public String buySubmit(HttpSession request,Orders orders) throws Exception
		{
			
			Integer id=(Integer) request.getAttribute("id");
			
			itemsService.addtoorders(orders);
			   
			System.out.println(orders.getId());
			System.out.println(id);
			
			Orderdetail orderdetail=new Orderdetail();
			
			orderdetail.setOrdersId(orders.getId());
			orderdetail.setItemsId(id);			
			orderdetail.setItemsNum(1);
			itemsService.addtoorderdetail(orderdetail);

			return "success";
		}
		
		
		//我的购物车
		@RequestMapping("/querycar")
		public String querycar(HttpServletRequest request)throws Exception
		{
			List<Buycar> buycarList=itemsService.findfrombuycar();
			
			request.setAttribute("buycarList", buycarList);
			
			
			return "items/buycarshow";
		}
		
		
		
		//从购物车删除
		@RequestMapping("/deletebuycar")
		public String deletebuycar(HttpServletRequest request,Integer id)throws Exception
		{
			
			itemsService.deletebuycar(id);
			
			return "success";
		}
		
		
		
		//查询订单
		@RequestMapping("/queryorders")
		public String queryorders(HttpServletRequest request)throws Exception
		{
			
			

			
			
			
			
			
             List<Orders> orderList=itemsService.queryfromOrder();
			
			request.setAttribute("orderList", orderList);
			
			
			return "items/ordershow";
		}
		
		
		//从订单中删除
		@RequestMapping("/deleteorder")
		public String deleteorder(HttpServletRequest request,Integer id)throws Exception
		{
			
			itemsService.deleteorder(id);
			
			return "success";
		}
		
		
		//跳转到输入登陆账户，密码界面
		@RequestMapping("/login")
		public String login(HttpServletRequest request)throws Exception
		{
			
			
			return "administrators/login";
//			return "forward:queryItems6.action";
		}
		
		
		
		//登陆的判断
		@RequestMapping("/loginexamine")
		public String loginexamine(HttpServletRequest request,Administrator administrator)throws Exception
		{
		
			
			//输入的密码
			String password=administrator.getPassword();
			//从数据库查到的用户
			Administrator ad=itemsService.queryadmini1(administrator.getUsername());
			String msg="";
			
		    if(ad!=null&&ad.getPassword().equals(password))
			{
		    	return "forward:queryItems6.action";
			}
		  
		    else
		    {
		    	msg="输入错误，请重新输入";
		    	request.setAttribute("msg", msg);
		    	return "forward:login.action";
		    }
			
			
			
		}
		
		
		  //跳转到注册页面
	    @RequestMapping("/register")
		public String register(HttpServletRequest request)throws Exception
		{
			
			
			return "administrators/register";
//			return "forward:queryItems6.action";
		}
		
		
		
	  //注册的判断
	  		@RequestMapping("/registerexamine")
	  		public String registerexamine(HttpServletRequest request,Administrator administrator)throws Exception
	  		{
	  		
	  			
	  			
	  			//从数据库查到的用户
	  			Administrator ad=itemsService.queryadmini1(administrator.getUsername());
	  			String msg="";
	  			
	  		    if(ad!=null)
	  			{
	  		    	msg="用户已经存在，请更换用户名";
	  		    	request.setAttribute("msg", msg);
	  		    	return "forward:register.action";
	  		    	
	  			}
	  		  
	  		    else
	  		    {	  	
	  		    	itemsService.insertadmini(administrator);
	  		    	return "forward:login.action";
	  		    }
	  			
	  			
	  			
	  		}
		
		
		
		
		
		//删除商品
		@RequestMapping("/deletethisItem")
		public String deletethisItem(HttpServletRequest request,Integer id)throws Exception
		{
			
			itemsService.deleteitems(id);
			//重定向
			return "redirect:queryItems6.action";
		}
		
		
		
		
		
		
		//批量删除商品信息
		@RequestMapping("/deleteItems")
		public String deleteItems(Integer[] items_id)throws Exception
		{
			//调用service批量删除商品
			for(int i=0;i<items_id.length;i++)
			{
				System.out.println(items_id[i]);
				itemsService.deleteitems(items_id[i]);
			}
			return "success";
		}
		
		
		
		
		
		
		
}
