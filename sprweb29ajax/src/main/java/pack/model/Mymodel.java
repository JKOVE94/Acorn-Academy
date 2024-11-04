package pack.model;

import org.springframework.stereotype.Component;

import lombok.Data;

@Data
@Component
public class Mymodel {
	private String name;
	private String skills[];
}
