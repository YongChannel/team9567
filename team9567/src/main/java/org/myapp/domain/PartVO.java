package org.myapp.domain;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class PartVO {
	private Long PartCode; //품목코드
	private String PartName; //품목명
	private String NickName; //약칭
	private String Library; //품목구분
	private String Remark; //제품설명
	private Long Common; //공용여부
	private Long Drw_No; //도면번호
	private String Drw_Img; //도면 이미지
}
