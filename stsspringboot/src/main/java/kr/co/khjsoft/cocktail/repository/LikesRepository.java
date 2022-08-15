package kr.co.khjsoft.cocktail.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import kr.co.khjsoft.cocktail.cocktailList.CocktailDetail;
import kr.co.khjsoft.cocktail.cocktailList.Likes;
import kr.co.khjsoft.cocktail.member.Member;

public interface LikesRepository extends JpaRepository<Likes, Long>{
	Optional<Likes> findByMemberAndCocktailDetail(Member member, CocktailDetail cocktaildetail);
}
