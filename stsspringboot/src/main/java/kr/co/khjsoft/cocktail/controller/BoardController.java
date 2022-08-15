package kr.co.khjsoft.cocktail.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.web.PageableDefault;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import kr.co.khjsoft.cocktail.service.BoardService;
import kr.co.khjsoft.cocktail.service.CocktailService;

@Controller
public class BoardController {
	
// <우리끼리 하던 부분 >
//	@GetMapping("boardDetail")
//	public String boardDetail() {
//		//System.out.println("게시판 상세페이지 이동완료");
//		return "boardDetail";
//		}
	
	@Autowired
	private BoardService boardService;
	
	@Autowired
	private CocktailService cocktailService;
	
	
	
	//@AuthenticationPrincipal PrincipalDetail principals
	
	@GetMapping({"","/"})
	public String index(Model model,@Qualifier("pageable")@PageableDefault(size=10, sort="num", direction=Sort.Direction.DESC) Pageable pageable,
			@Qualifier("pageable2")@PageableDefault(size=3, sort="cnt", direction=Sort.Direction.DESC) Pageable pageable2) { 
		model.addAttribute("boards", boardService.글목록(pageable));
		model.addAttribute("cocktaildetail",cocktailService.칵테일목록(pageable2));
		return "index";
	}
	@GetMapping("/board/{num}")
	public String findById(@PathVariable int num, Model model) {
		model.addAttribute("board",boardService.글상세보기(num));
		return "board/detail";
	}
	
	@GetMapping("/board/{num}/updateForm")
	public String updateForm(@PathVariable int num, Model model) {
		model.addAttribute("board",boardService.글상세보기(num));
		return "board/updateForm";
	}
	
	//Member 권한이 필요
	@GetMapping("/board/saveForm")
	public String saveForm() { //컨트롤러로 세션을 어떻게 찾나 
		return "board/saveForm";
	}

	@GetMapping("/auth/board/board")
	public String board(Model model, @PageableDefault(size=10, sort="num", direction=Sort.Direction.DESC) Pageable pageable) { //컨트롤러로 세션을 어떻게 찾나 
		model.addAttribute("boards", boardService.글목록(pageable));
		return "board/board";
	}
}
