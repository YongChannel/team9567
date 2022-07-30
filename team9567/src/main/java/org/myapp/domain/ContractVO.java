package org.myapp.domain;

import java.sql.Date;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ContractVO {
	private Long ContractNo; //계약코드
	private String PartsSupply; //부품공급 L/T
	private String TransferConditions; //양도/양수조건
	private Long UnitPrice; //단가
	private Date ContractDate; //계약날짜
	
	private String PartCode; //품목코드
	private String PartName; //품목명
	private Long Code; //업체코드
	private String Name; //업체명
}
