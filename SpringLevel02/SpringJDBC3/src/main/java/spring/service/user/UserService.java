package spring.service.user;

import java.util.List;

import spring.service.domain.User;
/*
 * Dao 부분이 완벽히 작성되었다면
 * 이제는 Service Layer로 넘어온다.
 * ::
 *  CRUD 쿼리문 중에서 Service Layer와 가장 밀접한 관련이 있는 부분은? R
 *  CRUD 쿼리문 중에서 Service Layer와 전혀 관련이 없는 부분은? D
 */
public interface UserService {
	void addUser(User user) throws Exception; //int
	User getUser(String userId)throws Exception;
	void updateUser(User user) throws Exception; //int
	List<User> getUserList(User user)throws Exception;
}
