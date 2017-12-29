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
		 * ProxyFactoryBean, Target생성 추가, PointCut을 생성, 어드바이스와 함께 추가(Advisor)
		 */

		ProxyFactoryBean pfBean = new ProxyFactoryBean();
		pfBean.setTarget(new MessageImpl("AOPAPI"));
		
		//1. 위빙 될 타겟의 지점을 지정...pointCut
		NameMatchMethodPointcut pointcut = new NameMatchMethodPointcut();
		
		//2. target의 search~ 로 시작하는 곳으로 위빙하겠다.
		pointcut.setMappedName("search*");
		
		//3. pfBean에 advisor를 추가 시킨다. advisor= pointcut + advice
		pfBean.addAdvisor(new DefaultPointcutAdvisor(pointcut, new MessageAdvice()));
		
		//4. pfBean에서 target객체를 얻어온다...getObject()
		Message m = (Message)pfBean.getObject();
		System.out.println(m.print());
		System.out.println("~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~");
		m.searchMember("kosta");
		m.searchMemberrByAddress("판교");
	}

}




