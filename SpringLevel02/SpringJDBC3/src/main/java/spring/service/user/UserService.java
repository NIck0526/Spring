package spring.service.user;

import java.util.List;

import spring.service.domain.User;
/*
 * Dao �κ��� �Ϻ��� �ۼ��Ǿ��ٸ�
 * ������ Service Layer�� �Ѿ�´�.
 * ::
 *  CRUD ������ �߿��� Service Layer�� ���� ������ ������ �ִ� �κ���? R
 *  CRUD ������ �߿��� Service Layer�� ���� ������ ���� �κ���? D
 */
public interface UserService {
	void addUser(User user) throws Exception; //int
	User getUser(String userId)throws Exception;
	void updateUser(User user) throws Exception; //int
	List<User> getUserList(User user)throws Exception;
}
