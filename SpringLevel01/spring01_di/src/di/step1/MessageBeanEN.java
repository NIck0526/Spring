package di.step1;


//Component :: �������̽��� ������ �ڹ�Ŭ���� 
public class MessageBeanEN implements MessageBean{
	public MessageBeanEN() {
		System.out.println("EN Bean Creating.....");
	}
	@Override
	public void sayHello(String str) { // bz logic�̶�� ��������..
		
		System.out.println("HELLO..."+str);
		
	}
}
