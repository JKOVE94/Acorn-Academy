package conect.data.form;

import conect.data.entity.PostEntity;
import lombok.Getter;
import lombok.Setter;

import java.util.Date;

@Getter
@Setter
public class PostForm {
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

    public PostEntity toEntity() {
        PostEntity entity = new PostEntity();
        entity.setPost_pk_num(this.post_pk_num);
        entity.setPost_kind(this.post_kind);
        entity.setPost_targetnum(this.post_targetnum);
        entity.setPost_name(this.post_name);
        entity.setPost_regdate(this.post_regdate);
        entity.setPost_import(this.post_import);
        entity.setPost_content(this.post_content);
        entity.setPost_tag(this.post_tag);
        entity.setPost_depth(this.post_depth);
        entity.setPost_view(this.post_view);
        return entity;
    }
}