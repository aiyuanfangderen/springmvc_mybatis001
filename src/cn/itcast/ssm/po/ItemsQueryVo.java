package cn.itcast.ssm.po;
/**
 * ��Ʒ�İ�װ����
 * @author ch928
 *
 */
public class ItemsQueryVo 
{
    //��Ʒ��Ϣ
	private Items items;
	
	//Ϊ��ϵͳ����չ�ԣ���ԭʼ���ɵ�po��������չ
	private ItemsCustom itemsCustom;
	
	//�û���Ϣ
	private User user;
	
	//������Ϣ
	private Orders orders;
	
	//�û���Ϣ
//	private UserCustom userCustom;

	public Orders getOrders() {
		return orders;
	}

	public void setOrders(Orders orders) {
		this.orders = orders;
	}

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	public Items getItems() {
		return items;
	}

	public void setItems(Items items) {
		this.items = items;
	}

	public ItemsCustom getItemsCustom() {
		return itemsCustom;
	}

	public void setItemsCustom(ItemsCustom itemsCustom) {
		this.itemsCustom = itemsCustom;
	}

	
	
	
}
