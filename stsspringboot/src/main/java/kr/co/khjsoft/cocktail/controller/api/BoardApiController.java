package kr.co.khjsoft.cocktail.controller.api;
  
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import kr.co.khjsoft.cocktail.board.Board;
import kr.co.khjsoft.cocktail.config.auth.PrincipalDetail;
import kr.co.khjsoft.cocktail.dto.ReplySaveRequestDto;
import kr.co.khjsoft.cocktail.dto.ResponseDto;
import kr.co.khjsoft.cocktail.service.BoardService;

@RestController 
public class BoardApiController {

	@Autowired
	private BoardService boardService;
	
	@PostMapping("/api/board")
	public  ResponseDto<Integer> save(@RequestBody Board board, @AuthenticationPrincipal PrincipalDetail principal) {
		boardService.글쓰기(board, principal.getMember());
		return new ResponseDto<Integer>(HttpStatus.OK.value(),1);
	}
	 
	@DeleteMapping("/api/board/{num}")
	public ResponseDto<Integer> deleteById(@PathVariable int num){
		boardService.글삭제하기(num); 
		return new ResponseDto<Integer>(HttpStatus.OK.value(), 1); 
	}
	
	@PutMapping("/api/board/{num}")
	public ResponseDto<Integer> update(@PathVariable int num, @RequestBody Board board){
		
		boardService.글수정하기(num, board);
		return new ResponseDto<Integer>(HttpStatus.OK.value(), 1);
	}
	
	//데이터 받을때 컨트롤러는 dto 만들어서 받는게 좋다
	//dto 사용하지 않는 이유 
	@PostMapping("/api/board/{boardnum}/reply")
	public  ResponseDto<Integer> replySave(@RequestBody ReplySaveRequestDto replySaveRequestDto) {
		boardService.댓글쓰기(replySaveRequestDto);
		return new ResponseDto<Integer>(HttpStatus.OK.value(),1);
	}
	
	@DeleteMapping("/api/board/{boardnum}/reply/{replynum}")
	public ResponseDto<Integer> replyDelete(@PathVariable int replynum) {
		boardService.댓글삭제(replynum);
		return new ResponseDto<Integer>(HttpStatus.OK.value(), 1); 
	}
	
	
} 

  
//전통적인 방식의 로그인 방식
//@PostMapping("/api/member/login")
//public ResponseDto<Integer> login(@RequestBody Member member, HttpSession session){
//	System.out.println("MemberApiController : login 호출됨");
//	
//	Member principal = memberService.로그인(member);
//	
//	if(principal != null) {
//		session.setAttribute("principal", principal);
//	}
//	return new ResponseDto<Integer>(HttpStatus.OK.value(),1);
//
//}
