package dao;

import java.util.List;

import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.core.support.JdbcDaoSupport;

import logic.Item;

public class ItemDaoImpl  extends JdbcDaoSupport implements ItemDao {
	
	private static final String SELECT_ALL ="select * from item";
	private static final String SELECT_BY_PRIMARY_KEY="select * from item WHERE itemId=?";
	
	@Override
	public List<Item> findAll() {
		RowMapper<Item> mapper = new BeanPropertyRowMapper<Item>(Item.class);
		return getJdbcTemplate().query(SELECT_ALL, mapper);
	}
	
	@Override
	public Item findPrimaryKey(int itemId) {

		RowMapper<Item> mapper = new BeanPropertyRowMapper<Item>(Item.class);
		
		
		return getJdbcTemplate().queryForObject(SELECT_BY_PRIMARY_KEY, mapper, itemId);
	}

}
