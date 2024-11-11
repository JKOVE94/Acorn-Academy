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
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import pack.dto.SangDto;
import pack.model.Service;

@Controller
public class PageController {

	@Value("${file.upload.dir}")
	private String dirPath;
	
	@Autowired
	private Service service;
	
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
			String fileName = System.currentTimeMillis()+"_"+file.getOriginalFilename();
			Path uploadPath = Paths.get(dirPath);
			if(Files.notExists(uploadPath)) Files.createDirectories(uploadPath);
			Path filePath = uploadPath.resolve(fileName);
			Files.copy(file.getInputStream(), filePath, StandardCopyOption.REPLACE_EXISTING);
			
			SajinForm sajinform = new SajinForm();
			sajinform.setAbout(sajinabout);
			sajinform.setFilepath(sajinabout);
			sajinform.setFilepath(filePath.toString());
			sajinform.setSangdata(SangForm.toEntity(sangForm));
			service.uploadSang(sangForm);
			service.uploadPic(sajinform);
			
			return "redirect:/";
			
		} catch (Exception e) {
			System.out.println("insertProcess err : "+e);
			return "redirect:/";
		}
		
	}
	
}
