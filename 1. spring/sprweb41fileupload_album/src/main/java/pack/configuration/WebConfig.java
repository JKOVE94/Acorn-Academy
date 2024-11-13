package pack.configuration;

import java.nio.file.Path;
import java.nio.file.Paths;

import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
public class WebConfig implements WebMvcConfigurer{ //MVC설정관련 인터페이스

	@Override
	public void addResourceHandlers(ResourceHandlerRegistry registry) {
		// 정적 리소스 (이미지, CSS, JS 등) 경로 추가 설정 담당
		// upload 경로 설정 이 목적
		Path uploadDir = Paths.get("./uploads");
		// uploads 절대 경로 얻기
		String uploadPath = uploadDir.toFile().getAbsolutePath();
		
		// /uploads/test.png 라는 URL이 들어오면 uploads 디렉토리 내에 test.png를 반환
		registry.addResourceHandler("/uploads/**").addResourceLocations("file:"+uploadPath + "/");
		// "file:" + uploadPath + "/" => 파일 시스템의 uploads 디렉토리 경로를 나타낸다.
		//"file:" 접두사를 붙임으로 해서 이 경로가 파일 시스템의 경로임을 지정한다.
	}
}
