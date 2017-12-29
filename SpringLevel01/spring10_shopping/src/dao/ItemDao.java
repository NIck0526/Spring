package dao;

import java.util.List;

import logic.Item;

public interface ItemDao {
	
	List<Item> findAll(); //List jdbcTEmplate.query()
	
	Item findPrimaryKey(int itemId);
}
