package logic;

import java.util.List;
public class ShopImpl implements Shop {

	
	private ItemCatalog itemCatalog;
	
	public void setItemCatalog(ItemCatalog itemCatalog) {
		this.itemCatalog = itemCatalog;
	}

	@Override
	public List<Item> findAll() {
		return itemCatalog.findAll();
	}

	@Override
	public Item getItemByItemId(Integer itemId) {
		return itemCatalog.getItemByItemId(itemId);
	}

}
