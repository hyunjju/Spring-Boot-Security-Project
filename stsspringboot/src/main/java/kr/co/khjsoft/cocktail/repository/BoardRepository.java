package kr.co.khjsoft.cocktail.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
//import org.springframework.data.jpa.repository.Query;

import kr.co.khjsoft.cocktail.board.Board;
import kr.co.khjsoft.cocktail.member.Member;

public interface BoardRepository extends JpaRepository<Board, Integer>{
	
	
}
