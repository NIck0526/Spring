package di.step1;


//Component :: �������̽��� ������ �ڹ�Ŭ���� 
public class MessageBeanKR implements MessageBean{
	public MessageBeanKR() {
		System.out.println("KR Bean Creating.....");
	}
	@Override
	public void sayHello(String str) { // bz logic�̶�� ��������..
		
		System.out.println("�ȳ�..."+str);
		
	}
}
