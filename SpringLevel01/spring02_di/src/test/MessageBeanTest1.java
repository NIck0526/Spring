package test;

import org.springframework.beans.factory.BeanFactory;
import org.springframework.beans.factory.xml.XmlBeanFactory;

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
		//1. ���� ������ �о���Դϴ�.. Springframework..io
		Resource r = new FileSystemResource("src/resources/messageBean.xml");
		System.out.println("1.�� ���������� �о r�� ��ȯ�߽��ϴ�.");
		
		//2. �� ���丮 ����(di container)
		BeanFactory factory = new XmlBeanFactory(r);
		System.out.println("2. ���� ������ ������ �ϳ� ����ϴ�...");
		
		//3. �����Ǿ ������ ������ �ִ� ���� ��û :: getBean()
		System.out.println("3. ���忡�� ���� �����ɴϴ�...");
		MemberService bean=factory.getBean("messageBean", MemberService.class);
		
		
		//4. ���� �޼ҵ带 ����.. ����� Ȯ��
		System.out.println("4. ���� �޼ҵ带 ȣ��...");
	
	
	}

}
