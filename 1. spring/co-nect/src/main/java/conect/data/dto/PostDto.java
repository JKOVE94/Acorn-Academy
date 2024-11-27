package conect.data.dto;

import conect.data.entity.PostEntity;
import lombok.Getter;
import lombok.Setter;

import java.util.Date;
import java.util.List;

@Getter
@Setter
public class PostDto {
    private int post_pk_num;
    private int post_kind;
    private String post_targetnum;
    private String post_name;
    private Date post_regdate;
    private String post_import;
    private String post_content;
    private String post_tag;
    private int post_depth;
    private int post_view;
    private UserDto user_entity;
    private CompanyDto company_entity;
    private DepartmentDto department_entity;
    private List<ReplyDto> reply_entities;
    private List<FavoritesDto> favorites_entities;

    public static PostDto fromEntity(PostEntity entity) {
        PostDto dto = new PostDto();
        dto.setPost_pk_num(entity.getPost_pk_num());
        dto.setPost_kind(entity.getPost_kind());
        dto.setPost_targetnum(entity.getPost_targetnum());
        dto.setPost_name(entity.getPost_name());
        dto.setPost_regdate(entity.getPost_regdate());
        dto.setPost_import(entity.getPost_import());
        dto.setPost_content(entity.getPost_content());
        dto.setPost_tag(entity.getPost_tag());
        dto.setPost_depth(entity.getPost_depth());
        dto.setPost_view(entity.getPost_view());
        dto.setUser_entity(UserDto.fromEntity(entity.getUserEntity()));
        dto.setCompany_entity(CompanyDto.fromEntity(entity.getCompanyEntity()));
        dto.setDepartment_entity(DepartmentDto.fromEntity(entity.getDepartmentEntity()));
        dto.setReply_entities(entity.getReplyEntities().stream().map(ReplyDto::fromEntity).toList());
        dto.setFavorites_entities(entity.getFavoritesEntities().stream().map(FavoritesDto::fromEntity).toList());
        return dto;
    }
}