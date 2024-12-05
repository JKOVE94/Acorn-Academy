package conect.data.dto;

import conect.data.entity.TaskEntity;
import lombok.Getter;
import lombok.Setter;

import java.util.Date;
import java.util.List;

@Getter
@Setter
public class TaskDto {
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
    private ProjectDto project_entity;
    private UserDto user_entity;
    private int task_fk_task_num;

    public static TaskDto fromEntity(TaskEntity entity) {
        TaskDto dto = new TaskDto();
        dto.setTask_pk_num(entity.getTask_pk_num());
        dto.setTask_title(entity.getTask_title());
        dto.setTask_desc(entity.getTask_desc());
        dto.setTask_startdate(entity.getTask_startdate());
        dto.setTask_deadline(entity.getTask_deadline());
        dto.setTask_enddate(entity.getTask_enddate());
        dto.setTask_duration(entity.getTask_duration());
        dto.setTask_progress(entity.getTask_progress());
        dto.setTask_status(entity.getTask_status());
        dto.setTask_priority(entity.getTask_priority());
        dto.setTask_created(entity.getTask_created());
        dto.setTask_updated(entity.getTask_updated());
        dto.setTask_version(entity.getTask_version());
        dto.setProject_entity(ProjectDto.fromEntity(entity.getProjectEntity()));
        dto.setUser_entity(UserDto.fromEntity(entity.getUserEntity()));
        dto.setTask_fk_task_num(entity.getTask_fk_task_num());
        return dto;
    }
}