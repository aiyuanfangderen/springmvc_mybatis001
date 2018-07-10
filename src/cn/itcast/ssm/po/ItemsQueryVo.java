package cn.itcast.ssm.po;
/**
 * 商品的包装对象
 * @author ch928
 *
 */
public class ItemsQueryVo 
{
    //商品信息
	private Items items;
	
	//为了系统可扩展性，对原始生成的po将进行扩展
	private ItemsCustom itemsCustom;
	
	//用户信息
	private User user;
	
	//订单信息
	private Orders orders;
	
	//用户信息
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
