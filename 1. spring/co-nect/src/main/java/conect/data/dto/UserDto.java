package conect.data.dto;

import conect.data.entity.UserEntity;
import lombok.Getter;
import lombok.Setter;

import java.util.Date;
import java.util.List;

@Getter
@Setter
public class UserDto {
    private int user_pk_num;
    private Date user_regdate;
    private String user_pw;
    private String user_name;
    private String user_mail;
    private String user_pic;
    private String user_rank;
    private Date user_lastlogin;
    private int user_trynum;
    private int user_locked;
    private AccountDto account_entity;
    private CompanyDto company_entity;
    private DepartmentDto department_entity;
    private List<FavoritesDto> favorites_entities;

    public static UserDto fromEntity(UserEntity entity) {
        UserDto dto = new UserDto();
        dto.setUser_pk_num(entity.getUser_pk_num());
        dto.setUser_regdate(entity.getUser_regdate());
        dto.setUser_pw(entity.getUser_pw());
        dto.setUser_name(entity.getUser_name());
        dto.setUser_mail(entity.getUser_mail());
        dto.setUser_pic(entity.getUser_pic());
        dto.setUser_rank(entity.getUser_rank());
        dto.setUser_lastlogin(entity.getUser_lastlogin());
        dto.setUser_trynum(entity.getUser_trynum());
        dto.setUser_locked(entity.getUser_locked());
        dto.setAccount_entity(AccountDto.fromEntity(entity.getAccountEntity()));
        dto.setCompany_entity(CompanyDto.fromEntity(entity.getCompanyEntity()));
        dto.setDepartment_entity(DepartmentDto.fromEntity(entity.getDepartmentEntity()));
        dto.setFavorites_entities(entity.getFavoritesEntities().stream().map(FavoritesDto::fromEntity).toList());
        return dto;
    }
}