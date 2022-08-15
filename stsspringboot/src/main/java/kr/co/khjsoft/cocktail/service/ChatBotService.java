package kr.co.khjsoft.cocktail.service;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public interface ChatBotService {
	//proxy 역할 <cros> 
	public String download(HttpServletRequest request, HttpServletResponse response);

}
