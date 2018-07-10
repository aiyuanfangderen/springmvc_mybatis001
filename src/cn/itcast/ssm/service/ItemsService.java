package cn.itcast.ssm.service;

import java.util.List;

import org.omg.CORBA.PUBLIC_MEMBER;

import cn.itcast.ssm.po.Administrator;
import cn.itcast.ssm.po.Buycar;
import cn.itcast.ssm.po.Items;
import cn.itcast.ssm.po.ItemsCustom;
import cn.itcast.ssm.po.ItemsQueryVo;
import cn.itcast.ssm.po.Orderdetail;
import cn.itcast.ssm.po.Orders;

/**
 * ��Ʒ����service
 * @author ch928
 *
 */
public interface ItemsService 
{
	//��Ʒ��ѯ�б�
    public List<ItemsCustom> findItemsList(ItemsQueryVo itemsQueryVo) throws Exception;
    
    //����id��ѯ��Ʒ��Ϣ
    public ItemsCustom findItemsById(Integer id) throws Exception;
    //�޸���Ʒ��Ϣ
    /**
     * 
     * @param id�޸���Ʒ��id
     * @param itemsCustom�޸ĵ���Ʒ��Ϣ
     * @throws Exception
     */
    public void updateItems(Integer id,ItemsCustom itemsCustom) throws Exception;
    
    //�����Ʒ
    public void addItems(Items items) throws Exception;
    
    //�����Ʒ�����ﳵ
    public void addtobuycar(Buycar buycar) throws Exception;
    
    public void addtoorders(Orders orders) throws Exception;
    
    public void addtoorderdetail(Orderdetail orderdetail) throws Exception;
    
    public List<Buycar> findfrombuycar() throws Exception;
    
    public void deletebuycar(Integer id) throws Exception;
    
    public List<Orders> queryfromOrder() throws Exception;
    
    
   
    
    
    
    public void deleteorder(Integer id) throws Exception;
    
    public void deleteitems(Integer id) throws Exception;
    
   
    
    public Administrator queryadmini1(String username) throws Exception;
    
    
    public void insertadmini(Administrator administrator) throws Exception;
    
    
    
    
    
    
}
