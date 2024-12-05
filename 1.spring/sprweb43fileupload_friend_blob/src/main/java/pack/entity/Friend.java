package pack.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Lob;
import jakarta.persistence.Transient;
import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
@Entity
public class Friend {

	@Id
	private int bunho;
	private String irum;
	private String junhwa;
	private String jikup;
	private String imagetype;
	
	@Lob // DB의 @BLOB, CLOB 타입과 매핑
	private byte[] sajin;
	
	@Transient // 실제 Table과 연동되지 않는 임시데이터를 저장하기 위한 필드 지정
	private String base64Image;
}
