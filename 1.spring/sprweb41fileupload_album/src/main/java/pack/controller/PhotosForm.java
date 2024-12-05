package pack.controller;

import java.time.LocalDateTime;

import lombok.Getter;
import lombok.Setter;
import pack.entity.Photos;
import pack.entity.Users;

@Getter
@Setter
public class PhotosForm {

	private long id;
	private long userid;
	private String albumname;
	private String title;
	private String description;
	private String filepath;
	private LocalDateTime uploadat;
	
	/*
	public static Photos toEntity(PhotosForm form) {
		return Photos.builder()
				.id(form.getId())
				.albumname(form.getAlbumname())
				.title(form.getTitle())
				.description(form.getDescription())
				.filepath(form.getFilepath())
				.uploadat(form.getUploadat())
				.build();
	}
	*/
	public static Photos toEntity(PhotosForm form, Users users) {
		Photos photos = new Photos();
		photos.setId(form.getId());
		photos.setAlbumname(form.getAlbumname());
		photos.setDescription(form.getDescription());
		photos.setTitle(form.getTitle());
		photos.setFilepath(form.getFilepath());
		photos.setUploadat(form.getUploadat());
		photos.setUsers(users); 
		return photos;
	}
	
	
}
