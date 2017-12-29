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

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.support.MessageSourceAccessor;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.jdbc.core.support.JdbcDaoSupport;

import spring.service.domain.User;
import spring.service.user.SqlService;
import spring.service.user.UserDao;
/*
 * Dao는 SQL CODE를 따로 관리할 필요가 없다.
 * 이 작업을 하는 클래스를 독자적으로 작성하고
 * Dao가 주입받아서 사용
 * ::
 * SqlService - SqlServiceI mpl06
 */
public class SpringJdbcUserDaoImpl06 extends JdbcDaoSupport implements UserDao{

	private SqlService sqlService;	
	
	public void setSqlService(SqlService sqlService) {
		this.sqlService = sqlService;
	}

	public SpringJdbcUserDaoImpl06(){
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
		return getJdbcTemplate().update(sqlService.getSql("user.sql.insert"), args);
	}	
			
	//==> 회원정보 ::  SELECT  ( 회원정보 검색 ) 
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

		
		//==> 회원정보 ::  UPDATE  ( 회원정보 변경  )
		public int updateUser(User user) throws Exception {	
			
			Object[ ] args = {
					user.getUserName(),
					user.getPassword(),
					user.getAge(),
					user.getUserId()
			};		
			
			return getJdbcTemplate().update(sqlService.getSql("user.sql.update"), args);			
		}	
		
		//==> 회원정보 ::  DELETE  ( 회원정보 삭제 )
		public int removeUser(String userId) throws Exception{				
					
			return getJdbcTemplate().update(sqlService.getSql("user.sql.delete"),userId);
			
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
			return getJdbcTemplate().query(sqlService.getSql("user.sql.selectAll"), rowMapper);
		}//end of Method	
	}//end of class

/*
 * 문제점 ::
DAO 소스코드에 SQL Query문이 함께 들어가 있다.
SQL Query문을 모듈화 / 외부 상수값으로 뽑아내겠다.
::
설정문서에서 와이어링 하는 방법을 생각해둬야 한다.
 
 -----------------------------------------------------------

해결방법 ::
SpringJDBC Framrwork에서 제공하는 라이브러리 클래스 사용

 */




















