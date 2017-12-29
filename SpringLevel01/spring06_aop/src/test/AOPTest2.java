package test;

import org.springframework.aop.framework.ProxyFactoryBean;

import solv1.MemberService;
import solv1.ProductService;
import solv1.ServiceAdvice;

public class AOPTest2 {

	public static void main(String[] args) {
		//target, advice Ŭ������ ���� ����
		MemberService mem = new MemberService();
		ProductService pro = new ProductService();
		ServiceAdvice advice = new ServiceAdvice();
		
		//ProxyFactoryBean�� ����		
		ProxyFactoryBean pfBean = new ProxyFactoryBean();
		
		pfBean.setTarget(mem); //pro�� �Ϻη� pfBean�� �߰� ���ϰڴ�.
		pfBean.addAdvice(advice);
		
		//ProxyFactoryBean���� target�� ã�ƿ´�.
		MemberService pfMem = (MemberService)pfBean.getObject();
		pfMem.register();
		System.out.println("&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&");
		mem.register();
	}

}
