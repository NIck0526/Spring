package log;
//log4j
//log 파일에 출력하기 위해서는 Log객체를 얻어내야 한다.
/*
 * log의 메세지를 레벨이 있다.
 * trace > debug > info > warn > error > fatal
 * 
 * 메세지를 콘솔로 출력 | 파일로 출력
 * 
 * log4j 파일이 필요 
 * 저장위치가 중요 :: server > WEB-INF > classes > !!!!
 */
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

public class LogService {
	private Log log= LogFactory.getLog(getClass());
	
	public void testLogging( ) {
		log.trace("trace...message"); //쓸데가 없다
		log.debug("debug...message"); //디테일한 메세지를 출력...의미없당
		log.info("info...message");
		log.warn("warn...message");
		log.error("error...message");
		log.fatal("fatal...message");
	}
}
