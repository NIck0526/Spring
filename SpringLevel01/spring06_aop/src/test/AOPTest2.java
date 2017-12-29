package test;

import org.springframework.aop.framework.ProxyFactoryBean;

import solv1.MemberService;
import solv1.ProductService;
import solv1.ServiceAdvice;

public class AOPTest2 {

	public static void main(String[] args) {
		//target, advice 클래스를 직접 생성
		MemberService mem = new MemberService();
		ProductService pro = new ProductService();
		ServiceAdvice advice = new ServiceAdvice();
		
		//ProxyFactoryBean를 생성		
		ProxyFactoryBean pfBean = new ProxyFactoryBean();
		
		pfBean.setTarget(mem); //pro는 일부러 pfBean에 추가 안하겠다.
		pfBean.addAdvice(advice);
		
		//ProxyFactoryBean에서 target을 찾아온다.
		MemberService pfMem = (MemberService)pfBean.getObject();
		pfMem.register();
		System.out.println("&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&");
		mem.register();
	}

}
