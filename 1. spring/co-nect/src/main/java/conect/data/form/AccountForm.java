package conect.data.form;

import conect.data.entity.AccountEntity;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class AccountForm {
    private int acc_pk_authornum;
    private String acc_author;

    public AccountEntity toEntity() {
        AccountEntity entity = new AccountEntity();
        entity.setAcc_pk_authornum(this.acc_pk_authornum);
        entity.setAcc_author(this.acc_author);
        return entity;
    }
}