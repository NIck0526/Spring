package logic;

import java.util.List;

public interface ItemCatalog {
	List<Item>  findAll();  
	//Ãß°¡
	Item getItemByItemId(Integer itemId);
}
