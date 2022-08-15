package kr.co.khjsoft.cocktail.service;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import kr.co.khjsoft.cocktail.cocktailList.CocktailDetail;
import kr.co.khjsoft.cocktail.cocktailList.Likes;
import kr.co.khjsoft.cocktail.member.Member;
import kr.co.khjsoft.cocktail.repository.CocktailRepository;
import kr.co.khjsoft.cocktail.repository.LikesRepository;
import lombok.RequiredArgsConstructor;

@Transactional
@RequiredArgsConstructor
@Service
public class LikesService {

	private final LikesRepository likesRepository;
    private final CocktailRepository cocktailRepository;

    public boolean addLike(Member member, int cocktailnum) {
        CocktailDetail cocktaildetail = cocktailRepository.findByCocktailnum(cocktailnum).orElseThrow();

        //중복 좋아요 방지
//        if(isNotAlreadyLike(member, cocktaildetail)) {
//            likesRepository.save(new Likes(cocktaildetail, member));
//            return true;
//        }

        return false;
    }

    //사용자가 이미 좋아요 한 게시물인지 체크
//    private boolean isNotAlreadyLike(Member member,CocktailDetail cocktaildetail) {
//        return likesRepository.findByMemberAndCocktailDetail(member, cocktaildetail).isEmpty();
//    }
}

