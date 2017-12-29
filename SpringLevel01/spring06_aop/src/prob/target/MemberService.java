package prob.target;
/*
 * 비지니스 로직이 들어있는 Target 클래스
 * 핵심적인 로직들 사이에 부수적인 관심가(Cross Cutting Concern)이 산발적으로 들어있어서
 * 00P의 본질을 흐리고 있다.
 */

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

public class MemberService {
	private Log log = LogFactory.getLog(getClass());
	//비지니스 로직...
	
	public void register() {
		//비지니스 로직이 들어있다..
		System.out.println("회워느로 등록되었습니다...");
		log.info("register member...");//부수적인 관심사 - CrossCutting Concern
	}
	
	public void findMemberById(String id) {
		//비지니스 로직이 들어있다
		System.out.println(id+" 로 회원을 검색.....");
		log.info("findMemberById member...."); // 부수적인 관심사 - CrossCutting Concern
	}
	
}
