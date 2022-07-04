package org.myapp.domain;

import java.sql.Date;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class SupportVO {
	private Long SupportNo; //�����ڵ�
	private Long PartCode; //ǰ���ڵ�
	private String MaterialProcess; //����ҿ����
	private Date DaySchedule; //�ҿ�����
	private Long Requirement; //�ҿ䷮
	private Date DeliveryDate; //���޳���
}
