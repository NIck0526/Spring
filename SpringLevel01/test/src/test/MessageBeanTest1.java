package test;

import org.springframework.beans.factory.BeanFactory;
import org.springframework.beans.factory.xml.XmlBeanFactory;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.core.io.FileSystemResource;
import org.springframework.core.io.Resource;

import com.kosta.service.MemberService;


/*
 *  DI Framework :: ���̺귯��
 *  ::
 *  Lazy Loading
 *  Ŭ���̾�Ʈ�� ��û�� �ϴ� ����������
 *  ���� �����Ѵ�.
 *  ::
 *  Pre Loading load-on-startup
 *  ������ ��û�ϱ� ���� �̸� �����ϰ�
 *  ���� ���� ��û�ϸ� ����� ���� ���� �����ؾ���.
 *  
 */
public class MessageBeanTest1 {

	public static void main(String[] args) {
		/*ApplicationContext factory =
				new ClassPathXmlApplicationContext("resources/messageBean.xml");*/
		ApplicationContext factory =
				new ClassPathXmlApplicationContext("resources/messageBean1.xml");
		System.out.println("1. ���� ����..");
		//3. �����Ǿ ������ ������ �ִ� ���� ��û :: getBean()
		System.out.println("2. ���忡�� ���� �����ɴϴ�...");
		/*MemberService bean=factory.getBean("messageBean", MemberService.class);*/
		MemberService bean=factory.getBean("message1", MemberService.class);
		
		//4. ���� �޼ҵ带 ����.. ����� Ȯ��
		System.out.println("3. ���� �޼ҵ带 ȣ��..."+bean.msg());
	
	
	}

}
