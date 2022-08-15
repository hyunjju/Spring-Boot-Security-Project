package kr.co.khjsoft.cocktail.config.auth;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import kr.co.khjsoft.cocktail.member.Member;
import kr.co.khjsoft.cocktail.repository.MemberRepository;

@Service // Bean 등록 
public class PrincipalDetailService implements UserDetailsService{
	
	@Autowired
	private MemberRepository memberRepository;
	
	// 스프링이 로그인 요청을 가로챌 때, username,password 변수 2개를 가로채는데
	// password 부분 처리는 알아서 함.
	// username 이 DB에 있는지만 확인해주면 됨. 
	@Override
	public UserDetails loadUserByUsername(String userid) throws UsernameNotFoundException{
		Member principal = memberRepository.findByUserid(userid)
				.orElseThrow(()->{
					return new UsernameNotFoundException("해당 사용자를 찾을 수 없다:" + userid);
				});
		return new PrincipalDetail(principal); //시큐리티 세션에 유저정보가 저장이 된다 , type : UserDetails
	}

}
