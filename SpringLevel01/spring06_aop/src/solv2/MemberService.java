package solv2;
/*
 * �����Ͻ� ������ ����ִ� Target Ŭ����
 * �ٽ����� ������ ���̿� �μ����� ���ɰ�(Cross Cutting Concern)�� ��������� ����־
 * 00P�� ������ �帮�� �ִ�.
 */




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
