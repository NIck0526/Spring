package jdbc2;

import java.util.List;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class JdbcMainTest2 {

	public static void main(String[] args) {
		ApplicationContext factory = new ClassPathXmlApplicationContext("jdbc2/jdbc2.xml");
		
		MemberDao dao = (MemberDao)factory.getBean("dao");
		MemberVO vo = new MemberVO("데이타드레싱", "1234", "데이타우먼", "제이디비씨");
		
		/*dao.register(vo);*/
		System.out.println("register ok..."+vo);
		
		System.out.println("================getList()==================");
		List<MemberVO> list = dao.getList();
		for(MemberVO m : list) {
			System.out.println(m);
		}
		
	/*	System.out.println("==================getSearch()=================");
		
		System.out.println(dao.getSearch("데이타드레싱"));*/
	}

}
