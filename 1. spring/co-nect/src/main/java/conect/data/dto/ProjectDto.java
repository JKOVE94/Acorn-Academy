package conect.data.dto;

import conect.data.entity.ProjectEntity;
import lombok.Getter;
import lombok.Setter;

import java.util.Date;
import java.util.List;

@Getter
@Setter
public class ProjectDto {
    private int proj_pk_num;
    private String proj_name;
    private String proj_desc;
    private Date proj_startdate;
    private Date proj_enddate;
    private String proj_status;
    private String proj_members;
    private Date proj_created;
    private Date proj_updated;
    private String proj_import;
    private String proj_tag;
    private String proj_tagcol;
    private String proj_icon;
    private DepartmentDto department_entity;
    private List<TaskDto> task_entities;
    private List<ReplyDto> reply_entities;
    private List<FavoritesDto> favorites_entities;
    private UserDto user_entity;
    private CompanyDto company_entity;

    public static ProjectDto fromEntity(ProjectEntity entity) {
        ProjectDto dto = new ProjectDto();
        dto.setProj_pk_num(entity.getProj_pk_num());
        dto.setProj_name(entity.getProj_name());
        dto.setProj_desc(entity.getProj_desc());
        dto.setProj_startdate(entity.getProj_startdate());
        dto.setProj_enddate(entity.getProj_enddate());
        dto.setProj_status(entity.getProj_status());
        dto.setProj_members(entity.getProj_members());
        dto.setProj_created(entity.getProj_created());
        dto.setProj_updated(entity.getProj_updated());
        dto.setProj_import(entity.getProj_import());
        dto.setProj_tag(entity.getProj_tag());
        dto.setProj_tagcol(entity.getProj_tagcol());
        dto.setProj_icon(entity.getProj_icon());
        dto.setDepartment_entity(DepartmentDto.fromEntity(entity.getDepartmentEntity()));
        dto.setTask_entities(entity.getTaskEntities().stream().map(TaskDto::fromEntity).toList());
        dto.setReply_entities(entity.getReplyEntities().stream().map(ReplyDto::fromEntity).toList());
        dto.setFavorites_entities(entity.getFavoritesEntities().stream().map(FavoritesDto::fromEntity).toList());
        dto.setUser_entity(UserDto.fromEntity(entity.getUserEntity()));
        dto.setCompany_entity(CompanyDto.fromEntity(entity.getCompanyEntity()));
        return dto;
    }
}