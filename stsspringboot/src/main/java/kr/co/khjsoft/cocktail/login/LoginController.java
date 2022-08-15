package kr.co.khjsoft.cocktail.login;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class LoginController { 
	@GetMapping("home")
	public String home() {
		System.out.println("home controller start");

		return "home";
		}
	
	@GetMapping("findId")
	public String findId() {
		System.out.println("아이디/비밀번호 찾기");

		return "findId";
		}
	
	@GetMapping("joinMember")
	public String joinMember() {
		System.out.println("회원가입 페이지로 이동");

		return "joinMember";
		}
	}

