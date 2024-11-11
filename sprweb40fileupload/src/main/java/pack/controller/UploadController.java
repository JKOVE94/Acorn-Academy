package pack.controller;

import java.io.File;
import java.io.FileOutputStream;
import java.io.InputStream;
import java.io.OutputStream;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;


@Controller
public class UploadController {

	@GetMapping("upload")
	public String abc() {
		return "uploadform";
	}
	
	@PostMapping("upload")
	public String submit(UploadFile file, Model model, BindingResult result) { //BindingResult는 검증오류를 보관하는 객체다
		InputStream inputStream = null;
		OutputStream outputStream = null;
		
		//업로드 파일 검사
		MultipartFile mfile = file.getMyFile();
		String fileName = mfile.getOriginalFilename(); // 원래 파일명
		if(result.hasErrors()) {
			return "err";
		}
		try {
			inputStream = mfile.getInputStream();
			File newfile = new File("C:\\Users\\mylov\\OneDrive\\ドキュメント\\GitHub\\Acorn-Academy\\sprweb40fileupload\\src\\main\\resources\\static\\upload\\"+fileName);
			if(!newfile.exists()) {
				newfile.createNewFile();
			}
			outputStream = new FileOutputStream(newfile);
			int read = 0;
			byte[] bytes = new byte[1024];
			
			//inputStream에 들어간 파일을 1kb단위로 읽고 끝을 만날때까지 작업을 진행하라
			while((read=inputStream.read(bytes)) != -1) {
				outputStream.write(bytes,0,read); //직렬화된 데이터를 0바이트부터 read(파일 크기 전체를 바이트단위로 설정된 크기) 까지 OutputStream을 통해 작성 => 저장
			}
			
		} catch (Exception e) {
			System.out.println("submit err : "+e);
			return "err";
		}finally {
			try {
				if(inputStream != null) inputStream.close();
				if(outputStream != null) outputStream.close();
			} catch (Exception e2) {
			}
		}
		model.addAttribute("filename",fileName);
		return "uploadfile";
	}
	
}
