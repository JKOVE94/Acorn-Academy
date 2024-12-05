package pack.controller;

import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardCopyOption;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.core.io.Resource;
import org.springframework.core.io.UrlResource;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import jakarta.servlet.http.HttpSession;
import pack.dto.PhotosDto;
import pack.dto.UsersDto;
import pack.entity.Photos;
import pack.entity.Users;
import pack.repository.PhotosRepository;
import pack.repository.UsersRepository;
import pack.service.PhotosService;
import pack.service.UsersService;

@Controller
public class PhotoController {
	
	@Autowired
	private HttpSession session;
	
	@Value("${file.upload-dir}")
	private String uploadDir;
	
	@Autowired
	private PhotosService photoService;
	
	@Autowired
	private UsersService userService;
	
	@Autowired
	private PhotosRepository photosRepository;
	
	@Autowired
	private UsersRepository usersRepository;
	
	@GetMapping("/")
	public String login() {
		return "login";
	}
	
	@GetMapping("/login")
	public String showLoginForm() {
		return "login";
	}
	
	@PostMapping("/login")
	public String loginProcess(@RequestParam("userid")Long userid, @RequestParam("password")String password, Model model) {
		Optional<UsersDto> user = userService.getUserById(userid);
		if(user.isPresent() && user.get().getPassword().equals(password)) {
			session.setAttribute("usersidsession", userid);
			return "index";
		}
		else {
			model.addAttribute("error", "로그인 정보를 정확히 입력해주세요");
			return "login";
		}
	}
	
	//사진첩 보기
	@GetMapping("/show")
	public String viewPhoto(Model model, HttpSession session) {
		Long userid = (Long) session.getAttribute("usersidsession");
		if(userid==null) return "redirect:login";
		List<PhotosDto> photos = photoService.getPhotoByuserid(userid);
		if(photos.isEmpty()) {
			model.addAttribute("message", "현재 등록된 사진이 없습니다. 사진을 업로드하세요");
			return "upload";
		}
		model.addAttribute("photos",photos);		
		return "show";
	}
	
	@GetMapping("/upload")
	public String uploadForm() {
		return "upload";
	}
	
	//사진 업로드 처리
	@PostMapping("/upload")
	public String uploadPhoto(@RequestParam("file") MultipartFile file, 
			@RequestParam(value ="albumname", required = false)String albumname, 
			@RequestParam(value ="title", required = false)String title,
			@RequestParam(value ="description", required = false)String description,
			Model model) {
		try {
			Long userid = (Long) session.getAttribute("usersidsession");
			if(userid ==null) return "redirect:/login";
			//로그인이 인증된 경우 작업 계속
			Users user = usersRepository.findById(userid)
					.orElseThrow(() -> new RuntimeException("사용자를 찾을 수 없습니다."));
			//중복된 사진의 고유한 번호를 넣어주는 방법중 가장 좋은것은 시간을 넣어주는것이다.
			String fileName = System.currentTimeMillis() + "_" + file.getOriginalFilename();
			System.out.println("FileName : "+fileName);
			
			Path uploadPath = Paths.get(uploadDir);
			
			if(Files.notExists(uploadPath)) Files.createDirectories(uploadPath); // 해당 경로에 폴더가 없다면? 경로에 폴더 생성
			Path filePath = uploadPath.resolve(fileName); // resolve : fileName을 결합하여 최종 파일경로를 생성하는 메소드
			
			// 파일을 특정 경로로 복사하기, 이미 동일파일 존재 시 덮어쓰기 (StandardCopyOption.REPLACE_EXISTING)
			// Files.copy() : inputStream으로부터 파일을 읽어 filePath 위치에 파일을 저장함
			Files.copy(file.getInputStream(), filePath ,StandardCopyOption.REPLACE_EXISTING); 
			
			//사진 저장용 Form 생성
			PhotosForm form = new PhotosForm();
			form.setUserid(userid);
			form.setAlbumname(albumname);
			form.setTitle(title);
			form.setDescription(description);
			form.setFilepath(filePath.toString());
			photoService.savephoto(form);
			
			return "redirect:/show"; // 사진 저장후 사진첩 보기
		} catch (Exception e) {
			System.out.println("upload err : " + e);
			model.addAttribute("message", "파일 업로드 실패 :" + e.getMessage());
			return "upload";
		}			
	}
	
	//이미지 다운로드
	//ResponseEntity : Spring에서 파일(이미지) 등의 데이터를 HTTP응답으로 보내기 위한 Class 
	//Resource타입을 사용해 다운로드할 파일을 응답 본문에 포함시키는 HTTP 응답을 구성
	@GetMapping("/download/{photoId}")
	public ResponseEntity<Resource> downloadPhoto(@PathVariable(name = "photoId")Long photoId, Model model) {
		Photos photo = photosRepository.findById(photoId).orElseThrow(()-> new RuntimeException("사진이 없습니다."));
		try {
			//normalize()는 path객체에서 불필요한 주소를 생략해주는 역할을 해준다.
			// ex) abc/./test.png -> abc/test.png 
			Path filePath = Paths.get(photo.getFilepath()).normalize();
			System.out.println("파일 실제 경로 :" + filePath);
			
			//Resource는 다양한 형식을 받을 수 있다. (UrlResource)
			Resource resource = new UrlResource(filePath.toUri()); //URI형식으로 변환 file:// 
			System.out.println("파일을 uri 형식으로 :"+filePath.toUri());
			System.out.println("파일의 이름 :"+filePath.getFileName());
		
			//다운로드할 파일 존재 여부, 읽기 가능 여부 판단 후 작업 계속
			if(resource.exists() && resource.isReadable()) {
				String originalFileName = filePath.getFileName().toString();
				// Mime type을 파악하고 타입을 결정
				String contentType = Files.probeContentType(filePath);
				System.out.println("Filetype : " + contentType);
				
				if(contentType == null) {
					contentType= "application/octet-stream";
				}
				return ResponseEntity.ok()
						.contentType(MediaType.parseMediaType(contentType))
						.header(HttpHeaders.CONTENT_DISPOSITION, "attachment;filename=\""+originalFileName+"\"")
						.body(resource);
			}
			else {
				throw new RuntimeException("파일을 찾을 수 없거나 읽기 불가");				
			}
		} catch (Exception e) {
			System.out.println("downloadPhoto err :" + e);
			throw new RuntimeException("다운로드중 에러 발생 : "+e.getMessage());
		}
	}
}
