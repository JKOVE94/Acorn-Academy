package pack.model;

import java.util.List;

public interface DataInterface {
//	List<MemEntity> selectdataAll();

	List<MemEntity> selectDataAll();//DTO와 Entity는 분리하는것이 좋다.
}
