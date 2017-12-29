package logic;

import java.util.List;

import dao.ItemDao;

public class ItemCatalogImpl implements ItemCatalog{
	private ItemDao itemDao;
	
	
	public void setItemDao(ItemDao itemDao) {
		this.itemDao = itemDao;
	}


	@Override
	public List<Item> findAll() {
		
		return itemDao.findAll();
	}
	
	@Override
	public Item findPrimaryKey(int itemId) {
		
		return itemDao.findPrimaryKey(itemId);
	}
}
