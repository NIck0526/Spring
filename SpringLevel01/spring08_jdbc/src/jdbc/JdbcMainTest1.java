package jdbc;

import java.util.List;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class JdbcMainTest1 {

	public static void main(String[] args) {
		ApplicationContext factory = new ClassPathXmlApplicationContext("jdbc/jdbc.xml");
		
		MemberDao dao = (MemberDao)factory.getBean("dao");
		MemberVO vo = new MemberVO("����Ÿ�巹��", "1234", "����Ÿ���", "���̵��");
		
		/*dao.register(vo);*/
		System.out.println("register ok..."+vo);
		
		/*System.out.println("================getList()==================");
		List<MemberVO> list = dao.getList();
		for(MemberVO m : list) {
			System.out.println(m);
		}*/
		
		System.out.println("==================getSearch()=================");
		
		System.out.println(dao.getSearch("����Ÿ�巹��"));
	}

}
