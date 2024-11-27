package conect.data.dto;

import conect.data.entity.TodoEntity;
import lombok.Getter;
import lombok.Setter;

import java.util.Date;

@Getter
@Setter
public class TodoDto {
    private int todo_pk_num;
    private String todo_title;
    private String todo_content;
    private Date todo_start;
    private Date todo_end;
    private UserDto user;

    public static TodoDto fromEntity(TodoEntity entity) {
        TodoDto dto = new TodoDto();
        dto.setTodo_pk_num(entity.getTodo_pk_num());
        dto.setTodo_title(entity.getTodo_title());
        dto.setTodo_content(entity.getTodo_content());
        dto.setTodo_start(entity.getTodo_start());
        dto.setTodo_end(entity.getTodo_end());
        dto.setUser(UserDto.fromEntity(entity.getUser()));
        return dto;
    }
}