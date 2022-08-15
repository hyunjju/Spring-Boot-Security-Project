package kr.co.khjsoft.cocktail.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import kr.co.khjsoft.cocktail.board.Reply;
import kr.co.khjsoft.cocktail.dto.ReplySaveRequestDto;

public interface ReplyRepository extends JpaRepository<Reply,Integer> {
	@Query(value="INSERT INTO reply(usernum,boardnum,content,createDate) VALUES(?1,?2,?3,now())",nativeQuery = true)
	void sSave(int usernum,int boardnum,String content);
}
