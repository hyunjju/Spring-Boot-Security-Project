package kr.co.khjsoft.cocktail.service;



import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import kr.co.khjsoft.cocktail.member.Member;
import kr.co.khjsoft.cocktail.member.RoleType;
import kr.co.khjsoft.cocktail.repository.MemberRepository;

@Service
public class MemberService {
	
	@Autowired
	private MemberRepository memberRepository;
	
	@Autowired
	private BCryptPasswordEncoder encoder;
	
	@Transactional(readOnly = true)
	public Member 회원찾기(String userid) {
		Member member = memberRepository.findByUserid(userid).orElseGet(()->{
			return new Member();
		});
		return member;
	}
		
	
	
	@Transactional
	public void 회원가입(Member member) {
		String rawPassword = member.getUserpw(); //1234 원문 
		String encPassword = encoder.encode(rawPassword); // 해쉬
		member.setUserpw(encPassword);
		member.setRole(RoleType.VISITOR);
		memberRepository.save(member);

	}
	
	@Transactional
	public void 회원수정(Member member) {
		//수정시에는 영속성 컨텍스트 User 오브젝트를 영속화시키고, 영속화된 User 오브젝트를 수정
		//select 를 해서 User 오브젝트를 DB로 부터 가져오는 이유는 영속화를 하기 위해서
		//영속화된 오브젝트를 변경하면 자동으로 DB 에 update 문을 날려준다 
		
		Member persistance = memberRepository.findByUserid(member.getUserid()).orElseThrow(()->{
			return new IllegalArgumentException("회원 찾기 실패");
		});
		
		//Validate 체크 
		if(persistance.getOauth()==null || persistance.getOauth().equals("")) {
			String rawPassword = member.getUserpw();
			String encPassword = encoder.encode(rawPassword);
			persistance.setUserpw(encPassword);
			persistance.setUserphonenum(member.getUserphonenum());
		}
		
		
		// 회원수정 함수 종료시 = 서비스 종료 = 트랜잭션 종료 = commit이 자동으로 됨.
		// 영속화된 persistance 객체의 변화가 감지되면 더티체킹이 되어 update문을 날려줌. 
	
	}
}


//try {
//
//return 1;
//}catch(Exception e) {
//e.printStackTrace();
//System.out.println("MemberService : 회원가입() :" + e.getMessage());
//}
//return -1;


//전통적인 로그인 방식
//@Transactional(readOnly=true)// Select 할 때 트랜잭션 시작, 서비스 종료시에 트랜잭션 종료 ( 정합성 )
//public Member 로그인(Member member) {
//return memeberRepository.findByUseridAndUserpw(member.getUserid(), member.getUserpw());
//}