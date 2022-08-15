 package kr.co.khjsoft.cocktail.service;



import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import kr.co.khjsoft.cocktail.board.Board;
import kr.co.khjsoft.cocktail.board.Reply;
import kr.co.khjsoft.cocktail.dto.ReplySaveRequestDto;
import kr.co.khjsoft.cocktail.member.Member;
import kr.co.khjsoft.cocktail.member.RoleType;
import kr.co.khjsoft.cocktail.repository.BoardRepository;
import kr.co.khjsoft.cocktail.repository.MemberRepository;
import kr.co.khjsoft.cocktail.repository.ReplyRepository;

@Service
public class BoardService {
	@Autowired
	private MemberRepository memberRepository;
	@Autowired
	private BoardRepository boardRepository;
 	@Autowired
	private ReplyRepository replyRepository;
	
	@Transactional
	public void 글쓰기(Board board, Member member) {
		board.setCount(0);
		board.setMember(member);
		boardRepository.save(board);

	} 
	@Transactional(readOnly = true)
	public Page<Board> 글목록(Pageable pageable){
		return boardRepository.findAll(pageable);
	}
	
	@Transactional(readOnly = true)
	public Board 글상세보기(int num) {
		return boardRepository.findById(num)
				.orElseThrow(()->{
					return new IllegalArgumentException("글 상세보기 실패 : 아이디를 찾을 수 없습니다.");
				});
	}
	
	@Transactional 
	public void 글삭제하기(int num) {
		boardRepository.deleteById(num);
	}
	
	@Transactional
	public void 글수정하기(int num, Board requestBoard) {
		Board board = boardRepository.findById(num)
				.orElseThrow(()->{
					return new IllegalArgumentException("글 찾기 실패 : 아이디를 찾을 수 없습니다.");
				}); // 영속화 완료
		board.setTitle(requestBoard.getTitle());
		board.setContent(requestBoard.getContent());
		// 해당 함수로 종료시(Service가 종료될 때) 트랜잭션이 종료됩니다. 이때 더티체킹 - 자동 업데이트가 됨. db flush
	}
	@Transactional
	public void 댓글쓰기(ReplySaveRequestDto replySaveRequestDto) {
		replyRepository.sSave(replySaveRequestDto.getUsernum(), replySaveRequestDto.getBoardnum(), replySaveRequestDto.getContent());
	}
	
	@Transactional
	public void 댓글삭제(int replynum) {
		replyRepository.deleteById(replynum);
	}	
}


//try {
//
//return 1;
//}catch(Exception e) {
//e.printStackTrace();
//System.out.println("MemberService : 회원가입() :" + e.getMessage());
//}
//return -1;


//전통적인 로그인 방식
//@Transactional(readOnly=true)// Select 할 때 트랜잭션 시작, 서비스 종료시에 트랜잭션 종료 ( 정합성 )
//public Member 로그인(Member member) {
//return memeberRepository.findByUseridAndUserpw(member.getUserid(), member.getUserpw());
//}