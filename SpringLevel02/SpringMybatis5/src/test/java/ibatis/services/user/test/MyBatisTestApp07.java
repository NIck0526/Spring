package ibatis.services.user.test;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;

import ibatis.services.domain.User;
/*
 * FileName : MyBatisTestApp07.java
  * �� SqlMapConfig01.xml / mybatis-userservice-mapping07.xml
  * �� MyBATIS Framework �̿� Dynamic query ( SELECT ) TEST
  * �� TestUtil.java �� �̿� Test . 
  */
public class MyBatisTestApp07 {
	///Main method
		public static void main(String[] args) throws Exception{
			SqlSession session = null;
			
			//==> TestUtil �� getSqlSessionFactory()�� �̿� SqlSessionFactory instance GET
			SqlSessionFactory factory = TestUtil.getSqlSessionFactory();
			session=factory.openSession();
			
			//==> Test �� UserVO instance ����  
			User user = new User("user01","ȫ�浿","user01",new Integer(30),1);
		
			//1. User07.getUserList01 Test 
			System.out.println(":: 1. getUserList01(SELECT)  ? ");
			TestUtil.printList((List)session.selectList("User07.getUserList01",user));//3��
			
			//2. User07.getUserList01 Test 
			System.out.println(":: 2. getUserList01(SELECT)  ? ");
			user.setUserName(null);
			TestUtil.printList((List)session.selectList("User07.getUserList01",user) );//2��
		
			//3. User07.getUserList01 Test 
			System.out.println(":: 3. getUserList01(SELECT)  ? ");
			user.setUserName("ȫ�浿");
			user.setAge(null);
			TestUtil.printList((List)session.selectList("User07.getUserList01",user) );
			
			//4. User07.getUserList01 Test ..�̰��� ������ ���ذſ� ������ ����� ���´�..
			System.out.println(":: 4. getUserList01(SELECT)  ? ");
			user.setUserName(null);
			user.setAge(null);
			TestUtil.printList((List)session.selectList("User07.getUserList01",user) );
			
			////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
			System.out.println("\n==================================\n");
			//==> Test �� UserVO instance ���� �� age / regData null setting
			user = new User("user04","�ָ�","user04",null,1);
			user.setRegDate(null);
			
			//0. User05.addUser Test  :: users table age/grade/redDate �Է°� Ȯ���Ұ� : OK 
			System.out.println(":: 0. addUser(INSERT)  ? "
										+ session.insert("User05.addUser",user));//1.
										  session.commit();
			
		
		}//end of main
	}//end of class