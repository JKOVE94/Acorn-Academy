package pack.service;

import java.util.Optional;

import org.springframework.stereotype.Repository;

import pack.controller.UsersForm;
import pack.dto.UsersDto;
import pack.entity.Users;
import pack.repository.UsersRepository;

@Repository
public class UsersService {

	private UsersRepository usersRepository;
	
	UsersService(UsersRepository usersRepository) {
		this.usersRepository=usersRepository;
	}
	
	public UsersDto createUser(UsersForm form) {
		Users user = UsersForm.toEntity(form);
		Users savedUser = usersRepository.save(user);
		return UsersDto.fromEntity(savedUser);
	}
	
	public Optional<UsersDto> getUserById(Long id){
		return usersRepository.findById(id).map(UsersDto::fromEntity);
	}
	
	//사용자 관련 여러 작업이 있을 수 있다.
	
}
