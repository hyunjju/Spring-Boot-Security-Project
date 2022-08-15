package kr.co.khjsoft.cocktail.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
//import org.springframework.data.jpa.repository.Query;
import org.springframework.data.jpa.repository.Query;

import kr.co.khjsoft.cocktail.cocktailList.CocktailDetail;

public interface CocktailRepository extends JpaRepository<CocktailDetail, Integer>{
	
	Optional<CocktailDetail> findByCocktailnum(int cocktailnum);

//	List<CocktailDetail> findByIngredientsContaining(String gin);
	
//	@Query(
//			value = "SELECT * FROM CocktailDetail cd WHERE cd.ingredients Like '%진%'",
//			nativeQuery = true)
			List<CocktailDetail> findByIngredientsContaining(String gin);
			
			@Modifying
			@Query("update CocktailDetail c set c.cnt = c.cnt + 1 where c.cocktailnum = :cocktailnum") 
			int updateCnt(int cocktailnum);
}
