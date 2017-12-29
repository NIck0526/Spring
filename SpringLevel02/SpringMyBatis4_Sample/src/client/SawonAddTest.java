package client;

import java.io.Reader;
import java.util.Scanner;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import vo.MySawonVO;

//dao없이 간다...form에서 입력받은 값이라고 치고Scanner로 데이타를 입력

public class SawonAddTest {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		MySawonVO vo = new MySawonVO();
		
		System.out.println("아이디 : ");
		vo.setId(sc.nextLine());
		
		System.out.println("비밀번호 : ");
		vo.setPwd(sc.nextLine());
		
		System.out.println("이 름 : ");
		vo.setName(sc.nextLine());
		
		System.out.println("나 이 : ");
		vo.setAge(sc.nextInt());
		
		//MyBatis Framework에서 사용되는 라이브러리 클래스
		//SqlSession -- JdbcTemplate
		try {
			//1. sqlConfig.xml을 읽어들여서 Reader를 하나 리턴받고
			Reader r=Resources.getResourceAsReader("config/sqlConfig.xml");
			
			//2. SqlSessionFactory를 리턴받는다.
			SqlSessionFactory factory = new SqlSessionFactoryBuilder().build(r);
			
			//3. SqlSession을 리턴받는다.
			SqlSession session=factory.openSession();
			
			//4. mysawon 테이블에 입력받은 값을 주입받은vo를 insert 시켜보겠따.
			 int row = session.insert("mysawonMapper.insertSawon", vo);
			 
			 session.commit();
			 session.close();
			 
			 System.out.println(row+" 명이 추가되었습니다....!!!!");
		}catch(Exception e) {
			
		}
		
	}
}
/*
 * SqlSession ::
 * 쿼리문을 실행하는 모든 기능이 들어있다.
 * session.insert()
 * session.delete()
 * session.update
 * session.selectList()
 * session.selectOne()
 * 
 */
































