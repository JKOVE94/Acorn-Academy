package conect.data.form;

import conect.data.entity.TodoEntity;
import lombok.Getter;
import lombok.Setter;

import java.util.Date;

@Getter
@Setter
public class TodoForm {
    private int todo_pk_num;
    private String todo_title;
    private String todo_content;
    private Date todo_start;
    private Date todo_end;

    public TodoEntity toEntity() {
        TodoEntity entity = new TodoEntity();
        entity.setTodo_pk_num(this.todo_pk_num);
        entity.setTodo_title(this.todo_title);
        entity.setTodo_content(this.todo_content);
        entity.setTodo_start(this.todo_start);
        entity.setTodo_end(this.todo_end);
        return entity;
    }
}