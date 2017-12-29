package test;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import prob.target.MemberService;
import prob.target.ProductService;

public class AOPTest1 {

	public static void main(String[] args) {
		ApplicationContext factory =
				new ClassPathXmlApplicationContext("resources/prob.xml");
		
		MemberService mem = (MemberService)factory.getBean("member");
		ProductService pro = (ProductService)factory.getBean("product");
		
		mem.register();
		mem.findMemberById("aop");
		System.out.println("\n****************************************");
		pro.deleteProduct();
		pro.updateProduct();
	}

}
