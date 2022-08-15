package kr.co.khjsoft.cocktail.cocktailList;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;


import kr.co.khjsoft.cocktail.member.Member;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;


@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity

public class Likes {
		@Id 
		@GeneratedValue(strategy = GenerationType.IDENTITY)
	    private int likenum;
		
		@JoinColumn(name = "cocktaildetailnum")
		@ManyToOne(fetch = FetchType.LAZY)
	    private CocktailDetail cocktailDetail;
		
		@JoinColumn(name = "membernum")
		@ManyToOne(fetch = FetchType.LAZY)
		private Member member;
	
		@Column(columnDefinition = "integer default 0")
		private int likecheck;

		@Builder
	    public Likes(CocktailDetail cocktailDetail, Member member) {
	        this.cocktailDetail = cocktailDetail;
	        this.member = member;
	    }

}
