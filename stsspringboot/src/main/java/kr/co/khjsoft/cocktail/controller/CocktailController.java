package kr.co.khjsoft.cocktail.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.web.PageableDefault;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import kr.co.khjsoft.cocktail.cocktailList.CocktailDetail;
import kr.co.khjsoft.cocktail.repository.CocktailRepository;
import kr.co.khjsoft.cocktail.service.CocktailService;

@Controller
public class CocktailController {
	
	
		@Autowired
	private CocktailService cocktailService;
		@Autowired
		private CocktailRepository cocktailRepository;

	//@AuthenticationPrincipal PrincipalDetail principals
	@GetMapping({"/auth/cocktailList"})
	public String cocktailList(Model model, @PageableDefault(size=10, sort="cocktailEname", direction=Sort.Direction.DESC) Pageable pageable) { 
		model.addAttribute("cocktaildetail", cocktailService.칵테일목록(pageable));
		return "cocktailList";
	}
	@GetMapping("/auth/cocktailDetail/{cocktailnum}")
	public String findById(@PathVariable int cocktailnum, Model model) {
		//조회수
				cocktailService.updateCnt(cocktailnum);
		model.addAttribute("cocktaildetail",cocktailService.칵테일상세보기(cocktailnum));
		return "cocktailDetail";
	}
	

	@GetMapping("/auth/cocktailListNonAlc")
	public String cocktailListNonAlc(Model model, @PageableDefault(size=10, sort="cocktailEname", direction=Sort.Direction.ASC) Pageable pageable) {
		//System.out.println("showall 페이지로 이동완료");
		model.addAttribute("cocktaillistnonalc", cocktailService.칵테일목록(pageable));
		return "cocktailListNonAlc";
		}
	@GetMapping("/auth/cocktailListAlc")
	public String cocktailListAlc(Model model, @PageableDefault(size=10, sort="alc", direction=Sort.Direction.ASC) Pageable pageable) {
		//System.out.println("showall 페이지로 이동완료");
		model.addAttribute("cocktaildetailasc", cocktailService.칵테일목록(pageable));
		return "cocktailListAlc";
		}
	

	@GetMapping("/auth/cocktailListAlcDesc")
    public String cocktailListAlcDesc(Model model, @PageableDefault(size=10, sort="alc", direction=Sort.Direction.DESC) Pageable pageable) {
//        List<CocktailDetail> cocktailList = cocktailRepository.findAll();
//
//        model.addAttribute("cocktaildetaildesc", cocktailService.강력한놈순(cocktailList));
//       
		model.addAttribute("cocktaildetaildesc", cocktailService.칵테일목록(pageable));
     
        return "cocktailListAlcDesc";
    }
	@GetMapping({"/auth/ranking"})
	public String ranking(Model model, @PageableDefault(size=10, sort="cnt", direction=Sort.Direction.DESC) Pageable pageable) { 
		model.addAttribute("cocktaildetail", cocktailService.칵테일목록(pageable));
		return "ranking";
	}
	
	@GetMapping({"/auth/chat"})
	public String chat() {
		return "chatbot";
	}
	
	
}
