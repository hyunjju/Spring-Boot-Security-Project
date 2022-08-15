package kr.co.khjsoft.cocktail.cocktailList;

import java.sql.Timestamp;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.Lob;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.OrderBy;

import org.hibernate.annotations.CreationTimestamp;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import kr.co.khjsoft.cocktail.board.Board;
import kr.co.khjsoft.cocktail.board.Reply;
import kr.co.khjsoft.cocktail.board.Board.BoardBuilder;
import kr.co.khjsoft.cocktail.member.Member;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Entity
public class CocktailList{
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int num;
	
	@Column(nullable=false, length=200)
	private String title;
	
	@Lob //대용량 데이터
	private String content;
	
	@ManyToOne(fetch=FetchType.EAGER) //Many-Board, One-Member
	@JoinColumn(name="userNum")
	private Member member; //DB 는 오브젝트를 저장할 수 없다. FK, 오브젝트를 저장할 수 있다
	

	@OneToMany(mappedBy="board", fetch=FetchType.EAGER,cascade=CascadeType.REMOVE) //mappedBy 연관관계의 주인이 아니다(라 FK가 아니다)DB에 컬럼 안만든
	@JsonIgnoreProperties({"board"})
	@OrderBy("id desc")
	private List<Reply> replys;
	
	  
	@CreationTimestamp
	private Timestamp createDate;
	
}
