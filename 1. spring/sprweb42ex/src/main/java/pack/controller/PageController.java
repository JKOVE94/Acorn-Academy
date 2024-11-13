package pack.controller;

import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardCopyOption;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import pack.dto.SangDto;
import pack.entity.Sajindata;
import pack.entity.Sangdata;
import pack.model.Service;
import pack.repository.SajindataRepository;
import pack.repository.SangdataRepository;

@Controller
public class PageController {

	@Value("${file.upload.dir}")
	private String dirPath;

	@Autowired
	private Service service;

	@Autowired
	private SangdataRepository sangdataRepository;

	@Autowired
	private SajindataRepository sajindataRepository;

	@GetMapping("/")
	public String index() {
		return "index";
	}

	@GetMapping("show")
	public String show(Model model) {
		List<SangDto> sangpumlist = service.getSangpumlist();
		model.addAttribute("sangpums", sangpumlist);
		return "show";
	}

	@GetMapping("show2")
	public String show2(Model model) {
		return "show2";
	}

	@GetMapping("insert")
	public String insert() {
		return "insert";
	}

	@PostMapping("insert")
	public String insertProcess(@RequestParam("file")MultipartFile file, SangForm sangForm, @RequestParam("sajinabout")String sajinabout) {
		  try {
		        // 파일 유효성 검사
		        if (file.isEmpty()) {
		            throw new RuntimeException("파일이 업로드되지 않았습니다.");
		        }

		        // 파일 업로드 처리
		        String fileName = System.currentTimeMillis() + "_" + file.getOriginalFilename();
		        Path uploadPath = Paths.get(dirPath);
		        if (Files.notExists(uploadPath)) Files.createDirectories(uploadPath);
		        Path filePath = uploadPath.resolve(fileName);
		        Files.copy(file.getInputStream(), filePath, StandardCopyOption.REPLACE_EXISTING);

		        // SajinForm 객체 생성 및 데이터 설정
		        SajinForm sajinform = new SajinForm();
		        sajinform.setAbout(sajinabout);
		        sajinform.setFilepath(filePath.toString());
		        
		        service.uploadPic(sangForm, sajinform);

		        return "redirect:/";  // 정상적으로 완료되면 홈 화면으로 리다이렉트
		    } catch (Exception e) {
		        // 에러 처리 및 로그 출력
		        System.out.println("insertProcess err: " + e.getMessage());
		        return "redirect:/error";  // 에러 페이지로 리다이렉트
		    }
	}
}
