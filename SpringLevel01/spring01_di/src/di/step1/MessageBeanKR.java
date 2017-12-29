package di.step1;


//Component :: 인터페이스를 재사용한 자바클래스 
public class MessageBeanKR implements MessageBean{
	public MessageBeanKR() {
		System.out.println("KR Bean Creating.....");
	}
	@Override
	public void sayHello(String str) { // bz logic이라고 생각하자..
		
		System.out.println("안녕..."+str);
		
	}
}
