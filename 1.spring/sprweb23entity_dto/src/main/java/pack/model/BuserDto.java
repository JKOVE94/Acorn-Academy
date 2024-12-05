package pack.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@NoArgsConstructor
@AllArgsConstructor
@Builder
@Setter
@Getter
//DTO  => Server(DB)에서 보내준 값을 담아 옮길 때 사용 (전달용)
//DTO는 엔티티에서 필요한 데이터만 추출하거나, 전체 데이터를 읽어 또 다른 클래스, 클라이언트에 전달하는것이 목적
public class BuserDto { 
	private int buserno;
	private String busername, buserloc, busertel;
	
	//BusreEntity를 BuserDto로 변환 - Setter 사용
	/*
	public static BuserDto fromEntity(BuserEntity entity) {
		BuserDto dto = new BuserDto();
		dto.setBuserno(entity.getBuserno());
		dto.setBusername(entity.getBusername());
		dto.setBuserloc(entity.getBuserloc());
		dto.setBusertel(entity.getBusertel());
		return dto;
	}
	*/
	
	//BusreEntity를 BuserDto로 변환 - Builder Pattern
	public static BuserDto fromEntity(BuserEntity entity) {
		return BuserDto.builder()
				.buserno(entity.getBuserno())
				.busername(entity.getBusername())
				.buserloc(entity.getBuserloc())
				.busertel(entity.getBusertel())
				.build();
	}
}
