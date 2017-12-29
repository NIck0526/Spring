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
 * �ش� 04������ ��� �������� �ܺ� ��������� ���ȭ ���״�.
 */
public class SpringJdbcUserDaoImpl04 extends JdbcDaoSupport implements UserDao{

	private MessageSourceAccessor messageSourceAccessor;
		
	
	public void setMessageSourceAccessor(MessageSourceAccessor messageSourceAccessor) {
		System.out.println(":: "+getClass().getName()+".setMessageSourceAccessor");
		this.messageSourceAccessor = messageSourceAccessor;
	}


	public SpringJdbcUserDaoImpl04(){
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
		return getJdbcTemplate().update(messageSourceAccessor.getMessage("user.sql.insert"), args);
	}	
			
	//==> ȸ������ ::  SELECT  ( ȸ������ �˻� ) 
		public User getUser(String userId) throws Exception {
		
			
					
			Object[ ] args = new Object[ ]{userId};
			
			return (User) getJdbcTemplate().queryForObject
					(messageSourceAccessor.getMessage("user.sql.select"), args, new RowMapper() {
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
			
			return getJdbcTemplate().update(messageSourceAccessor.getMessage("user.sql.update"), args);
			
		}	
		
		//==> ȸ������ ::  DELETE  ( ȸ������ ���� )
		public int removeUser(String userId) throws Exception{
				
			
			
			return getJdbcTemplate().update(messageSourceAccessor.getMessage("user.sql.delete"),userId);
			
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
			return getJdbcTemplate().query(messageSourceAccessor.getMessage("user.sql.selectAll"), rowMapper);
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




















