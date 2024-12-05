package conect.data.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.util.Date;
import java.util.List;

@Setter
@Getter
@Entity
@Table(name = "project")
public class ProjectEntity {
    @Id
    private int proj_pk_num; //프로젝트 번호 [PK, INT]
    private String proj_name; //프로젝트 이름 [VARCHAR]
    private String proj_desc; //프로젝트 설명 [TEXT]
    private Date proj_startdate; //프로젝트 시작일 [DATETIME]
    private Date proj_enddate; // 프로젝트 종료일 [DATETIME]
    private String proj_status; // 프로젝트 상태 [VARCHAR] (예정, 진행 중, 완료)
    private String proj_members; // 프로젝트 참여자 사번 [VARCHAR] (String으로 저장 후 string tokenizer로 데이터 사용)
    private Date proj_created; //프로젝트 생성 일시 [DATETIME]
    private Date proj_updated; // 프로젝트 정보 최종 수정 일시 [DATETIME]
    private String proj_import; //프로젝트 중요도 [VARCHAR] (낮음, 보통, 높음, 매우높음)
    private String proj_tag; //임의로 부여하는 프로젝트 태그 [VARCHAR] => 검색용
    private String proj_tagcol; //프로젝트 태그 컬러 [VARCHAR]
    private String proj_icon; //프로젝트 아이콘 코드 [VARCHAR] => 부트스트랩 아이콘

    @ManyToOne
    @JoinColumn(name="proj_fk_dpart_num")
    private DepartmentEntity departmentEntity;

    @ManyToOne
    @JoinColumn(name="proj_fk_user_num")
    private UserEntity userEntity;

    @ManyToOne
    @JoinColumn(name="proj_fk_comp_num")
    private CompanyEntity companyEntity;

    @OneToMany(mappedBy = "projectEntity")
    private List<TaskEntity> taskEntities;

    @OneToMany(mappedBy = "projectEntity")
    private List<ReplyEntity> replyEntities;

    @OneToMany(mappedBy = "projectEntity")
    private List<FavoritesEntity> favoritesEntities;


}
