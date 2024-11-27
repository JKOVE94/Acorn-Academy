package conect.data.form;

import conect.data.entity.ProjectEntity;
import lombok.Getter;
import lombok.Setter;

import java.util.Date;

@Getter
@Setter
public class ProjectForm {
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

    public ProjectEntity toEntity() {
        ProjectEntity entity = new ProjectEntity();
        entity.setProj_pk_num(this.proj_pk_num);
        entity.setProj_name(this.proj_name);
        entity.setProj_desc(this.proj_desc);
        entity.setProj_startdate(this.proj_startdate);
        entity.setProj_enddate(this.proj_enddate);
        entity.setProj_status(this.proj_status);
        entity.setProj_members(this.proj_members);
        entity.setProj_created(this.proj_created);
        entity.setProj_updated(this.proj_updated);
        entity.setProj_import(this.proj_import);
        entity.setProj_tag(this.proj_tag);
        entity.setProj_tagcol(this.proj_tagcol);
        entity.setProj_icon(this.proj_icon);
        return entity;
    }
}