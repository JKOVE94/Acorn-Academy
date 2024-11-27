package conect.data.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Setter
@Getter
@Entity
@Table(name="account")
public class AccountEntity {
    @Id
    private int acc_pk_authornum; //계정 권한 고유번호 [PK, INT] (1, 2, 3)
    private String acc_author; //계정 권한 [VARCHAR] (일반사용자, 매니저, 관리자)

    @OneToMany(mappedBy = "accountEntity")
    private List<UserEntity> userEntities;
}
