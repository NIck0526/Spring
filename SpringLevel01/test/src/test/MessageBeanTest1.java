package test;

import org.springframework.beans.factory.BeanFactory;
import org.springframework.beans.factory.xml.XmlBeanFactory;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.core.io.FileSystemResource;
import org.springframework.core.io.Resource;

import com.kosta.service.MemberService;


/*
 *  DI Framework :: 라이브러리
 *  ::
 *  Lazy Loading
 *  클라이언트가 요청을 하는 시점에서야
 *  빈을 생성한다.
 *  ::
 *  Pre Loading load-on-startup
 *  원래는 요청하기 전에 미리 생성하고
 *  고객이 빈을 요청하면 만들어 놓은 빈을 제공해야함.
 *  
 */
public class MessageBeanTest1 {

	public static void main(String[] args) {
		/*ApplicationContext factory =
				new ClassPathXmlApplicationContext("resources/messageBean.xml");*/
		ApplicationContext factory =
				new ClassPathXmlApplicationContext("resources/messageBean1.xml");
		System.out.println("1. 공장 생성..");
		//3. 생성되어서 공장이 가지고 있는 빈을 요청 :: getBean()
		System.out.println("2. 공장에서 빈을 가져옵니다...");
		/*MemberService bean=factory.getBean("messageBean", MemberService.class);*/
		MemberService bean=factory.getBean("message1", MemberService.class);
		
		//4. 빈의 메소드를 수행.. 결과를 확인
		System.out.println("3. 빈의 메소드를 호출..."+bean.msg());
	
	
	}

}
