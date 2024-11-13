package pack.model;

public class DataDaoImpl implements DataDao {

	@Override
	public void selectData() {
		System.out.println("DB 접속후 테이블 자료 읽음 : selectData");
	}
}
