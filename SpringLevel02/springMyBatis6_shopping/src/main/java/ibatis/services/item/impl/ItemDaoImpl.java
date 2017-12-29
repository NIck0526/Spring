package ibatis.services.item.impl;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.springframework.jdbc.core.support.JdbcDaoSupport;

import ibatis.services.domain.Item;
import ibatis.services.item.ItemDao;

public class ItemDaoImpl extends JdbcDaoSupport  implements ItemDao{
	
	private SqlSession sqlSession;

	public void setSqlSession(SqlSession sqlSession) {
		System.out.println(":: "+getClass().getName()+".setSqlSession() call....");;
		this.sqlSession = sqlSession;
	}

	public Item findPrimaryKey(int itemId) throws Exception {
		
		return sqlSession.selectOne("itemMapper.findItem", itemId);
	}

	public List<Item> findItemList() {
		
		return sqlSession.selectList("itemMapper.findItemList");
	}
	
	
	
}














