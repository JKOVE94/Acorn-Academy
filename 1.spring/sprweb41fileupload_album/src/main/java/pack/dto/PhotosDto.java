package pack.dto;


import java.time.LocalDateTime;

import lombok.Getter;
import lombok.Setter;
import pack.entity.Photos;

@Getter
@Setter
public class PhotosDto {

	private long id;
	private long userid;
	private String albumname;
	private String title;
	private String description;
	private String filepath;
	private LocalDateTime uploadat;
	
	/*
	public static PhotosDto fromEntity(Photos photos) { //Photos를 PhotosDto로 - Builder Pattern
		return PhotosDto.builder()
				.id(photos.getId())
				.albumname(photos.getAlbumname())
				.title(photos.getTitle())
				.description(photos.getDescription())
				.filepath(photos.getFilepath())
				.uploadat(photos.getUploadat())
				.build();
	}
	*/
	
	public static PhotosDto fromEntity(Photos photos) { //Photos를 PhotosDto로 - Setter
		PhotosDto dto = new PhotosDto();
		dto.setId(photos.getId());
		dto.setUserid(photos.getUsers().getId());
		dto.setAlbumname(photos.getAlbumname());
		dto.setTitle(photos.getTitle());
		dto.setDescription(photos.getDescription());
		dto.setFilepath(photos.getFilepath());
		dto.setUploadat(photos.getUploadat());
		return dto;
	}

}
