package prob.target;
/*
 * src/resources/prob.xml ���������� �ۼ�
 * member, product�� id�� ����
 * 
 * src/test/AOPTest1	:: ����
 */
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

public class ProductService {
	private Log log = LogFactory.getLog(getClass());
	//�����Ͻ� ����...
	
	public void deleteProduct() {
		System.out.println("��ǰ ����...");
		log.info("product delete...");
	}
	
	public void updateProduct() {
		System.out.println("��ǰ ����...");
		log.info("product update...");
	}
	
}
