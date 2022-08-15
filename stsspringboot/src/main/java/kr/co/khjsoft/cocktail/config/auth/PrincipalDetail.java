package kr.co.khjsoft.cocktail.config.auth;

import java.util.ArrayList;
import java.util.Collection;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import kr.co.khjsoft.cocktail.member.Member;
import lombok.Getter;

//스프링사큐라티가 로그인 요청을 가로채서 로그인을 진행하고 완료가 되면 UserDetails 타입의 오브젝트를
//스프링 시큐리티의 고유한 세션 장소에 저장을 해준다 
@Getter
public class PrincipalDetail implements UserDetails {
	private Member member;
	
	public PrincipalDetail(Member member) {
		this.member = member;
	}

	
	@Override
	public String getPassword() {
		return member.getUserpw();
	}

	@Override
	public String getUsername() {
		return member.getUserid();
	}

	//계정이 만료되지 않았는지 리턴( true : 만료 안됨 ) 
	@Override
	public boolean isAccountNonExpired() {
		// TODO Auto-generated method stub
		return true;
	}
	
	//계정이 잠겨있지 않았는지 리턴 ( ture : 잠기지 않음 )
	@Override
	public boolean isAccountNonLocked() {
		// TODO Auto-generated method stub
		return true;
	}

	//비밀번호가 만료되지 않았는지 리턴 ( ture : 잠기지 않음 )
	@Override
	public boolean isCredentialsNonExpired() {
		// TODO Auto-generated method stub
		return true;
	}

	//계정이 활성화(사용가능)인지 리턴 ( ture : 활성화 )
	@Override
	public boolean isEnabled() {
		return true;
	} 
	
	//계정이 갖고 있는 권한 목록을 리턴한다(권한이 여러개 있을 수 있어서 루프를돌아야 하는데)
	@Override
	public Collection<? extends GrantedAuthority> getAuthorities() {
		
		Collection<GrantedAuthority> collectors = new ArrayList<>();
		collectors.add(()->{return "ROLE_"+member.getRole();});
		
		return collectors;
	}
	
}
