package pack.model;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "gogek")
public class Gogek {
	
	@Id
	private int gogekno;
	private String gogekname;
	private String gogektel;
	
	@ManyToOne
	@JoinColumn(name = "gogekdamsano", insertable = false, updatable = false) // 외래키는 관계를 표현하는 식으로만 사용할것이다. 즉 수정불가
	private Jikwon jikwon;
}
