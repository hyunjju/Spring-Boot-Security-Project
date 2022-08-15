package kr.co.khjsoft.cocktail.test;

import java.util.List;
import java.util.function.Supplier;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.web.PageableDefault;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import kr.co.khjsoft.cocktail.member.Member;
import kr.co.khjsoft.cocktail.member.RoleType;
import kr.co.khjsoft.cocktail.repository.MemberRepository;


@RestController
public class DummyControllerTest {

	@Autowired //의존성 주입 
	private MemberRepository memberRepository;

	// save함수는 id를 전달하지 않으면 insert를 해주고
	// save함수는 id를 전달하면 해당 id에 대한 데이터가 있으면 update를 해주고
	// save함수는 id를 전달하면 해당 id에 대한 데이터가 없으면 insert를 함 
	// 전화번호, 비밀번호 
	
	@DeleteMapping("/dummy/member/{num}")
	public String delete(@PathVariable int num) {
		try {
			memberRepository.deleteById(num);
		}catch(EmptyResultDataAccessException e) {
			return "삭제 실패 해당 num 은 DB 에 없다";
		}
		
		return "삭제 완료  num :" + num;
		
	}

	@Transactional
	@PutMapping("/dummy/member/{num}")
	public Member updateMember(@PathVariable int num,@RequestBody Member requestMember) {
		System.out.println("num : "+num);
		System.out.println("password : "+requestMember.getUserpw());
		System.out.println("phonenum : "+requestMember.getUserphonenum());

		Member member = memberRepository.findById(num).orElseThrow(()->{
			return new IllegalArgumentException("수정 실패");
		});
		member.setUserpw(requestMember.getUserpw());
		member.setUserphonenum(requestMember.getUserphonenum());
		//requestMember.setNum(num);
		//requestMember.setUsername("");

		//memberRepository.save(requestMember);
		return member;
	}


	//http://localhost:8080/dummy/member
	@GetMapping("/dummy/members")
	public List<Member> list(){
		return memberRepository.findAll();

	}

	//한페이지당 2건의 데이터를 리턴받아볼 예정
	@GetMapping("/dummy/member")
	public List<Member> pageList(@PageableDefault(size=2, sort="num", direction=Sort.Direction.DESC)Pageable pageable){
		Page<Member> pagingMember = memberRepository.findAll(pageable);

		List<Member> members = pagingMember.getContent();
		return members;

	}

	//{id} 주소로 파라미터를 전달 받을 수 있음
	//http://localhost:8080/dummy/member/3}
	@GetMapping("/dummy/member/{num}")
	public Member detail(@PathVariable int num){
		Member member = memberRepository.findById(num).orElseThrow(new Supplier<IllegalArgumentException>() {
			@Override
			public IllegalArgumentException get() {
				return new IllegalArgumentException("해당 사용자가 없습니다." + num);
			}
		});
		// 요청 : 웹브라우저
		// user 객체 = 자바 오브젝트
		// 변환 ( 웹브라우저가 이해할 수 있는 데이터) -> json (Gson 라이브러리)
		// 스프링부트 = MessageConverter라는 애가 응답시에 자동 작동
		// 만약에 자바 오브젝트를 리턴하게 되면 MessageConverter가 Jackson 라이브러리를 호출해서
		// member 오브젝트를 json으로 변환해서 브라우저에게 던져줍니다.
		return member;

	}


	@PostMapping("/dummy/join")//Member member
	public String join(Member member) {

		System.out.println("userid : "+member.getUserid());
		System.out.println("userpw : "+member.getUserpw());
		System.out.println("username : "+member.getUsername());
		System.out.println("userphonenum : "+member.getUserphonenum());
		System.out.println("role : "+member.getRole());
		System.out.println("createDate : "+member.getCreateDate());


		member.setRole(RoleType.VISITOR);
		memberRepository.save(member);
		return "회원가입이 완료되었습니다.";
	}
}
