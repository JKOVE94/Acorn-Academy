package conect.data.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.util.Date;
import java.util.List;

@Setter
@Getter
@Entity
@Table(name = "post")
public class PostEntity {
    @Id
    private int post_pk_num; //게시글 번호 [PK, INT, INCREMENT]
    private int post_kind; //게시글 유형 [INT]
    private String post_targetnum; //게시글 대상 사원번호 [VARCHAR] => String으로 작성 이후 데이터사용은 String tokenizer 사용
    private String post_name; //게시글 제목 [VARCHAR]
    private Date post_regdate; //게시글 등록일 [DATETIME]
    private String post_import; //게시글 중요도 [VARCHAR] (낮음,보통,높음,매우 높음)
    private String post_content; //게시글 내용 [TEXT]
    private String post_tag; //게시글 태그 [VARCHAR]
    private int post_depth; //게시글 깊이 [INT] (기본값 0, 답글 설정시 사용)
    private int post_view; //게시글 조회수 [INT]

    @ManyToOne
    @JoinColumn(name="post_fk_user_num")
    private UserEntity userEntity;

    @ManyToOne
    @JoinColumn(name="post_fk_comp_num")
    private CompanyEntity companyEntity;

    @ManyToOne
    @JoinColumn(name = "post_fk_dpart_num")
    private DepartmentEntity departmentEntity;

    @OneToMany(mappedBy = "postEntity")
    private List<ReplyEntity> replyEntities;

    @OneToMany(mappedBy = "postEntity")
    private List<FavoritesEntity> favoritesEntities;
}
