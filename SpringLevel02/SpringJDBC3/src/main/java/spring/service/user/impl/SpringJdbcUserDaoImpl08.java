package spring.service.user.impl;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import javax.annotation.Resource;

import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.core.support.JdbcDaoSupport;
import org.springframework.stereotype.Component;

import spring.service.domain.User;
import spring.service.user.SqlService;
import spring.service.user.UserDao;
/*
 * Dao�� SQL CODE�� ���� ������ �ʿ䰡 ����.
 * �� �۾��� �ϴ� Ŭ������ ���������� �ۼ��ϰ�
 * Dao�� ���Թ޾Ƽ� ���
 * ::
 * SqlService - SqlServiceI mpl06
 */

@Component
public class SpringJdbcUserDaoImpl08 extends JdbcDaoSupport implements UserDao{

	@Resource
	private SqlService sqlService;	
	
	

	public SpringJdbcUserDaoImpl08(){
		System.out.println("::"+getClass().getName()+" Default Contructor Call...");
	}
	
	
	///Method
	//==> ȸ������ ::  INSERT ( ȸ������ )
	public int addUser(User user)  throws Exception{
		
		Object[ ] args = new Object[ ]{
				user.getUserId(),
				user.getUserName(),
				user.getPassword(),
				user.getAge(),
				user.getRegDate()
		};
		return getJdbcTemplate().update(sqlService.getSql("user.sql.insert"), args);
	}	
			
	//==> ȸ������ ::  SELECT  ( ȸ������ �˻� ) 
		public User getUser(String userId) throws Exception {
								
			Object[ ] args = new Object[ ]{userId};
			
			return (User) getJdbcTemplate().queryForObject
					(sqlService.getSql("user.sql.select"), args, new RowMapper() {
						public Object mapRow(ResultSet rs, int arg1)
								throws SQLException {
							User user = new User();
							user.setUserId(rs.getString("user_id"));
							user.setUserName(rs.getString("user_name"));
							user.setPassword(rs.getString("password"));
							user.setAge(rs.getInt("age"));
							user.setRegDate(rs.getTimestamp("reg_date"));
							return user;
						}
					});
		}//end of method

		
		//==> ȸ������ ::  UPDATE  ( ȸ������ ����  )
		public int updateUser(User user) throws Exception {	
			
			Object[ ] args = {
					user.getUserName(),
					user.getPassword(),
					user.getAge(),
					user.getUserId()
			};		
			
			return getJdbcTemplate().update(sqlService.getSql("user.sql.update"), args);			
		}	
		
		//==> ȸ������ ::  DELETE  ( ȸ������ ���� )
		public int removeUser(String userId) throws Exception{				
					
			return getJdbcTemplate().update(sqlService.getSql("user.sql.delete"),userId);
			
		}//end of class
		
		
		//==> ȸ������ ::  SELECT  ( ��� ȸ�� ���� �˻� )
		public List<User> getUserList() throws Exception {
						
			RowMapper rowMapper = new RowMapper(){
				public Object mapRow(ResultSet rs, int arg1) throws SQLException {
					User user = new User();
					user.setUserId(rs.getString("user_id"));
					user.setUserName(rs.getString("user_name"));
					user.setPassword(rs.getString("password"));
					user.setAge(rs.getInt("age"));
					user.setRegDate(rs.getTimestamp("reg_date"));
					return user;
				}			
			};
			return getJdbcTemplate().query(sqlService.getSql("user.sql.selectAll"), rowMapper);
		}//end of Method	
	}//end of class

/*
 * ������ ::
DAO �ҽ��ڵ忡 SQL Query���� �Բ� �� �ִ�.
SQL Query���� ���ȭ / �ܺ� ��������� �̾Ƴ��ڴ�.
::
������������ ���̾ �ϴ� ����� �����ص־� �Ѵ�.
 
 -----------------------------------------------------------

�ذ��� ::
SpringJDBC Framrwork���� �����ϴ� ���̺귯�� Ŭ���� ���

 */




















