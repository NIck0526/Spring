package api5;

import org.springframework.beans.factory.annotation.Autowired;

/*
 * DataSource�� �������Ѵ�.
 */
public class DaoImpl implements Dao{
	@Autowired
	private String DataSource; //���� ���
	


	
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
		System.out.println("Connection ���� �� ȸ�� ���� ����!! ");
	}
}





