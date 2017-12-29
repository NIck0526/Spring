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
 * 해당 04에서는 모든 쿼리문을 외부 상수값으로 모듈화 시켰다.
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
	//==> 회원정보 ::  INSERT ( 회원가입 )
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
			
	//==> 회원정보 ::  SELECT  ( 회원정보 검색 ) 
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

		
		//==> 회원정보 ::  UPDATE  ( 회원정보 변경  )
		public int updateUser(User user) throws Exception {
			
		
			
			Object[ ] args = {
					user.getUserName(),
					user.getPassword(),
					user.getAge(),
					user.getUserId()
			};
			
			return getJdbcTemplate().update(messageSourceAccessor.getMessage("user.sql.update"), args);
			
		}	
		
		//==> 회원정보 ::  DELETE  ( 회원정보 삭제 )
		public int removeUser(String userId) throws Exception{
				
			
			
			return getJdbcTemplate().update(messageSourceAccessor.getMessage("user.sql.delete"),userId);
			
		}//end of class
		
		
		//==> 회원정보 ::  SELECT  ( 모든 회원 정보 검색 )
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
 * 문제점 ::
 * Dao 소스코드에 SQL Query 문이 함께 들어가 있다.
 * SQl Query문을 모듈화 / 외부 상수값으로 뽑아낸다
 * ::
 * 설정문서에서 와이어링 하는 방법을 생각해둬야 한다.
 * -------------------------------------------------
 * 
 * 해결방법 ::
 * SpringJDBC Framework 에서 제공하는 라이브러리 클래스 사용
 */




















