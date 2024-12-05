package pack.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import pack.entity.Sangdata;

@Builder
@AllArgsConstructor
@NoArgsConstructor
@Getter
public class SangpumDto {

	private int code;
	private String sang;
	private int su;
	private long dan;
	
	public static SangpumDto fromEntity(Sangdata sangdata) {
		return SangpumDto.builder()
				.code(sangdata.getCode())
				.dan(sangdata.getDan())
				.sang(sangdata.getSang())
				.su(sangdata.getSu())
				.build();
		
	}
}
