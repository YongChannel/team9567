package org.myapp.domain;

import java.util.Date;

import org.springframework.format.annotation.DateTimeFormat;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class CompanyVO {
	private Long Code; //업체코드
	private String Name; //업체명
	private String Business_Number; //사업자번호
	private String Taxcode; //세무코드
	private String Owner; //대표자
	private String Contact; //연락처
	private String Address; //주소
	private String Account; //계좌정보
	private String Company_Size; //업체규모
	private String Category; //업태분류
	private Long Sales; //매출액
	private String Deal_Type; //거래형태
	private String Domestic_Foreign; //내외자
	private String Currency; //결제통화
	@DateTimeFormat(pattern="yyyy-MM-dd")
	private Date Start_Date; //거래개시일
	@DateTimeFormat(pattern="yyyy-MM-dd")
	private Date End_Date; //거래종료일
	private String Invoice_Issue; //계산서발행
	private String Comemployee; //담당자
	private String Comemail; //이메일
	private Date CompanyDate; //등록일
}
