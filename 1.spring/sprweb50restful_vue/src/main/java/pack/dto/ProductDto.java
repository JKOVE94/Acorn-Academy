package pack.dto;

import org.apache.ibatis.type.Alias;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Alias(value = "productDto")
public class ProductDto {

	private String code;
	private String name;
	private String description;
	private int price;
	private String image;
}
