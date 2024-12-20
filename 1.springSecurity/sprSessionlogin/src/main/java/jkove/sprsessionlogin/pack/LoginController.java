package jkove.sprsessionlogin.pack;

import jakarta.servlet.http.HttpSession;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class LoginController {
    @GetMapping("/login")
    public String login() {
        return "login";
    }

    @PostMapping("/login")
    public String login(@RequestParam(name="userid") String userid, @RequestParam(name="password") String password, HttpSession session, Model model) {
        String validid = "ok";
        String validpwd = "111";

        if(userid.equals(validid) && password.equals(validpwd)) {
            session.setAttribute("user", userid);
            return "redirect:/success";
        } else {
            model.addAttribute("error", "입력 정보 오류");
            return "login";
        }
    }
    @GetMapping("/success")
    public String success(HttpSession session, Model model)
    {
        String user = (String) session.getAttribute("user");
        if(user == null) {
            return "redirect:/login";
        }
        model.addAttribute("myuser", user);
        return "success";
    }

    @GetMapping("/logout")
    public String logout(HttpSession session) {
        session.removeAttribute("user");
        return "redirect:/";
    }

    @GetMapping("/gugu")
    public String gugu(HttpSession session) {
        String user = (String) session.getAttribute("user");
        if(user == null) {
            return "redirect:/login";
        }
        return "gugu";
    }
    @PostMapping("/gugu")
    public String gugu(@RequestParam(name="dan") int dan, HttpSession session, Model model) {
        String user = (String) session.getAttribute("user");
        if(user == null) {
            return "redirect:/login";
        }
        model.addAttribute("dan", dan);
        return "gugu";
    }
}
