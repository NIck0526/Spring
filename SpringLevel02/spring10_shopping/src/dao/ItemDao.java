package dao;

import java.util.List;

import logic.Item;

public interface ItemDao {
	
	List<Item>  findAll();  	//  List jdbcTemplate.query()
	//�߰�
	Item findPrimaryKey(Integer itemId);
}
