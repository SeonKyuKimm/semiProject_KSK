package edu.kh.surf.practice.model.dto;

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
public class Practice {

	private int practiceNo;
	private String practiceTitle;
	private String practiceMemo;
	private String practiceDate;
	private String practiceComplete;
	private int memberNo;
	
}
