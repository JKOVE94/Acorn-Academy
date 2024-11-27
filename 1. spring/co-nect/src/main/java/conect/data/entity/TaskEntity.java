package conect.data.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.util.Date;
import java.util.List;

@Setter
@Getter
@Entity
@Table(name="task")
public class TaskEntity {
    @Id
    private int task_pk_num; //업무 고유 식별자 [PK, INT, INCREMENT]
    private String task_title; //업무 제목 [VARCHAR]
    private String task_desc; //업무 설명 {TEXT]
    private Date task_startdate; //업무 시작일 {DATETIME]
    private Date task_deadline; //마감 기한일 [DATETIME]
    private Date task_enddate; //업무 종료일 [DATETIME]
    private int task_duration; //업무 기간 (일 단위) [INT]
    private int task_progress; //진행률 (%) [INT]
    private String task_status; //업무 상태 [VARCHAR] (예정, 진행중, 완료)
    private int task_priority; //우선순위 [INT]
    private Date task_created; //업무 생성 일시 [DATETIME]
    private Date task_updated; //업무 정보 최종 수정 일시 [DATETIME]
    private double task_version; //업무 버전 번호 [FLOAT]
    private int task_fk_task_num;

    @ManyToOne
    @JoinColumn(name="task_fk_proj_num")
    private ProjectEntity projectEntity;

    @ManyToOne
    @JoinColumn(name="task_fk_user_num")
    private UserEntity userEntity;

}
