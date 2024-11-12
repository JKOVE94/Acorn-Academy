package pack.service;

import java.util.Base64;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import pack.controller.FriendForm;
import pack.dto.FriendDto;
import pack.entity.Friend;
import pack.repository.FriendRepository;

@Repository
public class ServiceImpl implements Service{

	@Autowired
	private FriendRepository friendRepository;
	
	//친구 추가시 번호 구하기
	@Override
	public int generateBunho() {
		Integer lastBunho = friendRepository.findLastBunho();
		if(lastBunho==null) {
			return lastBunho=1;
		}
		else return lastBunho+1; 
	}
	
	@Override
	public void saveFriend(FriendForm form) {
		System.out.println("이름 :"+form.getIrum());
		System.out.println("사진 :"+form.getSajin());
		form.setBunho(this.generateBunho());
		friendRepository.save(FriendForm.toEntity(form));
	}
	
	@Override
	public List<FriendDto> findAll(){
		return friendRepository.findAll().stream()
				.map(this::ConvertToBase64)
				.map(FriendDto :: fromEntity)
				.collect(Collectors.toList());
	}
	
	@Override
	public Friend ConvertToBase64(Friend friend) {
		if(friend.getSajin() != null && friend.getSajin().length>0) {
			//friend Image를 Base64로 인코딩하여 Friend 객체에 저장 => ASCII의 0번부터 63번에 해당되는 문자로 할당
			String base64Image = Base64.getEncoder().encodeToString(friend.getSajin());
			friend.setBase64Image(base64Image);
		}
		return friend;
	}
	
}
