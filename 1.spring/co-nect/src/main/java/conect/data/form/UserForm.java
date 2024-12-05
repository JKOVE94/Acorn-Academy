package conect.data.form;

import conect.data.entity.UserEntity;
import lombok.Getter;
import lombok.Setter;

import java.util.Date;

@Getter
@Setter
public class UserForm {
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

    public UserEntity toEntity() {
        UserEntity entity = new UserEntity();
        entity.setUser_pk_num(this.user_pk_num);
        entity.setUser_regdate(this.user_regdate);
        entity.setUser_pw(this.user_pw);
        entity.setUser_name(this.user_name);
        entity.setUser_mail(this.user_mail);
        entity.setUser_pic(this.user_pic);
        entity.setUser_rank(this.user_rank);
        entity.setUser_lastlogin(this.user_lastlogin);
        entity.setUser_trynum(this.user_trynum);
        entity.setUser_locked(this.user_locked);
        return entity;
    }
}