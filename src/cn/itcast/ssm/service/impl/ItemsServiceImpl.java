package cn.itcast.ssm.service.impl;

import java.util.List;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;

import cn.itcast.ssm.mapper.ItemsMapper;
import cn.itcast.ssm.mapper.ItemsMapperCustom;
import cn.itcast.ssm.po.Administrator;
import cn.itcast.ssm.po.Buycar;
import cn.itcast.ssm.po.Items;
import cn.itcast.ssm.po.ItemsCustom;
import cn.itcast.ssm.po.ItemsQueryVo;
import cn.itcast.ssm.po.Orderdetail;
import cn.itcast.ssm.po.Orders;
import cn.itcast.ssm.service.ItemsService;

/**
 * 商品的管理实现类
 * @author ch928
 *
 */
public class ItemsServiceImpl implements ItemsService
{
	@Autowired
	private ItemsMapperCustom itemsMapperCustom;

	
	
	@Autowired
	private ItemsMapper itemsMapper;
	
	@Override
	public List<ItemsCustom> findItemsList(ItemsQueryVo itemsQueryVo) throws Exception {
		//通过ItemsMapperCustom查询数据库
		return itemsMapperCustom.findItemsList(itemsQueryVo);
	}

	@Override
	public ItemsCustom findItemsById(Integer id) throws Exception 
	{
		Items items=itemsMapper.selectByPrimaryKey(id);
		
		ItemsCustom itemsCustom=new ItemsCustom();
		//将items的属性值拷贝到itemsCustom
		BeanUtils.copyProperties(items, itemsCustom);
		
		
		
		return itemsCustom;
	}

	@Override
	public void updateItems(Integer id, ItemsCustom itemsCustom) throws Exception {
		//添加业务检验，通常service接口对关键参数进行校验
		//校验id是否为空，如果为空就抛出异常
		
		//updateByPrimaryKeyWithBLOBs要求必须传入id
		itemsCustom.setId(id);
		//更新商品信息
		itemsMapper.updateByPrimaryKey(itemsCustom);
		
	}

	@Override
	public void addItems(Items items) throws Exception {
		itemsMapperCustom.insertItemsList(items);
		
	}

	@Override
	public void addtobuycar(Buycar buycar) throws Exception
	{
		itemsMapperCustom.inserttobuycar(buycar);
		
	}

	@Override
	public void addtoorders(Orders orders) throws Exception 
	{
		itemsMapperCustom.insertorders(orders);
		
	}

	@Override
	public void addtoorderdetail(Orderdetail orderdetail) throws Exception
	{
		itemsMapperCustom.insertorderdetail(orderdetail);
		
	}

	@Override
	public List<Buycar> findfrombuycar() throws Exception {
		
		return itemsMapperCustom.queryfromcar();
	}

	@Override
	public void deletebuycar(Integer id) throws Exception {
		
		itemsMapperCustom.deletefrombuycar(id);
	}

	@Override
	public List<Orders> queryfromOrder() throws Exception {
		
		return itemsMapperCustom.queryallorders();
	}

	@Override
	public void deleteorder(Integer id) throws Exception {
	 itemsMapperCustom.deletefromOrders(id);
		
	}

	@Override
	public void deleteitems(Integer id) throws Exception
	{
		itemsMapperCustom.deletetheitem(id);
		
	}

	

	@Override
	public Administrator queryadmini1(String username) throws Exception {
		
		return itemsMapperCustom.queryadministrator1(username);
	}

	@Override
	public void insertadmini(Administrator administrator) throws Exception {
		itemsMapperCustom.insertadministrator(administrator);
		
	}

	
	

	

	

}
