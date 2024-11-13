package pack.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class TodoResponse { //FormBean
	private Integer id;
	private String title;
	private Integer order; 
	private Boolean completed;
	
	public static TodoResponse fromEntity (TodoEntity entity) {
		return TodoResponse.builder()
				.id(entity.getId())
				.title(entity.getTitle())
				.order(entity.getOrder())
				.completed(entity.getCompleted())
				.build();
	}
	
	public static TodoEntity toEntity (TodoResponse res) {
		return TodoEntity.builder()
				.id(res.getId())
				.title(res.getTitle())
				.order(res.getOrder())
				.completed(res.getCompleted())
				.build();
	}
}
