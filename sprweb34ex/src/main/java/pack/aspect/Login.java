package pack.aspect;

import org.springframework.stereotype.Component;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

@Component
public class Login {
	public boolean getLogin(HttpServletRequest req, HttpServletResponse resp) throws Throwable{
		HttpSession session = req.getSession();
		System.out.println("session의 값 : "+session.getAttribute("login"));
		if(session.getAttribute("login")==null) {
			resp.sendRedirect("login");
			return true;
		}
		else return false;
	}
}
