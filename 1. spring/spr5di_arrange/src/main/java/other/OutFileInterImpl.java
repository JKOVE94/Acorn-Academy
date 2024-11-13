package other;

import java.io.FileOutputStream;
import java.io.FileWriter;

public class OutFileInterImpl implements OutFileInter {
	private String filePath;
	
	public void setFilePath(String filePath) {
		this.filePath = filePath;
	}
	
	@Override
	public void outFile(String msg) {
		//메세지를 파일로 출력
		try {
			FileWriter fileWriter = new FileWriter(filePath);
			fileWriter.write(msg);
			fileWriter.close();
			System.out.println("파일 저장 성공");
			
		}catch(Exception e) {
			System.out.println("outFile err :"+e);
		}
	}

}
