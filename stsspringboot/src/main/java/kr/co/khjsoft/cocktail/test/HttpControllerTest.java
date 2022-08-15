package kr.co.khjsoft.cocktail.test;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import kr.co.khjsoft.cocktail.member.Member;
import kr.co.khjsoft.cocktail.member.RoleType;
import kr.co.khjsoft.cocktail.repository.MemberRepository;

@RestController
public class HttpControllerTest {
	
	private static final String TAG = "HttpControllerTest : ";
	
	// localhost:8000/blog/http/lombok
//	@GetMapping("/http/lombok")
//	public String lombokTest() {
//		Member m = Member.builder().username("ssar").password("1234").email("ssar@nate.com").build();
//		System.out.println(TAG+"getter : "+m.getUsername());
//		m.setUsername("cos");
//		System.out.println(TAG+"setter : "+m.getUsername());
//		return "lombok test 완료";
//	}
//	
	
	// 인터넷 브라우저 요청은 무조건 get요청밖에  할 수 없다.
	// http://localhost:8080/http/get (select)
	@Autowired
	private MemberRepository memberRepository;
	@GetMapping("/http/get")
	public String getTest(Member member) { //id=1&username=ssar&password=1234&email=ssar@nate.com // MessageConverter (스프링부트)
		System.out.println("userid : "+member.getUserid());
		System.out.println("userpw : "+member.getUserpw());
		System.out.println("username : "+member.getUsername());
		System.out.println("userphonenum : "+member.getUserphonenum());
		System.out.println("role : "+member.getRole());
		System.out.println("createDate : "+member.getCreateDate());
		member.setRole(RoleType.VISITOR);
		memberRepository.save(member);
		return "회원가입이 완료되었습니다!!.";
		//		return "get 요청 : "+m.getUserid()+", "+m.getUserpw()+", "+m.getUsername()+", "+m.getUserphonenum();
	}
	
	// http://localhost:8080/http/post (insert)
	@PostMapping("/http/post") // text/plain, application/json 
	public String postTest(@RequestBody Member member) { // MessageConverter (스프링부트)
		
		return "post 요청:"+member.getUserid()+", "+member.getUserpw()+", "+member.getUsername()+", "+member.getUserphonenum();
	}
	
	// http://localhost:8080/http/put (update)
	@PutMapping("/http/put")
	public String putTest(@RequestBody Member member) { 
		return "put 요청 : "+member.getUserid()+", "+member.getUserpw()+", "+member.getUsername()+", "+member.getUserphonenum();
	}
	
	// http://localhost:8080/http/delete (delete)
	@DeleteMapping("/http/delete")
	public String deleteTest() {
		return "delete 요청";
	}
}