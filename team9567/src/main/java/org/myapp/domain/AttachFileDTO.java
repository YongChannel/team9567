package org.myapp.domain;

import lombok.Data;

@Data
public class AttachFileDTO {
	private String fileName; //파일명
	private String uploadPath; //파일경로
	private String uuid; //파일코드
	
	private Long Drw_No; //도면번호
	private String partCode; //품목코드
	private String Library; //품목구분대
	private String Librarym; //품목구분중
}
