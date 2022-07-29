package org.myapp.domain;

import java.sql.Date;
import java.util.List;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class PartVO {
	private String PartCode; //품목코드
	private String PartName; //품목명
	private String NickName; //약칭
	private String Library; //품목구분대
	private String Librarym; //품목구분중
	private String Remark; //제품설명
	private Long Common; //공용여부
	private Long Drw_No; //도면번호
	private Date PartDate; //등록일
	
	private String fileName; //파일명
	private String uuid; //파일코드
	private String uploadPath; //파일경로
	private List<AttachFileDTO> attachList; //첨부파일
	
}
