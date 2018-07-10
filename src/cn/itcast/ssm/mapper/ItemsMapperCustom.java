package cn.itcast.ssm.mapper;

import cn.itcast.ssm.po.Administrator;
import cn.itcast.ssm.po.Buycar;
import cn.itcast.ssm.po.Items;
import cn.itcast.ssm.po.ItemsCustom;
import cn.itcast.ssm.po.ItemsExample;
import cn.itcast.ssm.po.ItemsQueryVo;
import cn.itcast.ssm.po.Orderdetail;
import cn.itcast.ssm.po.Orders;

import java.util.List;
import org.apache.ibatis.annotations.Param;
import org.apache.logging.log4j.core.config.Order;

public interface ItemsMapperCustom 
{
    //商品查询列表
	public List<ItemsCustom> findItemsList(ItemsQueryVo itemsQueryVo)throws Exception;
	
	public void insertItemsList(Items items) throws Exception;
	
	
	public void inserttobuycar(Buycar buycar) throws Exception;
	
	
	public void insertorders(Orders orders) throws Exception;
	
	public void insertorderdetail(Orderdetail orderdetail) throws Exception;
	
	
	public List<Buycar> queryfromcar() throws Exception;
	
	public void deletefrombuycar(Integer id) throws Exception;
	
	public List<Orders> queryallorders() throws Exception;
	
	
	
	
	
	public void deletefromOrders(Integer id) throws Exception;
	
	
	public void deletetheitem(Integer id) throws Exception;
	
	
	
	public Administrator queryadministrator1(String username) throws Exception;
	
	public void insertadministrator(Administrator administrator) throws Exception;
	
	
	
	
	
	
}