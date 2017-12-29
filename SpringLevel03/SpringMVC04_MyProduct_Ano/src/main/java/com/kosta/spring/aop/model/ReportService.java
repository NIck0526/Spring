package com.kosta.spring.aop.model;

import java.util.List;

public interface ReportService {
		
	List selectReport() throws Exception;
	void saveReport(String word) throws Exception;
}
