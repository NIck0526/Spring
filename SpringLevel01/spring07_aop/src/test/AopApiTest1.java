package test;

import org.springframework.aop.framework.ProxyFactoryBean;
import org.springframework.aop.support.DefaultPointcutAdvisor;
import org.springframework.aop.support.NameMatchMethodPointcut;

import api1.Message;
import api1.MessageAdvice;
import api1.MessageImpl;

public class AopApiTest1 {

	public static void main(String[] args) {
		/*
		 * ProxyFactoryBean, Target���� �߰�, PointCut�� ����, �����̽��� �Բ� �߰�(Advisor)
		 */

		ProxyFactoryBean pfBean = new ProxyFactoryBean();
		pfBean.setTarget(new MessageImpl("AOPAPI"));
		
		//1. ���� �� Ÿ���� ������ ����...pointCut
		NameMatchMethodPointcut pointcut = new NameMatchMethodPointcut();
		
		//2. target�� search~ �� �����ϴ� ������ �����ϰڴ�.
		pointcut.setMappedName("search*");
		
		//3. pfBean�� advisor�� �߰� ��Ų��. advisor= pointcut + advice
		pfBean.addAdvisor(new DefaultPointcutAdvisor(pointcut, new MessageAdvice()));
		
		//4. pfBean���� target��ü�� ���´�...getObject()
		Message m = (Message)pfBean.getObject();
		System.out.println(m.print());
		System.out.println("~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~");
		m.searchMember("kosta");
		m.searchMemberrByAddress("�Ǳ�");
	}

}




