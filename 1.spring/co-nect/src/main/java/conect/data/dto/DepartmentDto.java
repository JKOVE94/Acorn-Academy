package conect.data.dto;

import conect.data.entity.DepartmentEntity;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
public class DepartmentDto {
    private int dpart_pk_num;
    private String dpart_name;
    private String dpart_mail;
    private int dpart_fk_dpart_num;
    private List<UserDto> user_entities;
    private List<PostDto> free_entities;
    private List<ProjectDto> user_entity_list;

    public static DepartmentDto fromEntity(DepartmentEntity entity) {
        DepartmentDto dto = new DepartmentDto();
        dto.setDpart_pk_num(entity.getDpart_pk_num());
        dto.setDpart_name(entity.getDpart_name());
        dto.setDpart_mail(entity.getDpart_mail());
        dto.setDpart_fk_dpart_num(entity.getDpart_fk_dpart_num());
        dto.setUser_entities(entity.getUserEntities().stream().map(UserDto::fromEntity).toList());
        dto.setFree_entities(entity.getFreeEntities().stream().map(PostDto::fromEntity).toList());
        dto.setUser_entity_list(entity.getUserEntityList().stream().map(ProjectDto::fromEntity).toList());
        return dto;
    }
}