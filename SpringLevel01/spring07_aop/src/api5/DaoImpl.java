package api5;

import org.springframework.beans.factory.annotation.Autowired;

/*
 * DataSource를 가져야한다.
 */
public class DaoImpl implements Dao{
	@Autowired
	private String DataSource; //주입 통로
	


	
	public String getDataSource() {
		return DataSource;
	}


	@Override
	public void register() {
		for(int i=0; i<5; i++) {
			try {
				Thread.sleep(1000);
			}catch(InterruptedException e) {
				
			}
		}//for
		System.out.println("Connection 연결 및 회원 가입 성공!! ");
	}
}





