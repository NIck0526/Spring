package config;

import java.io.IOException;
import java.io.Reader;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

/*
 * SqlSessionFactory를 하나 리턴받아 오는 로직을 담당
 */
public class FactoryService {
	private static SqlSessionFactory factory;
	
	static {
		
		Reader r;
		try {
			r = Resources.getResourceAsReader("config/sqlConfig.xml");
			
		    factory = new SqlSessionFactoryBuilder().build(r);
		} catch (Exception e) {
			
		}	
	}//static
	
	public static SqlSessionFactory getFactory() {
		return factory;
	}
}

/*
 *  1. SqlSessionFactoryBuilder()
 *  2. SqlSessionFactory
 *  3. SqlSession
 *  	:: 쿼리문을 실행하는 기능이 있다.
 */

