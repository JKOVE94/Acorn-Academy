package pack;

import com.fasterxml.jackson.annotation.JsonBackReference;

import jakarta.persistence.*;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@NoArgsConstructor
public class Gogek {
    @Id
    private int gogekno;

    private String gogekname;
    private String gogektel;
    private String gogekjumin;

    @ManyToOne
    @JoinColumn(name = "gogekdamsano")
    @JsonBackReference //순환 참조 방지
    private Jikwon jikwon;
}