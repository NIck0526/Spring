package jdbc2;
import java.sql.ResultSet;
import java.sql.SQLException;
/*
 * Spring JDBC 에서 제공하는 라이브러리를 이용헤서 비지니스 로직을 작성
 * 	SpringJdbcFramework에서 가장 핵심이 되는 클래스는 JdbcTemplate
 * ::
 * 1) DataSource를 setter()로 가진다.
 * 2) 쿼리문을 수행하는 메소드
 * 	 int update("") :: insert, update, delete을 수행
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
 * jdbc2에서 변경된 지점...
 * 1. BeanPropertyRowMapper를 바로 사용하자
 * 2. JdbcTemplate를 필드로 추가하지 말고,(has a relation)
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
		Object[] param = {id}; //object[]으로 넣어줘야함
		RowMapper<MemberVO> mapper = new BeanPropertyRowMapper<MemberVO>(MemberVO.class);
		
		return getJdbcTemplate().queryForObject(sql, mapper, param);
	}
}
