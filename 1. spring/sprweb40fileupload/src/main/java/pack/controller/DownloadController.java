package pack.controller;

import java.io.File;

import org.springframework.stereotype.Controller;
import org.springframework.util.FileCopyUtils;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import jakarta.servlet.http.HttpServletResponse;

@Controller
public class DownloadController {

	@PostMapping("download")
	@ResponseBody
	public byte[] downProcess(HttpServletResponse resp, @RequestParam("filename")String filename) throws Exception {
		System.out.println("filename : "+filename);
		File file = new File("C:\\Users\\mylov\\OneDrive\\ドキュメント\\GitHub\\Acorn-Academy\\sprweb40fileupload\\src\\main\\resources\\static\\upload\\"+filename);
		byte[] bytes = FileCopyUtils.copyToByteArray(file); //직렬화
//		String fn = new String(file.getName().getBytes(), "iso_8859_1");
		String fn = new String(file.getName().getBytes(), "utf-8");
		resp.setHeader("Content-Disposition","attachment;filename=\""+fn+"\""); // 브라우저에게 컨텐츠의 성향을 알려주는 속성 지시 => 지시받은 파일은 파싱하지 않는다.
		resp.setContentLength(bytes.length);
		return bytes;
	}
}
