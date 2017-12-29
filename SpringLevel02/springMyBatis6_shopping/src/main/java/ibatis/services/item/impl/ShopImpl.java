package ibatis.services.item.impl;

import java.util.List;

import ibatis.services.domain.Item;
import ibatis.services.item.ItemCatalog;
import ibatis.services.item.Shop;
public class ShopImpl implements Shop {

	private ItemCatalog itemCatalog;
		
	

	public void setItemCatalog(ItemCatalog itemCatalog) {
		this.itemCatalog = itemCatalog;
	}



	public Item findPrimaryKey(int itemId) throws Exception {
			Item result = itemCatalog.findPrimaryKey(itemId);
			
		return result;
	}



	public List<Item> findItemList() {
		List<Item> list = itemCatalog.findItemList();
		return list;
	}

	

}
