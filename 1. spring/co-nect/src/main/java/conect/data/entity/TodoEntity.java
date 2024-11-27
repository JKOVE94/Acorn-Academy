package conect.data.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.util.Date;

@Setter
@Getter
@Entity
@Table(name = "todo")
public class TodoEntity {
    @Id
    private int todo_pk_num; //투두리스트 고유 식별자 [PK, INT, INCREMENT]
    private String todo_title; // 투두리스트 제목 [VARCHAR]
    private String todo_content; //투두리스트 내용 [VARCHAR]
    private Date todo_start; //투두리스트 시작일 [DATETIME]
    private Date todo_end; //투두리스트 종료일 [DATETIME]

    @ManyToOne
    @JoinColumn(name = "todo_fk_user_num")
    private UserEntity user;

}
