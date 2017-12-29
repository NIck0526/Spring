package ibatis.services.user.test;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;

import ibatis.services.domain.User;
/*
 * FileName : MyBatisTestApp101.java
  * �� SqlMapConfig01.xml / mybatis-userservice-mapping10.xml
  * �� TestUtil.java �� �̿� Test . 
  * �� �̰� ���ư��� MyBatis Framework �����׽�Ʈ�� �� �ȰŴ�.
  * ..mybatis-userservice-mapping10.xml�� ���� ����.
  * 
  * �� ������ Persistance Logic �����׽�Ʈ : MyBatisTestApp102.java
  * �� MyBatisUserDAOImpl10 / UserADO �߰��ؾ��Ѵ�.
  */
public class MyBatisTestApp101 {
	///Main method
	public static void main(String[] args) throws Exception{
		
		SqlSession session = null;
		//==> TestUtil �� getSqlSessionFactory()�� �̿� SqlSessionFactory instance GET
		SqlSessionFactory factory = TestUtil.getSqlSessionFactory();
		session=factory.openSession();
		
		//==> Test �� User instance ����  
		User user = new User("user04","�ָ�","user04",null,1);		
		
		//1. User10.addUser Test  :: users table age/grade/redDate �Է°� Ȯ���Ұ� : OK 
		System.out.println(":: 1. addUser(INSERT)  ? "
													+ session.insert("User10.addUser",user)); //1
													  session.commit();
		//2. User10.getUser Test :: �ָ� inert Ȯ�� 
		System.out.println(":: 2. getUser(SELECT)  ? "	
				+ session.selectOne("User10.getUser",user.getUserId()));
		
		
		//3. User10.uadateUser Test  :: users table age/redDate �Է°� Ȯ���Ұ� : OK
		//                                                    :: �ָ� ==> �´� ����
		user.setUserName("�´�");
		System.out.println(":: 3. update(UPDATE)  ? "
													+ session.update("User10.updateUser",user));//1
											  		  session.commit();
		 
		//4. User10.getUserList Test  :: Dynamic Query Ȯ�� id=user04/name=�´� �˻�
		System.out.println(":: 4. getUserList(SELECT)  ? ");
		TestUtil.printList( (List)session.selectList("User10.getUserList",user) );
		
		//5. User10.removeUser Test
		System.out.println(":: 5. Use10.removeUser (DELETE)  ? "
								+session.delete("User10.removeUser",user.getUserId()) );//1
								 session.commit();
		
		//6. User10.getUserList Test  :: Dynamic Query Ȯ�� id=user04/name=�´� �˻�
		System.out.println(":: 6. getUserList(SELECT)  ? ");
		TestUtil.printList((List) session.selectList("User10.getUserList",user) ); //�̶� ���� ��� ����Ÿ���� 0�ΰ� Ȯ������
	
		//7. User10.getUserList Test  :: Dynamic Query Ȯ�� id=null/name=null �ΰ��
		user.setUserId(null);
		user.setUserName(null);
		System.out.println(":: 7. getUserList(SELECT)  ? ");
		TestUtil.printList( (List) session.selectList("User10.getUserList",user) );
		
	}//end of main
}//end of class




