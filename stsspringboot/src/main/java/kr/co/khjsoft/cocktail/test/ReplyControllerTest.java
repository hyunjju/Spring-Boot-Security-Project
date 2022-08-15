package kr.co.khjsoft.cocktail.test;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import kr.co.khjsoft.cocktail.board.Board;
import kr.co.khjsoft.cocktail.board.Reply;
import kr.co.khjsoft.cocktail.repository.BoardRepository;
import kr.co.khjsoft.cocktail.repository.ReplyRepository;

@RestController
public class ReplyControllerTest {
	@Autowired
	private BoardRepository boardRepository;
	
	@Autowired
	private ReplyRepository replyRepository;
	
	@GetMapping("/test/board/{num}")
	public Board getBoard(@PathVariable int num) {
		return boardRepository.findById(num).get(); // jackson 라이브러리 (오브젝트를 json으로 리턴) => 모델의 getter를 호출
	}
	
	@GetMapping("/test/reply")
	public List<Reply> getReply() {
		return replyRepository.findAll(); // jackson 라이브러리 (오브젝트를 json으로 리턴) => 모델의 getter를 호출
	}

}
