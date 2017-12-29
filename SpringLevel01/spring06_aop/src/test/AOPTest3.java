package test;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import solv2.MemberService;
import solv2.ProductService;

public class AOPTest3 {

	public static void main(String[] args) {
		ApplicationContext factory = new ClassPathXmlApplicationContext("resources/solv2.xml");
		
		MemberService mem = factory.getBean("member", MemberService.class);
		ProductService pro = factory.getBean("product", ProductService.class);
		
		mem.register();
		
		System.out.println("==============================================");
		
		pro.deleteProduct();
	}

}
