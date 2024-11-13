package pack.service;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.stereotype.Repository;

import pack.controller.PhotosForm;
import pack.dto.PhotosDto;
import pack.entity.Photos;
import pack.entity.Users;
import pack.repository.PhotosRepository;
import pack.repository.UsersRepository;

@Repository
public class PhotosService {

	private PhotosRepository photosRepository;
	private UsersRepository usersRepository;
	
	PhotosService(PhotosRepository photosRepository, UsersRepository usersRepository) {
		this.photosRepository=photosRepository;
		this.usersRepository=usersRepository;
	}
	
	//사진 저장
	public PhotosDto savephoto(PhotosForm form) {
		Users user = usersRepository.findById(form.getUserid())
				.orElseThrow(()-> new RuntimeException("User not found"));
		Photos photos = PhotosForm.toEntity(form, user);
		Photos savedPhoto = photosRepository.save(photos);
		return PhotosDto.fromEntity(photos);
	}

	//특정 userid를 가진 사용자의 사진 목록을 가져와 PhotoDto 객체 리스트로 반환하기
	public List<PhotosDto> getPhotoByuserid(Long userid){
		return photosRepository.findByUsersId(userid).stream()
				.map(PhotosDto :: fromEntity)
				.collect(Collectors.toList());
	}
	
	//사진 업데이트, 특정 앨범의 사진 조회, 특정 날짜 범위의 사진 조회
	
}
