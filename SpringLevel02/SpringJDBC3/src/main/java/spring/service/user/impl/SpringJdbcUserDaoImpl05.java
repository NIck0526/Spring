package spring.service.user.impl;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.sql.DataSource;

import org.springframework.context.support.MessageSourceAccessor;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.jdbc.core.support.JdbcDaoSupport;

import spring.service.domain.User;
import spring.service.user.UserDao;

/*
 * Map ����� ���
 * �ܺ�ȭ�� sql.properties ������ util:properties ��Ű���� �̿��ؼ�
 * ���������� ���̾ �ϴ� ����� ����ϰڴ�.
 * ::
 * sql code�� �����ϴ� ������Ʈ�� ���� ������..
 */
public class SpringJdbcUserDaoImpl05 extends JdbcDaoSupport implements UserDao{

	private Map<String, String> sqlMap;


	public void setSqlMap(Map<String, String> sqlMap) {
		this.sqlMap = sqlMap;
	}


	public SpringJdbcUserDaoImpl05(){
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
		return getJdbcTemplate().update(sqlMap.get("user.sql.insert"), args);
	}	
			
	//==> ȸ������ ::  SELECT  ( ȸ������ �˻� ) 
		public User getUser(String userId) throws Exception {
		
			
					
			Object[ ] args = new Object[ ]{userId};
			
			return (User) getJdbcTemplate().queryForObject
					(sqlMap.get("user.sql.select"), args, new RowMapper() {
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
			
			return getJdbcTemplate().update(sqlMap.get("user.sql.update"), args);
			
		}	
		
		//==> ȸ������ ::  DELETE  ( ȸ������ ���� )
		public int removeUser(String userId) throws Exception{
				
			
			
			return getJdbcTemplate().update(sqlMap.get("user.sql.delete"),userId);
			
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
			return getJdbcTemplate().query(sqlMap.get("user.sql.selectAll"), rowMapper);
		}//end of Method	
	}//end of class

/*
 * ������ ::
 * Dao �ҽ��ڵ忡 SQL Query ���� �Բ� �� �ִ�.
 * SQl Query���� ���ȭ / �ܺ� ��������� �̾Ƴ���
 * ::
 * ������������ ���̾ �ϴ� ����� �����ص־� �Ѵ�.
 * -------------------------------------------------
 * 
 * �ذ��� ::
 * SpringJDBC Framework ���� �����ϴ� ���̺귯�� Ŭ���� ���
 */




















