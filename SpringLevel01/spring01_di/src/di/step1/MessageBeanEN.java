package di.step1;


//Component :: 인터페이스를 재사용한 자바클래스 
public class MessageBeanEN implements MessageBean{
	public MessageBeanEN() {
		System.out.println("EN Bean Creating.....");
	}
	@Override
	public void sayHello(String str) { // bz logic이라고 생각하자..
		
		System.out.println("HELLO..."+str);
		
	}
}
