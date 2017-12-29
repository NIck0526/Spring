package logic;

import java.util.List;

public interface Shop {
	List<Item> findAll();
	
	Item findPrimaryKey(int itemId);
}
