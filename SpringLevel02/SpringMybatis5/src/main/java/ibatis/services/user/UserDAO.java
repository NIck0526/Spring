package ibatis.services.user;

import java.util.List;

import ibatis.services.domain.User;
//mapper.xml ������ id���� �޼ҵ��̸��� ��ġ��Ų��.
public interface UserDAO {
	
	int addUser(User user) throws Exception;
	int updateUser(User user) throws Exception;
	int removeUser(String id) throws Exception;
	User getUser(String id) throws Exception;
	List<User> getUserList(User user) throws Exception;
	
}
