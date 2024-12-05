package pack.model;

import java.text.SimpleDateFormat;
import java.util.Date;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class GogekDto {
	private int gogekno;
	private String gogekname;
	private String gogektel;
	private String gogekjumin;
	private Jikwon jikwon;
	private String gogekgen;
	private int gogekage;
	
	public static GogekDto fromEntity(Gogek gogek) {
		return GogekDto.builder()
				.gogekno(gogek.getGogekno())
				.gogekname(gogek.getGogekname())
				.gogektel(gogek.getGogektel())
				.jikwon(gogek.getJikwon())
				.gogekgen(GogekDto.gogekGen(gogek))
				.gogekage(GogekDto.gogekAge(gogek))
				.gogekjumin(gogek.getGogekjumin())
				.build();
	}
	
	//고객의 성별을 구하는 메소드
	public static String gogekGen(Gogek gogek) {
		//주민등록번호 뒷 첫번째 자리 추출
		char gen = gogek.getGogekjumin().charAt(7);
		if(gen=='1' || gen=='3') return "남";
		else return "여";
	}
	
	//고객의 나이를 구하는 메소드
	public static int gogekAge(Gogek gogek) {
		//고객의 출생년도가 저장될 변수
		int bornYear=0;
		//고객 주민번호중 앞 2자리 추출
		int born = Integer.parseInt(gogek.getGogekjumin().substring(0,2));
		//현재 날짜를 년도타입으로 추출
		SimpleDateFormat sdf = new SimpleDateFormat("YYYY");
		int thisYear = Integer.parseInt(sdf.format(new Date()));
		
		//주민등록번호 뒷 첫번쨰 자리로 태어난 년도 파악
		char whenBorn = gogek.getGogekjumin().charAt(7);
		if(whenBorn == '1' || whenBorn == '2') bornYear = born+1900;
		else bornYear = born+2000;
		
		return thisYear-bornYear+1;
	}
}
