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
 * ��Ʒ�Ĺ���ʵ����
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
		//ͨ��ItemsMapperCustom��ѯ���ݿ�
		return itemsMapperCustom.findItemsList(itemsQueryVo);
	}

	@Override
	public ItemsCustom findItemsById(Integer id) throws Exception 
	{
		Items items=itemsMapper.selectByPrimaryKey(id);
		
		ItemsCustom itemsCustom=new ItemsCustom();
		//��items������ֵ������itemsCustom
		BeanUtils.copyProperties(items, itemsCustom);
		
		
		
		return itemsCustom;
	}

	@Override
	public void updateItems(Integer id, ItemsCustom itemsCustom) throws Exception {
		//���ҵ����飬ͨ��service�ӿڶԹؼ���������У��
		//У��id�Ƿ�Ϊ�գ����Ϊ�վ��׳��쳣
		
		//updateByPrimaryKeyWithBLOBsҪ����봫��id
		itemsCustom.setId(id);
		//������Ʒ��Ϣ
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
