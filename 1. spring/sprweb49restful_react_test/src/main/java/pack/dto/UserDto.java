package pack.dto;

import java.util.List;

import lombok.Getter;
import lombok.Setter;
import pack.entity.User;

@Setter
@Getter
public class UserDto {
	private long userno;
	private String username;
	private int userheight;
	private int userweight;
	private String userid;
	private List<ExercisesDto> exercises;
	
	public static UserDto fromEntity(User user) {
		UserDto dto = new UserDto();
		dto.setUserno(user.getUserno());
		dto.setUserid(user.getUserid());
		dto.setUsername(user.getUsername());
		dto.setUserheight(user.getUserheight());
		dto.setUserweight(user.getUserweight());
		dto.setExercises(user.getExlist().stream().map(ExercisesDto :: fromEntity).toList());
		return dto;
	}
}
