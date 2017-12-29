package ibatis.services.user.test;

import java.lang.reflect.InvocationTargetException;
import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;

import ibatis.services.domain.Item;
/*
 * FileName : MyBatisTestApp101.java
  * ㅇ SqlMapConfig01.xml / mybatis-userservice-mapping10.xml
  * ㅇ TestUtil.java 을 이용 Test . 
  * ㅇ 이거 돌아가면 MyBatis Framework 단위테스트는 잘 된거다.
  * ..mybatis-userservice-mapping10.xml은 문제 없다.
  * 
  * ㅇ 다음은 Persistance Logic 단위테스트 : MyBatisTestApp102.java
  * ㅇ MyBatisUserDAOImpl10 / UserADO 추가해야한다.
  */
public class MyBatisTestApp {
	///Main method
	public static void main(String[] args) throws Exception{
		
		SqlSession session = null;
		//==> TestUtil 의 getSqlSessionFactory()을 이용 SqlSessionFactory instance GET
		SqlSessionFactory factory = TestUtil.getSqlSessionFactory();
		session=factory.openSession();
		

		//4. User10.getUserList Test  :: Dynamic Query 확인 id=user04/name=온달 검색
		System.out.println(":: 4. findItemList(SELECTALL)  ? ");
		List<Item> list = session.selectList("itemMapper.findItemList");
		
		TestUtil.printList(list);
		
		
		
	}//end of main
}//end of class




