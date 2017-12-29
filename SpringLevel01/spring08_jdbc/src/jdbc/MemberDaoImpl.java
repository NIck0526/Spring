package jdbc;
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
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;

public class MemberDaoImpl implements MemberDao{
	@Autowired
	private JdbcTemplate jdbcTemplate;

	
	/*public void setJdbcTemplate(JdbcTemplate jdbcTemplate) {
		this.jdbcTemplate = jdbcTemplate;
	}*/
	
	@Override
	public void register(MemberVO vo) {
		StringBuffer sql = new StringBuffer();
		sql.append("INSERT INTO member VALUES(");
		sql.append("?,?,?,?)");
		
		Object[] param = { vo.getId(), vo.getPassword(), vo.getName(), vo.getAddress()};
		jdbcTemplate.update(sql.toString(),param);
		
	}
	
	@Override
	public List<MemberVO> getList() {
		String sql = "SELECT * FROM member";
		List<MemberVO> list =  jdbcTemplate.query(sql, new RowMapper() {

			@Override
			public Object mapRow(ResultSet rs, int arg1) throws SQLException {
				System.out.println("arg1 :: "+arg1);
				
				MemberVO vo = new MemberVO(rs.getString("id"),
											rs.getString("password"), 
											rs.getString("name"), 
											rs.getString("address"));
				return vo;
			}
		});
		return list;
	}
	
	
	
	@Override
	public MemberVO getSearch(String id) {
		String sql ="SELECT * FROM member WHERE id=?";
		Object[] param = {id}; //object[]���� �־������
		
		MemberVO v = (MemberVO)jdbcTemplate.queryForObject(sql, param, new RowMapper() {
		
			@Override
			public Object mapRow(ResultSet rs, int arg1) throws SQLException {
				
				MemberVO vo = new MemberVO(id,
											rs.getString("password"), 
											rs.getString("name"), 
											rs.getString("address"));
				
				return vo;
			}
		});
		return v;
	}
}
