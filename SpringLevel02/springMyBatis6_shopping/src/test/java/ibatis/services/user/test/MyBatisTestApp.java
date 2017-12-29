package ibatis.services.user.test;

import java.lang.reflect.InvocationTargetException;
import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;

import ibatis.services.domain.Item;
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
public class MyBatisTestApp {
	///Main method
	public static void main(String[] args) throws Exception{
		
		SqlSession session = null;
		//==> TestUtil �� getSqlSessionFactory()�� �̿� SqlSessionFactory instance GET
		SqlSessionFactory factory = TestUtil.getSqlSessionFactory();
		session=factory.openSession();
		

		//4. User10.getUserList Test  :: Dynamic Query Ȯ�� id=user04/name=�´� �˻�
		System.out.println(":: 4. findItemList(SELECTALL)  ? ");
		List<Item> list = session.selectList("itemMapper.findItemList");
		
		TestUtil.printList(list);
		
		
		
	}//end of main
}//end of class




