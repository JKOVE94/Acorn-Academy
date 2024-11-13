package pack.service;

import java.util.List;

import pack.controller.FriendForm;
import pack.dto.FriendDto;
import pack.entity.Friend;

public interface Service {
	void saveFriend(FriendForm form) ;
	public List<FriendDto> findAll();
	Friend ConvertToBase64(Friend friend);
	int generateBunho();
}
