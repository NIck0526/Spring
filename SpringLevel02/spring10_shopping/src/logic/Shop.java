package logic;

import java.util.List;

public interface Shop {
	List<Item>  findAll();  
	
	//Ãß°¡
	Item getItemByItemId(Integer itemId);
}
