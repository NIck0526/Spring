package config;

import java.io.IOException;
import java.io.Reader;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

/*
 * SqlSessionFactory�� �ϳ� ���Ϲ޾� ���� ������ ���
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
 *  	:: �������� �����ϴ� ����� �ִ�.
 */

