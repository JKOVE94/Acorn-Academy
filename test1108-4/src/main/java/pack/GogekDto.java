package pack;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.Setter;

@Entity
@Getter
@Setter
@Table(name = "gogek")
public class GogekDto {

	@Id
	private int gogekno;
	private String gogekname;
	private String gogektel;
}
