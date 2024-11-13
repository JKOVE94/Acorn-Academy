package pack.aspect;

import org.springframework.stereotype.Component;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

@Component
public class LoginClass {

	public boolean loginCheck(HttpServletRequest req, HttpServletResponse res) throws Exception{
		HttpSession session = req.getSession();
		
		if(session.getAttribute("name") == null) {
			res.sendRedirect("login");
			return true;
		}
		else return false;
		
	}
}
