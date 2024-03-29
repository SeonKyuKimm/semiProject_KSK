package edu.kh.surf.member.model.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@ToString
public class Member {

	private String memberId;
	private String memberPw;
	private String memberNickname;
	private String enrollDate;
	private String memberDelFl;
	private int memberGrade;
	private int memberNo;
}
