package solv1;
/*
 * �����Ͻ� ������ ����ִ� Target Ŭ����
 * �ٽ����� ������ ���̿� �μ����� ���ɰ�(Cross Cutting Concern)�� ��������� ����־
 * 00P�� ������ �帮�� �ִ�.
 */

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

public class MemberService {

	//�����Ͻ� ����...
	
	public void register() {
		//�����Ͻ� ������ ����ִ�..
		System.out.println("ȸ������ ��ϵǾ����ϴ�...");
		
	}
	
	public void findMemberById(String id) {
		//�����Ͻ� ������ ����ִ�
		System.out.println(id+" �� ȸ���� �˻�.....");
		
	}
	
}
