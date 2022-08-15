package kr.co.khjsoft.cocktail.board;

import java.sql.Timestamp;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;

import org.hibernate.annotations.CreationTimestamp;

import kr.co.khjsoft.cocktail.dto.ReplySaveRequestDto;
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
public class Reply {
	@Id 
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int num;
	
	@Column(nullable=false, length=200)
	private String content;
	
	//연관관계가 필요함
	@ManyToOne
	@JoinColumn(name="boardnum")
	private Board board;
	
	@ManyToOne
	@JoinColumn(name="userNum")
	private Member member;
	
	@CreationTimestamp
	private Timestamp createDate;
	
}
