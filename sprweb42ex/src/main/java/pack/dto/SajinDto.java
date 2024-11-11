package pack.dto;

import java.time.LocalDate;

import lombok.Getter;
import lombok.Setter;
import pack.entity.Sajindata;
import pack.entity.Sangdata;

@Getter
@Setter
public class SajinDto {

	private int id;
	private String about;
	private LocalDate uploadat;
	private String filepath;	
	private Sangdata sangdata;

	public static SajinDto fromEntity(Sajindata sajindata) {
		SajinDto dto = new SajinDto();
		dto.setId(sajindata.getId());
		dto.setAbout(sajindata.getAbout());
		dto.setFilepath(sajindata.getFilepath());
		dto.setUploadat(sajindata.getUploadat());
		dto.setSangdata(sajindata.getSangdata());
		return dto;
	}
}
