package kr.co.khjsoft.cocktail.cocktailList;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

//ORM ->Java(다른언어)Object->테이블로 매핑해주는 기
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder //빌더패턴!!
@Entity //Member 클래스가 자동으로 테이블 생성
//@DynamicInsert //insert 시에 null인 필드를 제외시켜준다
public class CocktailDetail {
	
	@Id //PrimaryKey
	@GeneratedValue(strategy = GenerationType.IDENTITY)//프로젝트에서 연결된 DB 의 넘버링 전략을 따름
	//false?,,?
	private int cocktailnum; //auto_increment
	
	@Column(nullable=false, length=100, unique=true)
	private String cocktailname;
	@Column(nullable=false, length=100, unique=true)
	private String cocktailEname;
	@Column(nullable=false, length=20)
	private String alc; // 논알콜은 셀렉트문 작성할 때 where alc=0; 으로 하면 될듯. 
	@Column(nullable=false, length=200)
	private String content;  
	@Column(nullable=false, length=200)
	private String ingredients;
	@Column(nullable=false, length=200)
	private String imgpath;
	@Column(columnDefinition = "integer default 0")
	private int cnt;
//	@JsonIgnoreProperties({"cocktaildetail"})
//	@OneToMany(mappedBy ="cocktaildetail")
//	private List<Likes> likeList;

}
