package pack.controller;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import pack.model.BuserEntity;

@Setter
@Getter
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class BuserBean { //Form Bean  => client에서 입력한 값을 담아 옮길때 사용 (전달용)
	private int buserno;
	private String busername, buserloc, busertel;
	
	// 폼빈을 Entity로 변환하는 메소드
	//lombok의 @Builder 을 사용하면 쉽게 Builder Pattern을 운영 할 수 있다.
	//단계별로 부서 객체의 각 필드를 선택적으로 설정 할 수 있다.
	
	public static BuserEntity toEntity(BuserBean bean) {
		return BuserEntity.builder()
				.buserno(bean.buserno)
				.busername(bean.busername)
				.buserloc(bean.buserloc)
				.busertel(bean.busertel)
				.build();
	}
}
