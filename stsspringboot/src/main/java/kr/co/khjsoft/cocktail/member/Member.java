package kr.co.khjsoft.cocktail.member;

import java.sql.Timestamp;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import org.hibernate.annotations.ColumnDefault;
import org.hibernate.annotations.CreationTimestamp;
//import org.hibernate.annotations.DynamicInsert;

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
public class Member {
	
	@Id //PrimaryKey
	@GeneratedValue(strategy = GenerationType.IDENTITY)//프로젝트에서 연결된 DB 의 넘버링 전략을 따름
	//false?,,?
	private int num; //auto_increment
	
	@Column(nullable=false, length=100, unique=true)
	private String userid;
	@Column(nullable=false, length=256)
	private String userpw;
	@Column(nullable=false, length=100)
	private String username; 
	@Column(nullable=false, length=11)
	private String userphonenum;
	   
	//@ColumnDefault("'visitor'")
	//DB 는 RoleType 이라는게 없다
	@Enumerated(EnumType.STRING)
	private RoleType role; //Enum 을 쓰는게 좋다
	
	private String oauth;
	
	@CreationTimestamp // 시간이 자동으로 입력
	private Timestamp createDate;
	
	

}
