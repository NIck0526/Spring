package ibatis.services.item.impl;

import java.util.List;

import ibatis.services.domain.Item;
import ibatis.services.item.ItemCatalog;
import ibatis.services.item.ItemDao;

public class ItemCatalogImpl implements ItemCatalog{	
	
	private ItemDao itemDao;
		
	public void setItemDao(ItemDao itemDao) {
		this.itemDao = itemDao;
	}

	public Item findPrimaryKey(int itemId) throws Exception {
			Item result = itemDao.findPrimaryKey(itemId);
		
			return result;
	}

	public List<Item> findItemList() {
		List<Item> list = itemDao.findItemList();
		return list;
	}

	
}








