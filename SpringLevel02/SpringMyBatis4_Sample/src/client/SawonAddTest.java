package client;

import java.io.Reader;
import java.util.Scanner;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import vo.MySawonVO;

//dao���� ����...form���� �Է¹��� ���̶�� ġ��Scanner�� ����Ÿ�� �Է�

public class SawonAddTest {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		MySawonVO vo = new MySawonVO();
		
		System.out.println("���̵� : ");
		vo.setId(sc.nextLine());
		
		System.out.println("��й�ȣ : ");
		vo.setPwd(sc.nextLine());
		
		System.out.println("�� �� : ");
		vo.setName(sc.nextLine());
		
		System.out.println("�� �� : ");
		vo.setAge(sc.nextInt());
		
		//MyBatis Framework���� ���Ǵ� ���̺귯�� Ŭ����
		//SqlSession -- JdbcTemplate
		try {
			//1. sqlConfig.xml�� �о�鿩�� Reader�� �ϳ� ���Ϲް�
			Reader r=Resources.getResourceAsReader("config/sqlConfig.xml");
			
			//2. SqlSessionFactory�� ���Ϲ޴´�.
			SqlSessionFactory factory = new SqlSessionFactoryBuilder().build(r);
			
			//3. SqlSession�� ���Ϲ޴´�.
			SqlSession session=factory.openSession();
			
			//4. mysawon ���̺� �Է¹��� ���� ���Թ���vo�� insert ���Ѻ��ڵ�.
			 int row = session.insert("mysawonMapper.insertSawon", vo);
			 
			 session.commit();
			 session.close();
			 
			 System.out.println(row+" ���� �߰��Ǿ����ϴ�....!!!!");
		}catch(Exception e) {
			
		}
		
	}
}
/*
 * SqlSession ::
 * �������� �����ϴ� ��� ����� ����ִ�.
 * session.insert()
 * session.delete()
 * session.update
 * session.selectList()
 * session.selectOne()
 * 
 */
































