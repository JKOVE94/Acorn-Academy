package pack;

import jakarta.persistence.*;
import lombok.Data;
import lombok.NoArgsConstructor;
import java.util.Date;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
@Data
@NoArgsConstructor
public class Jikwon {
    @Id
    private int jikwonno;

    private String jikwonname;

    @ManyToOne
    @JoinColumn(name = "busernum")
    @JsonBackReference
    private Buser buser;

    private String jikwonjik;
    private int jikwonpay;
    private Date jikwonibsail;
    private String jikwongen;
    private String jikwonrating;

    @OneToMany(mappedBy = "jikwon", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    @JsonIgnore //순환참조 방지
    private List<Gogek> gogeks; // gogek와의 관계 추가
}
