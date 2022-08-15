package kr.co.khjsoft.cocktail.controller.api;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import kr.co.khjsoft.cocktail.config.auth.PrincipalDetail;
import kr.co.khjsoft.cocktail.service.LikesService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@RequiredArgsConstructor
@RestController
public class LikesApiController {
	 private final LikesService likesService;

	    @PostMapping("/api/likes/{cocktailnum}")
	    public ResponseEntity<String> addLike(
	        @AuthenticationPrincipal PrincipalDetail principal, 
	        @PathVariable int cocktailnum) {

	        boolean result = false;

	        if (principal != null) {
	            result = likesService.addLike(principal.getMember(), cocktailnum);
	        }

	        return result ?
	                new ResponseEntity<>(HttpStatus.OK)
	                : new ResponseEntity<>(HttpStatus.BAD_REQUEST);
	    }
}
