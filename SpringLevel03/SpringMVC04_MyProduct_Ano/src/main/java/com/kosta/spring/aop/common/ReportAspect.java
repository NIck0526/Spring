package com.kosta.spring.aop.common;

import java.util.List;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.kosta.spring.aop.model.ReportService;

@Component
@Aspect
public class ReportAspect { // POJO (일때는 단순클래스로)
	
	@Autowired
	private ReportService reportService;
	
	
	@Around("execution(public * com.kosta.spring.model.impl.*Service*.find*(..))")
			
	public Object report(ProceedingJoinPoint pjp) throws Throwable{
		Object retValue = null;
		
		retValue  = pjp.proceed();
		System.out.println(pjp.getSignature().getName()+"() target method call..");
		List list = (List)retValue;
		
		if(!list.isEmpty()) { // 상품검색이 제대로 된 것이라면..
			Object[] params= pjp.getArgs();
			
			reportService.saveReport(params[0].toString());
		}
		
		return list;
	}
}

