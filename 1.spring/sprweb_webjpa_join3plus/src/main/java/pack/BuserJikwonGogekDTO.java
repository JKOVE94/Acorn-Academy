package pack;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class BuserJikwonGogekDTO {  // 조인 결과를 담기 위한 DTO
	private Integer buserno;
    private String busername;
    private String buserloc;
    private Integer jikwonno;
    private String jikwonname;
    private String jikwonjik;
    private Integer jikwonpay;
    private Integer gogekno;
    private String gogekname;
    private String gogektel;
}
