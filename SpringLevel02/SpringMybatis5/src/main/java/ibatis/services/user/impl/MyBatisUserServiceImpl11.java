package ibatis.services.user.impl;

import java.util.List;

import ibatis.services.domain.User;
import ibatis.services.user.UserDAO;
import ibatis.services.user.UserService;

public class MyBatisUserServiceImpl11 implements UserService{

	private UserDAO userDAO;
	
	public void setUserDAO(UserDAO userDAO) {
		this.userDAO = userDAO;
	}

	public void addUser(User user) throws Exception {
		userDAO.addUser(user);
		
	}

	public void updateUser(User user) throws Exception {
		userDAO.updateUser(user);
				
	}

	public User getUser(String id) throws Exception {
		User result = userDAO.getUser(id);
		return result;
	}

	public List<User> getUserList(User user) throws Exception {
		List<User> list = userDAO.getUserList(user);
		return list;
	}

}
