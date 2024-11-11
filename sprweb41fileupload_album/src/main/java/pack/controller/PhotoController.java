package pack.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

import jakarta.servlet.http.HttpSession;
import pack.repository.PhotosRepository;
import pack.repository.UsersRepository;
import pack.service.PhotosService;
import pack.service.UsersService;

@Controller
public class PhotoController {

	@Autowired
	private HttpSession session;
	
	@Value("${file.upload.dir}")
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
	
}
