package client;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;

import config.FactoryService;
import vo.MySawonVO;

public class SawonListTest {

	public static void main(String[] args) {
		SqlSessionFactory factory = FactoryService.getFactory();
		SqlSession session = factory.openSession();

		List<MySawonVO> list = session.selectList("mysawonMapper.selectAllSawon");
		
		for(MySawonVO v : list) {
			System.out.println(v);
		}
	}

}
