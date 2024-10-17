package pack;

import javax.servlet.*;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;
import javax.crypto.SecretKey;
import javax.crypto.KeyGenerator;
import java.util.Base64;

@WebServlet(loadOnStartup = 1)
public class InitServlet extends HttpServlet {
public void init() throws ServletException {
        try {
            // 비밀 키 생성
            KeyGenerator keyGen = KeyGenerator.getInstance("HmacSHA256");
            keyGen.init(256); // 256비트 길이의 키 생성
            SecretKey secretKey = keyGen.generateKey();
            /*
            실제 비밀 키는 KeyGenerator 객체가 생성한 후 SecretKey 객체로 반환된다. 
            이 SecretKey 객체는 메모리에 존재하며, 파일이나 데이터베이스와 같은 외부 저장소에 
            저장하려면 명시적으로 저장하는 코드를 작성해야 한다.
             */

            // 비밀 키를 Base64로 인코딩하여 문자열로 변환  java.util.Base64
            String encodedKey = Base64.getEncoder().encodeToString(secretKey.getEncoded());
            System.out.println("encodedKey : " + encodedKey);
            // 서블릿 컨텍스트에 비밀 키 저장
            getServletContext().setAttribute("secretKey", encodedKey);
        } catch (Exception e) {
            throw new ServletException("키 생성 오류", e);
        }
    }
}