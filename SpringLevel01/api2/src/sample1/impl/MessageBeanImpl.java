package sample1.impl;

public class MessageBeanImpl {
		private String name;

		public void setName(String name) {
			this.name = name;
		}
		
		public void sayHello() {
			try {
				Thread.sleep(5000);
			}catch(InterruptedException e) {
			}
			System.out.println("Hello, "+name+"!");
		}
}
