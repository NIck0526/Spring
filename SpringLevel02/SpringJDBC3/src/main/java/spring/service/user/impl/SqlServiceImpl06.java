package spring.service.user.impl;

import java.util.Map;

import spring.service.user.SqlService;

public class SqlServiceImpl06 implements SqlService{
	
	private Map<String, String> sqlMap;
	
	public void setSqlMap(Map<String, String> sqlMap) {
		this.sqlMap = sqlMap;
	}

	public String getSql(String key) throws Exception {
		
		String sql = sqlMap.get(key);
		if(sql==null) throw new Exception();
		else return sql;
	}
}
