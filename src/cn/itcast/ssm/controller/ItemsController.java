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
 * ��Ʒ��Controller
 * @author ch928
 *
 */
@Controller
//Ϊ�˶�url���з���������������ﶨ���·��
//���磺��Ʒ�б�/items/queryItems.action
@RequestMapping("/items")
public class ItemsController 
{
	@Autowired
	private ItemsService itemsService;
    //��Ʒ�Ĳ�ѯ
	
		//@RequestMappingʵ�ֶ�queryItems������url����ӳ�䣬һ��������Ӧһ��url
		//һ�㽨�齫url�ͷ���д��һ����������Ϊ�ͷ�ע���һ��urlһ����������΢��һ��
		@RequestMapping("/queryItems5")
		public ModelAndView queryItems(HttpServletRequest request,ItemsQueryVo itemsQueryVo) throws Exception
		{
			//����forward��request�Ƿ���Թ���
			System.out.println(request.getParameter("id"));
			//����sevvice��ѯ���ݿ⣬��ѯ��Ʒ�б�����ʹ�þ�̬����ģ��
			 List<ItemsCustom> itemsList=itemsService.findItemsList(itemsQueryVo);
		      
		     
			
			
			
			//����modelandview
			 ModelAndView modelAndView=new ModelAndView();
			 //�䵥��request��setAttribut����jspҳ��ͨ��iemsListȡ����
			 modelAndView.addObject("itemsList", itemsList);
			 
			 //ָ����ͼ
			 modelAndView.setViewName("items/itemsList");
			 return modelAndView;			 
			 //���Զ�����������
			 //��Ʒ��ӣ���Ʒɾ��		 
		}
		
		
		
		//����Ա�Ĳ�ѯ����
		@RequestMapping("/queryItems6")
		public ModelAndView queryItems6(HttpServletRequest request,ItemsQueryVo itemsQueryVo) throws Exception
		{
			//����forward��request�Ƿ���Թ���
			System.out.println(request.getParameter("id"));
			//����sevvice��ѯ���ݿ⣬��ѯ��Ʒ�б�����ʹ�þ�̬����ģ��
			 List<ItemsCustom> itemsList=itemsService.findItemsList(itemsQueryVo);
		      
		     
			
			
			
			//����modelandview
			 ModelAndView modelAndView=new ModelAndView();
			 //�䵥��request��setAttribut����jspҳ��ͨ��iemsListȡ����
			 modelAndView.addObject("itemsList", itemsList);
			 
			 //ָ����ͼ
			 modelAndView.setViewName("administrators/administrator");
			 return modelAndView;
			 
			 
			 //���Զ�����������
			 //��Ʒ��ӣ���Ʒɾ��
			 
		}
		
		
		
		
		
		
		
		
		
	//��Ʒ����Ϣ�޸�ҳ����ʾ
		//����http���󷽷�
//		@RequestMapping("/editItems")
//		public ModelAndView editItems() throws Exception
//		{
//			//����service������Ʒid��ѯ��Ʒ��Ϣ
//			ItemsCustom itemsCustom=itemsService.findItemsById(1);
//			
//			//����modelandview
//			 ModelAndView modelAndView=new ModelAndView();
//			 
//			 //����Ʒ��Ϣ�ŵ�model
//			 modelAndView.addObject("itemsCustom", itemsCustom);
//			 
//			//ָ����ͼ
//			 modelAndView.setViewName("items/editItems");
//			 
//			 
//			 return modelAndView;
//		}
		
		
		
		
		//��Ʒ����Ϣ�޸�ҳ����ʾ
		@RequestMapping(value="/editItems",method={RequestMethod.POST,RequestMethod.GET})
		//@RequestParam����ָ��request����������ƺ��βν��а�
		//ͨ��request����ָ�������Ƿ����Ҫ����
		public String editItems(Model model,@RequestParam(value="id",required=true)Integer items_id) throws Exception
		{
			//����service������Ʒid��ѯ��Ʒ��Ϣ
			ItemsCustom itemsCustom=itemsService.findItemsById(items_id);
			
			//����modelandview
//			 ModelAndView modelAndView=new ModelAndView();
//			 
//			 //����Ʒ��Ϣ�ŵ�model
//			 modelAndView.addObject("itemsCustom", itemsCustom);
//			 
//			//ָ����ͼ
//			 modelAndView.setViewName("items/editItems");
			 //ͨ���β��е�model��model���ݴ���ҳ��
			model.addAttribute("itemsCustom", itemsCustom);
			 
			 return "items/editItems";
		}
		
		
		
		
		
			
		
