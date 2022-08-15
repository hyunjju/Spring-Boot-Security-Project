 package kr.co.khjsoft.cocktail.service;



import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import kr.co.khjsoft.cocktail.cocktailList.CocktailDetail;
import kr.co.khjsoft.cocktail.repository.CocktailRepository;








@Service
public class CocktailService {

 	@Autowired
	private CocktailRepository cocktailRepository;
	

	@Transactional(readOnly = true)
	public Page<CocktailDetail> 칵테일목록(Pageable pageable){
		return cocktailRepository.findAll(pageable);
	}
	
	@Transactional(readOnly = true)
	public CocktailDetail 칵테일상세보기(int num) {
		
		return cocktailRepository.findById(num)
				.orElseThrow(()->{
					return new IllegalArgumentException("글 상세보기 실패 : 칵테일정보를 찾을 수 없습니다.");
				});
	}
	 
//	 @Transactional
//	    public List<CocktailDetail> 강력한놈순(List<CocktailDetail> cocktaildetail) {
//	        return cocktailRepository.findAllDesc();
//
//
//	    }

	public List<CocktailDetail> 진검색(String gin) {
		List<CocktailDetail> cocktails = cocktailRepository.findByIngredientsContaining(gin);
	return cocktails;
}
	@Transactional 
	public int updateCnt(int cocktailnum) {
		return cocktailRepository.updateCnt(cocktailnum);
	}

}

