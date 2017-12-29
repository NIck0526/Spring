package prob.target;
/*
 * src/resources/prob.xml 설정문서를 작성
 * member, product로 id를 지정
 * 
 * src/test/AOPTest1	:: 실행
 */
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

public class ProductService {
	private Log log = LogFactory.getLog(getClass());
	//비지니스 로직...
	
	public void deleteProduct() {
		System.out.println("상품 삭제...");
		log.info("product delete...");
	}
	
	public void updateProduct() {
		System.out.println("상품 수정...");
		log.info("product update...");
	}
	
}
