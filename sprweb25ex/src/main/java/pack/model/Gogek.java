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
import lombok.Setter;

@Getter
@Setter
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
	@JoinColumn(name = "gogekdamsano")
	private Jikwon jikwon;
}
