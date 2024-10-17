package pack.buisness;

import java.sql.Timestamp;

import lombok.Data;

@Data
public class DataDto {
	private String id, name, passwd;
	private Timestamp regdate;
}
