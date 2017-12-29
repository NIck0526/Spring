package ibatis.services.user.test;

import ibatis.services.domain.User;

import java.io.Reader;
import java.util.List;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;


/**
 * FileName : MyBATISTestApp.java
  * �� JBDCTestApp.java �� �� ����.
  * �� mybatis Framework ���� �����ϴ� API�� ��� users table �� ���� SELECT   
 */
public class MyBATISTestApp {
	///Main method
	public static void main(String[] args) throws Exception{
		
		//==> SqlMapConfig.xml : MyBATIS Framework �� �ٽ� ȯ�漳��ȭ�� (MetaData)
		//==> mybatis-userservice-mapping.xml : SQL �� ���� ����ȭ�� (MetaData) 
		
		//==> 1. xml metadata �о���̴� Stream ����
		Reader reader=Resources.getResourceAsReader("sql/SqlMapConfig.xml");
		
		//==> 2. Reader ��ü�� �̿� xml metadata �� ������ ���� ������ ����, ��밡���� 
		//==>    �о���� reader�� �������� SqlSessionFactory�� ���Ϲ޴´�.
		SqlSessionFactory factory=new SqlSessionFactoryBuilder().build(reader);
		
		//==> 3.factory�� openSession()�� ���ؼ� SqlSession�� ���� �޴´�.
		SqlSession session=factory.openSession();
		
		List<User> list=session.selectList("usersMapper.getUserList");
		System.out.println("#####################################");
		System.out.println(":: ȸ������ ���");
		
		for (User user : list) {
			System.out.println( user.toString() ) ;
		}
		System.out.println("#####################################");
	}// end of main
}//end of class

/*
 * �� MyBATISTestApp / JDBCTestApp �� ���� MyBATIS Framework �� ����
 * �� SQL,Ŀ�ؼ�,Ʈ���輱 �� ��Ÿ����Ÿ ĸ��ȭ������, 
 *     :: ���� => SqlMapConfig.xml / mybatis-userservice-mapping.xml
 * �� JDBCö�� :  Connection => Statement => ResultSet
 *      resource ���� : close
 *      query ���� ��� �����Ͻ���ü(VO) ���ε� JDBC API �� ����Ͽ� ����� �ݺ������� �ݵ��
 *      �����ϴ� �Ϸ��� ������ ������.
 *      :: ���� =>List<User> list = session.selectList("User.getUserList");
 *  
 *  �� MyBATIS Framework �� ����
 *  �� �۰� �����ϴ� ( mybatis-3.2.8.jar / �� 400kb / �ٸ� ���̺귯���� �������� ����. )
 *  �� ���� ���ø����̼�/�����ͺ��̽� ���� ���ʿ� 
 *      (SQL Mapper(Data Mapper) =>SQL �� �����Ͻ� ��ü���� ���ε�)
 *  �� ���꼺 / ���� / �۾��� �й� (�ҽ��ڵ�� SQL �� �и�)
 *  �� ���ɻ��� �и� 
 *       ( DBMS �� �������� API���� �� JDBC API�� �ƴ� �����Ͻ� ��ü�� ������ �۾�����)
 *        
  *  �� MyBATIS Framework �� JDBC ������ ����ȭ�� lib �̴�
  *     ( JDBC�� ���� ������ lib)        
*/
