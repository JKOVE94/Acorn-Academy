package pack.dto;

import java.util.ArrayList;
import java.util.List;

import lombok.Getter;
import lombok.Setter;
import pack.entity.Sajindata;
import pack.entity.Sangdata;

@Getter
@Setter
public class SangDto {

	private int code;
	private String sang;
	private int su;
	private int dan;
	private List<SajinDto> sajinList;
	
	public static SangDto fromEntity(Sangdata sangdata) {
		SangDto dto = new SangDto();
		List<SajinDto> dtolist = new ArrayList<SajinDto>();
		for(Sajindata d : sangdata.getSajinList()) {
			SajinDto sajindto = new SajinDto();
			sajindto.setAbout(d.getAbout());
			sajindto.setFilepath(d.getFilepath());
			sajindto.setId(d.getId());
			sajindto.setUploadat(d.getUploadat());
			dtolist.add(sajindto);
		}
		
		dto.setCode(sangdata.getCode());
		dto.setDan(sangdata.getDan());
		dto.setSu(sangdata.getSu());
		dto.setSang(sangdata.getSang());
		dto.setSajinList(dtolist);
		return dto;
	}
}
