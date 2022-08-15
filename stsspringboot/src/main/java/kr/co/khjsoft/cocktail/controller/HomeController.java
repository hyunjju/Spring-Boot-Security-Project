package kr.co.khjsoft.cocktail.controller;

import java.util.List;

import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.web.PageableDefault;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;

import kr.co.khjsoft.cocktail.cocktailList.CocktailDetail;
import kr.co.khjsoft.cocktail.service.CocktailService;

@Controller

public class HomeController { 
	
	private CocktailService cocktailService;
//	@GetMapping("/")
//	public String home() {
//		//System.out.println("home controller start");
//		return "home";
//		}
//	@GetMapping("login")
//	public String login() {
//		//System.out.println("로그인 페이지 이동완료");
//		return "login";
//		}
//	@GetMapping("ModifyMember")
//	public String ModifyMember() {
//		//System.out.println("회원가입 페이지 이동완료");
//		return "ModifyMember";
//		}
	
	
	
	@GetMapping("favorites")
	public String favorites() {
		//System.out.println("favorites 페이지로 이동완료");
		return "favorites";
		}
	@GetMapping("/auth/findShop")
	public String findShop() {
		//System.out.println("findShop 페이지로 이동완료");
		return "findShop";
		}
//	@GetMapping("/auth/cocktailsearch/{gin}")
//	public String gin(Model model,@PathVariable String gin) {
//		model.addAttribute("cocktaildetailsearch",cocktailService.진검색(gin));
//		return "cocktailSearchList";
//
//		}
//	@GetMapping("board")
//	public String board() {
//		//System.out.println("board 페이지로 이동완료");
//		return "board";
//		}
//	@GetMapping("cocktailDetail")
//	public String cocktailDetail() {
//		//System.out.println("cocktailDetail 페이지로 이동완료");
//		return "cocktailDetail";
//		}
	}

