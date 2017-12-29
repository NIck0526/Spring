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

import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;

import spring.service.domain.User;
import spring.service.user.UserDao;

public class SpringJdbcUserDaoImpl02 implements UserDao{

	private JdbcTemplate jdbcTemplate;
	private NamedParameterJdbcTemplate namedParameterJdbcTemplate;
		
	
	public SpringJdbcUserDaoImpl02(){
		System.out.println("::"+getClass().getName()+" Default Contructor Call...");
	}
	public void setJdbcTemplate(JdbcTemplate jdbcTemplate) {
		this.jdbcTemplate = jdbcTemplate;
	}

	public void setNamedParameterJdbcTemplate(NamedParameterJdbcTemplate namedParameterJdbcTemplate) {
		this.namedParameterJdbcTemplate = namedParameterJdbcTemplate;
	}
	
	///Method
	//==> ȸ������ ::  INSERT ( ȸ������ )
	public int addUser(User user)  throws Exception{
		StringBuffer userInsert = new StringBuffer();
		userInsert.append("INSERT ");
		userInsert.append("INTO users (user_id, user_name, password, age, reg_date)");
		userInsert.append("VALUES(?,?,?,?,?)");
		
		Object[ ] args = new Object[ ]{
				user.getUserId(),
				user.getUserName(),
				user.getPassword(),
				user.getAge(),
				user.getRegDate()
		};
		return jdbcTemplate.update(userInsert.toString(), args);
	}	
			
	//==> ȸ������ ::  SELECT  ( ȸ������ �˻� ) 
		public User getUser(String userId) throws Exception {
			StringBuffer userSelect = new StringBuffer();
			userSelect.append("SELECT ");
			userSelect.append("user_id, user_name, password, age, reg_date ");
			userSelect.append("FROM users WHERE user_id=?");
			
					
			Object[ ] args = new Object[ ]{userId};
			
			return (User) jdbcTemplate.queryForObject
					(userSelect.toString(), args, new RowMapper() {
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
			StringBuffer userUpdate = new StringBuffer();
			userUpdate.append("UPDATE users ");
			//userUpdate.append("SET user_name = ?,password=?,age=? ");
			userUpdate.append("SET user_name =:name,password=:password,age=:age ");
			//userUpdate.append("WHERE user_id=?");
			userUpdate.append("WHERE user_id=:id");
			
		//	NamedParameterJdbcTemplate �� �Ķ������ ���ε��Ǵ� ������ �߿����� �ʴ�(���� :: Map���)
				
			
			Map paramMap = new HashMap();
			paramMap.put("name", user.getUserName());
			paramMap.put("password", user.getPassword());
			paramMap.put("age", user.getAge());
			paramMap.put("id", user.getUserId());
			
			return namedParameterJdbcTemplate.update(userUpdate.toString(), paramMap);
			
		}	
		
		//==> ȸ������ ::  DELETE  ( ȸ������ ���� )
		public int removeUser(String userId) throws Exception{
			StringBuffer  userDelete = new StringBuffer();
			userDelete.append("DELETE ");
			userDelete.append("FROM USERS ");
			userDelete.append("WHERE user_id=:id");			
			
			Map paramMap = new HashMap();
			paramMap.put("id", userId);
			
			return namedParameterJdbcTemplate.update(userDelete.toString(),paramMap);
			
		}//end of class
		
		
		//==> ȸ������ ::  SELECT  ( ��� ȸ�� ���� �˻� )
		public List<User> getUserList() throws Exception {
			String userSelectAll = new String("SELECT * FROM users");
			
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
			return jdbcTemplate.query(userSelectAll, rowMapper);
		}//end of Method	
	}//end of class

/*
 * ������ ::
 * �ʵ尡 �߰� �ɋ�����
 * setter() | �������������� property �κ��� ��������� �þ��.
 * Dao�� �����κ��� �������� ����
 * MemberDao, ProductDao, BoatDao, CustomerDao~~~~~~
 * ���ʰ��� Dao���� �ʵ尡 ������ ��������� ����, �����ȴٸ�...
 * �ڵ��� ���뼺�� �����ϰ� ������ �� �ִ�
 * 
 * �ذ��� ::
 * DataSource�� JdbcTemplate�� �̹� ������ �ִ�
 * JdbcDaoSupport�� ��ӹ޾Ƽ� �������
 */




















