package jdbc2;
import java.sql.ResultSet;
import java.sql.SQLException;
/*
 * Spring JDBC ���� �����ϴ� ���̺귯���� �̿��켭 �����Ͻ� ������ �ۼ�
 * 	SpringJdbcFramework���� ���� �ٽ��� �Ǵ� Ŭ������ JdbcTemplate
 * ::
 * 1) DataSource�� setter()�� ������.
 * 2) �������� �����ϴ� �޼ҵ�
 * 	 int update("") :: insert, update, delete�� ����
 * 	 queryForList() :: select * from member
 * 	 queryForOne() :: select * from where id=?
 * 
 */
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.core.support.JdbcDaoSupport;
/*
 * jdbc2���� ����� ����...
 * 1. BeanPropertyRowMapper�� �ٷ� �������
 * 2. JdbcTemplate�� �ʵ�� �߰����� ����,(has a relation)
 *    
 */
public class MemberDaoImpl extends JdbcDaoSupport implements MemberDao{
	
	
	
	@Override
	public void register(MemberVO vo) {
		StringBuffer sql = new StringBuffer();
		sql.append("INSERT INTO member VALUES(");
		sql.append("?,?,?,?)");
		
		Object[] param = { vo.getId(), vo.getPassword(), vo.getName(), vo.getAddress()};
		getJdbcTemplate().update(sql.toString(),param);
		
	}
	
	@Override
	public List<MemberVO> getList() {
		String sql = "SELECT * FROM member";
		
		RowMapper<MemberVO> mapper = new BeanPropertyRowMapper<MemberVO>(MemberVO.class); 
		
		return getJdbcTemplate().query(sql, mapper);
	}
	
	
	
	@Override
	public MemberVO getSearch(String id) {
		String sql ="SELECT * FROM member WHERE id=?";
		Object[] param = {id}; //object[]���� �־������
		RowMapper<MemberVO> mapper = new BeanPropertyRowMapper<MemberVO>(MemberVO.class);
		
		return getJdbcTemplate().queryForObject(sql, mapper, param);
	}
}