		//��Ʒ��Ϣ�޸��ύ
		@RequestMapping("/editItemsSubmit")
		public String editItemsSubmit(HttpServletRequest request,Integer id,ItemsCustom itemsCustom,
				MultipartFile items_pic//������Ʒ��ͼƬ
				) throws Exception
		{
//			ModelAndView modelAndView=new ModelAndView();
//			 //����һ���ɹ�ҳ��
//			modelAndView.setViewName("success");
			
			//ͼƬ��ԭʼ����
			String originalFilename=items_pic.getOriginalFilename();
			
			//�ϴ�ͼƬ
			if(items_pic!=null&&originalFilename!=null&&originalFilename.length()>0)
			{
				String pic_path="E:\\upload\\temp\\";
				
				
				//�µ�ͼƬ����
				String newFileName=UUID.randomUUID()+originalFilename.substring(originalFilename.lastIndexOf("."));
				
				File newFile=new java.io.File(pic_path+newFileName);
				
				//���ڴ��е�����д�����
				items_pic.transferTo(newFile);
				//����ͼƬд������itemsCustom��
				itemsCustom.setPic(newFileName);
				
						
			}
			
			else
			{
               ItemsCustom itemsCustom1=itemsService.findItemsById(itemsCustom.getId());
				
				itemsCustom.setPic(itemsCustom1.getPic());
			}
			
			
			
			
			
			
			//����service������Ʒ��Ϣ��ҳ����Ҫ����Ʒ�����˷���
			itemsService.updateItems(id, itemsCustom);
			
			
			//ת��
			return "redirect:queryItems6.action";
//			 return modelAndView;
		}
		
		
		//��Ʒ�����ҳ��
		@RequestMapping("/insertItems")
		public String insertItems(HttpServletRequest request) throws Exception
		{
				 
			return "items/add";
		}
		
		
		
		
		
		
		//��Ʒ����ύ
		@RequestMapping("/addItemsSubmit")
		public String addItemsSubmit(HttpServletRequest request,Items items,
				MultipartFile items_pic//����ͼƬ
				) throws Exception
		{
			//ͼƬ��ԭʼ����
			String originalFilename=items_pic.getOriginalFilename();
			
			//�ϴ�ͼƬ
			if(items_pic!=null&&originalFilename!=null&&originalFilename.length()>0)
			{
				String pic_path="E:\\upload\\temp\\";
				
				
				//�µ�ͼƬ����
				String newFileName=UUID.randomUUID()+originalFilename.substring(originalFilename.lastIndexOf("."));
				
				File newFile=new java.io.File(pic_path+newFileName);
				
				//���ڴ��е�����д�����
				items_pic.transferTo(newFile);
				//����ͼƬд������itemsCustom��
				items.setPic(newFileName);
				
				
			}
			
			itemsService.addItems(items);
			
			
			
			
			return "forward:queryItems5.action";
		}
		
		
		
		
		
		
		
		
		//��ӵ����ﳵ
		@RequestMapping("/addtobuycarSubmit")
		public String addtobuycarSubmit(HttpServletRequest request,Buycar buycar) throws Exception
		{
			itemsService.addtobuycar(buycar);
			
//			return "forward:queryItems5.action";
			return "success";
		}
		
		
		
		//����Ʒ����Ϣ��д
		@RequestMapping("/editbuy")
		public String editbuy(HttpSession request,Integer id) throws Exception
		{
			request.setAttribute("id",id);
			return "items/editbuy";
		}
		
		
		
		
		
