package pack.controller;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import pack.model.Gogek;

@Getter
@Setter
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class GogekForm {
	private int gogekno;
	private String gogekname;
	private String gogektel;
	
	public Gogek toEntity() {
		Gogek gogek = new Gogek();
		return gogek.builder()
				.gogekno(this.gogekno)
				.gogekname(this.gogekname)
				.gogektel(this.gogektel)
				.build();
	}
}
