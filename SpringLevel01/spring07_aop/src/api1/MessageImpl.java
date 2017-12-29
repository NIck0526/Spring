package api1;
/*
 * Target Class :  Core Concern이 들어있다.
 */
public class MessageImpl implements Message{
	private String message;
	
	public MessageImpl(String message) {
		super();
		this.message = message;
	}

	@Override
	public String print() {

		return "Good Day!";
	}
	
	@Override
	public String message() {
		
		return message;
	}
	
	@Override
	public void searchMember(String id) {
		System.out.println("searchMember....call..."+id);
		
	}
	
	@Override
	public void searchMemberrByAddress(String address) {
		System.out.println("searchMemberByAddress......call......"+address);
		
	}
}