		//������Ʒ
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
		
		
		//�ҵĹ��ﳵ
		@RequestMapping("/querycar")
		public String querycar(HttpServletRequest request)throws Exception
		{
			List<Buycar> buycarList=itemsService.findfrombuycar();
			
			request.setAttribute("buycarList", buycarList);
			
			
			return "items/buycarshow";
		}
		
		
		
		//�ӹ��ﳵɾ��
		@RequestMapping("/deletebuycar")
		public String deletebuycar(HttpServletRequest request,Integer id)throws Exception
		{
			
			itemsService.deletebuycar(id);
			
			return "success";
		}
		
		
		
		//��ѯ����
		@RequestMapping("/queryorders")
		public String queryorders(HttpServletRequest request)throws Exception
		{
			
			

			
			
			
			
			
             List<Orders> orderList=itemsService.queryfromOrder();
			
			request.setAttribute("orderList", orderList);
			
			
			return "items/ordershow";
		}
		
		
		//�Ӷ�����ɾ��
		@RequestMapping("/deleteorder")
		public String deleteorder(HttpServletRequest request,Integer id)throws Exception
		{
			
			itemsService.deleteorder(id);
			
			return "success";
		}
		
		
		//��ת�������½�˻����������
		@RequestMapping("/login")
		public String login(HttpServletRequest request)throws Exception
		{
			
			
			return "administrators/login";
//			return "forward:queryItems6.action";
		}
		
		
		
		//��½���ж�
		@RequestMapping("/loginexamine")
		public String loginexamine(HttpServletRequest request,Administrator administrator)throws Exception
		{
		
			
			//���������
			String password=administrator.getPassword();
			//�����ݿ�鵽���û�
			Administrator ad=itemsService.queryadmini1(administrator.getUsername());
			String msg="";
			
		    if(ad!=null&&ad.getPassword().equals(password))
			{
		    	return "forward:queryItems6.action";
			}
		  
		    else
		    {
		    	msg="�����������������";
		    	request.setAttribute("msg", msg);
		    	return "forward:login.action";
		    }
			
			
			
		}
		
		
		  //��ת��ע��ҳ��
	    @RequestMapping("/register")
		public String register(HttpServletRequest request)throws Exception
		{
			
			
			return "administrators/register";
//			return "forward:queryItems6.action";
		}
		
		
		
	  //ע����ж�
	  		@RequestMapping("/registerexamine")
	  		public String registerexamine(HttpServletRequest request,Administrator administrator)throws Exception
	  		{
	  		
	  			
	  			
	  			//�����ݿ�鵽���û�
	  			Administrator ad=itemsService.queryadmini1(administrator.getUsername());
	  			String msg="";
	  			
	  		    if(ad!=null)
	  			{
	  		    	msg="�û��Ѿ����ڣ�������û���";
	  		    	request.setAttribute("msg", msg);
	  		    	return "forward:register.action";
	  		    	
	  			}
	  		  
	  		    else
	  		    {	  	
	  		    	itemsService.insertadmini(administrator);
	  		    	return "forward:login.action";
	  		    }
	  			
	  			
	  			
	  		}
		
		
		
		
		
		//ɾ����Ʒ
		@RequestMapping("/deletethisItem")
		public String deletethisItem(HttpServletRequest request,Integer id)throws Exception
		{
			
			itemsService.deleteitems(id);
			//�ض���
			return "redirect:queryItems6.action";
		}
		
		
		
		
		
		
		//����ɾ����Ʒ��Ϣ
		@RequestMapping("/deleteItems")
		public String deleteItems(Integer[] items_id)throws Exception
		{
			//����service����ɾ����Ʒ
			for(int i=0;i<items_id.length;i++)
			{
				System.out.println(items_id[i]);
				itemsService.deleteitems(items_id[i]);
			}
			return "success";
		}
		
		
		
		
		
		
		
}
