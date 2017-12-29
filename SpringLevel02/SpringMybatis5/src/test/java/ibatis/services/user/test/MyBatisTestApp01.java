package ibatis.services.user.test;

import ibatis.services.domain.User;

import java.io.Reader;
import java.util.List;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

/*
 * FileName : MyBatisTestApp01.java
  * �� SqlMapConfig01.xml / mybatis-userservice-mapping01.xml
  * �� MyBATIS Framework �̿� QUERY ( SELECT ) TEST 
  */
public class MyBatisTestApp01 {
	public static void main(String[] args) throws Exception{
		
		///==> SqlMapConfig01.xml : MyBATIS Framework �� �ٽ� ȯ�漳��ȭ�� (MetaData)
		//==> mybatis-userservice-mapping.xml : SQL �� ���� ����ȭ�� (MetaData) 
		
		//==> 1. xml metadata �д� Stream ����
		Reader reader=Resources.getResourceAsReader("sql/SqlMapConfig01.xml");
		//==> 2. Reader ��ü�� �̿� xml metadata �� ������ ���� ������ ����, ��밡���� 
		//==>     SqlMapClient  ��ü ����
		
		SqlSessionFactory factory=new SqlSessionFactoryBuilder().build(reader);
		
		
		SqlSession session=factory.openSession();
		List<User> list=session.selectList("usersMapper.getUserList");
		
		//0. getUserList :: ��� user ����
		System.out.println(":: 0. all User(SELECT)  ? ");
		
		for (int i =0 ;  i < list.size() ; i++) {
			System.out.println( "<"+ ( i +1 )+"> ��° ȸ��.."+ list.get(i).toString() );
		}
		System.out.println("\n");

		//1. getUser :: Ư�� userid ����
		User user = (User)session.selectOne("User01.getUser", "user01");
		System.out.println(":: 1. get(SELECT)  ? "+user.toString());
		System.out.println("\n");
		
		//2. findUserId :: Ư�� userid / password ����
		user.setUserId("user03");  // ����
		user.setPassword("user03"); // ����
		String name = (String)session.selectOne("User01.findUserId", user);
		System.out.println(":: 2. get(SELECT)  ? "+name);
	}//end of main
}//end of class













