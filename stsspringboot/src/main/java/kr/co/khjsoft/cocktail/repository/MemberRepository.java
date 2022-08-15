package kr.co.khjsoft.cocktail.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
//import org.springframework.data.jpa.repository.Query;

import kr.co.khjsoft.cocktail.member.Member;

//DAO
//자동으로 bean 등록이 된다
//@Repository 생략 가능 
public interface MemberRepository extends JpaRepository<Member, Integer>{
	Optional<Member> findByUserid(String userid);
	
}
	//전통적인 방식 로그인
	//JPA 네이밍 쿼리
	//Member findByUseridAndUserpw(String Userid, String Userpw);

	//	@Query(value="SELECT * FROM member WHERE userid=?1 AND userpw=?2", nativeQuery=true)
	//	Member login(String userid, String userpw);