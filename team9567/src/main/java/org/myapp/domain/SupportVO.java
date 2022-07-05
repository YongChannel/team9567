package org.myapp.domain;

import java.sql.Date;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class SupportVO {
	private Long SupportNo; //조달코드
	private Long PartCode; //품목코드
	private String MaterialProcess; //자재소요공정
	private Date DaySchedule; //소요일정
	private Long Requirement; //소요량
	private Date DeliveryDate; //조달납기
}
