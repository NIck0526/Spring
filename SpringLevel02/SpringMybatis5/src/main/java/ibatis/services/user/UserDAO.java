package ibatis.services.user;

import java.util.List;

import ibatis.services.domain.User;
//mapper.xml 에서의 id값과 메소드이름을 일치시킨다.
public interface UserDAO {
	
	int addUser(User user) throws Exception;
	int updateUser(User user) throws Exception;
	int removeUser(String id) throws Exception;
	User getUser(String id) throws Exception;
	List<User> getUserList(User user) throws Exception;
	
}
