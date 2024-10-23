package pack.model;

import org.springframework.data.annotation.Id;
import org.springframework.data.relational.core.mapping.Table;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Table(name = "product")
public class ProductDto{

	@Id
	private Integer code;
	private String sang;
	private Integer su;
	private Integer dan;
}
