package conect.data.form;

import conect.data.entity.CompanyEntity;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class CompanyForm {
    private int comp_pk_num;
    private String comp_name;
    private String comp_pic;

    public CompanyEntity toEntity() {
        CompanyEntity entity = new CompanyEntity();
        entity.setComp_pk_num(this.comp_pk_num);
        entity.setComp_name(this.comp_name);
        entity.setComp_pic(this.comp_pic);
        return entity;
    }
}