package conect.data.form;

import conect.data.entity.TaskEntity;
import lombok.Getter;
import lombok.Setter;

import java.util.Date;

@Getter
@Setter
public class TaskForm {
    private int task_pk_num;
    private String task_title;
    private String task_desc;
    private Date task_startdate;
    private Date task_deadline;
    private Date task_enddate;
    private int task_duration;
    private int task_progress;
    private String task_status;
    private int task_priority;
    private Date task_created;
    private Date task_updated;
    private double task_version;

    public TaskEntity toEntity() {
        TaskEntity entity = new TaskEntity();
        entity.setTask_pk_num(this.task_pk_num);
        entity.setTask_title(this.task_title);
        entity.setTask_desc(this.task_desc);
        entity.setTask_startdate(this.task_startdate);
        entity.setTask_deadline(this.task_deadline);
        entity.setTask_enddate(this.task_enddate);
        entity.setTask_duration(this.task_duration);
        entity.setTask_progress(this.task_progress);
        entity.setTask_status(this.task_status);
        entity.setTask_priority(this.task_priority);
        entity.setTask_created(this.task_created);
        entity.setTask_updated(this.task_updated);
        entity.setTask_version(this.task_version);
        return entity;
    }
}