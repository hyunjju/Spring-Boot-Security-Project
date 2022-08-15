package kr.co.khjsoft.cocktail.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import kr.co.khjsoft.cocktail.service.ChatBotService;

@RestController
public class JsonController {
	@Autowired
	private ChatBotService chatBotService;
	
	@GetMapping("/auth/chatbot")
	public String chatbot(HttpServletRequest request, HttpServletResponse response){
		String result = chatBotService.download(request, response);
		return result;
	}

}
