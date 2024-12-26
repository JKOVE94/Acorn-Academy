package pack;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
@EnableWebSecurity
public class SecurityConfig {

	//Spring Security의 Role (역할) : 사용자의 접근 권한을 그룹화하고 관리하는 개념 -> 사용자는 1개 이상의 role을 가질 수 있음
	//시스템에서 사용자가 어떤 기능이나 경로에 접근 할 수 있는지를 결정
	//Role은 일반적으로 접두사 "ROLE_"를 포함. ex) ROLE_ADMIN, ROLE_USER ...
	// hasRole() : 내부적으로 ROLE_ADMIN을 확인 , hasAuthority() : 접두사 없이 권한을 직접 확인
	// 장점 : 관리가 편리, 확장성, 보안 강화 ...
	
	@Bean
	public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
		http.authorizeHttpRequests(auth -> 
				auth.requestMatchers("/admin").hasRole("ADMIN") //ADMIN 권한만 접근 허용
					.requestMatchers("/user").hasRole("USER")
					.requestMatchers("/james").hasRole("JAMES")
					.requestMatchers("/common").permitAll()
					.anyRequest().authenticated()
			)
			.formLogin(form -> 
				form.loginPage("/login")
					.defaultSuccessUrl("/default", true)
					.permitAll()			
			)
			.logout(logout -> 
				logout.logoutUrl("/logout")
				.permitAll()
			);
		return http.build();
	}
	
	@Bean
	public UserDetailsService userDetailsService() {
		UserDetails adminUser = User.builder()
									.username("admin")
									.password(passwordEncoder().encode("admin123"))
									.roles("ADMIN")
									.build();
		
		UserDetails normalUser = User.builder()
				.username("user")
				.password(passwordEncoder().encode("user123"))
				.roles("USER")
				.build();
		
		UserDetails jamesUser = User.builder()
				.username("james")
				.password(passwordEncoder().encode("james123"))
				.roles("JAMES")
				.build();
		
		return new InMemoryUserDetailsManager(adminUser, normalUser, jamesUser);
	}
	
	@Bean
	public PasswordEncoder passwordEncoder() {
		return new BCryptPasswordEncoder();
	}
}
