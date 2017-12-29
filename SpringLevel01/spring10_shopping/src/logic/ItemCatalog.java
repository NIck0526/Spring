package logic;

import java.util.List;

public interface ItemCatalog {

	List<Item> findAll();
	
	Item findPrimaryKey(int itemId);
}
