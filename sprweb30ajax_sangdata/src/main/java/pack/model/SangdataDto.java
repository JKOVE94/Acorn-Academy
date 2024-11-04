package pack.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Builder
@AllArgsConstructor
@NoArgsConstructor
@Getter
public class SangdataDto {

	private int code;
	private String sang;
	private int su;
	private long dan;
	
	public static SangdataDto fromEntity(Sangdata sangdata) {
		return SangdataDto.builder()
				.code(sangdata.getCode())
				.dan(sangdata.getDan())
				.sang(sangdata.getSang())
				.su(sangdata.getSu())
				.build();
		
	}
}
