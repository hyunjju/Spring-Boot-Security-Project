package kr.co.khjsoft.cocktail.controller.api;

import javax.servlet.http.HttpSession;

//import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.security.core.context.SecurityContext;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import kr.co.khjsoft.cocktail.config.auth.PrincipalDetail;
import kr.co.khjsoft.cocktail.dto.ResponseDto;
import kr.co.khjsoft.cocktail.member.Member;
import kr.co.khjsoft.cocktail.member.RoleType;
import kr.co.khjsoft.cocktail.service.MemberService;

@RestController
public class MemberApiController {
	
	@Autowired
	private MemberService memberService;
	
	@Autowired
	private BCryptPasswordEncoder encode;

	@Autowired
	private AuthenticationManager authenticationManager;
	 
	@PostMapping("/auth/joinMemberProc")
	public  ResponseDto<Integer> save(@RequestBody Member member) {
		System.out.println("MemberApiController : save 호출됨");
		//실제로 DB에 insert를 하고 아래에서 return이 되면 된다
		
		//int result = memberService.회원가입(member);
		memberService.회원가입(member);
		return new ResponseDto<Integer>(HttpStatus.OK.value(),1);
	}
	
	@PutMapping("/member")
	public  ResponseDto<Integer> update(@RequestBody Member member) {
	
		memberService.회원수정(member);
		//트랜젝션이 종료되기 때문에 DB 의 값은 변경이 되어있음 
		//하지만 세션값은 변경이 되지 않은 상태이기 때문에 직접 세션값을 변경해준다 
		
		//세션 등록 
		Authentication authentication = authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(member.getUserid(), member.getUserpw()));
		SecurityContextHolder.getContext().setAuthentication(authentication);
		
		
		return new ResponseDto<Integer>(HttpStatus.OK.value(),1);
	}  
	
} 


//전통적인 방식의 로그인 방식
//@PostMapping("/api/member/login")
//public ResponseDto<Integer> login(@RequestBody Member member, HttpSession session){
//	System.out.println("MemberApiController : login 호출됨");
//	
//	Member principal = memberService.로그인(member);
//	
//	if(principal != null) {
//		session.setAttribute("principal", principal);
//	}
//	return new ResponseDto<Integer>(HttpStatus.OK.value(),1);
//
//}
