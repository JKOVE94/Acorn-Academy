package pack;

import java.util.List;

public interface SangpumInter {
	List<SangpumDto> selectList(); //jdbcDaoSupport는 결과를 List로 반환한다.
}
