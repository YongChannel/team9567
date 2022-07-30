package org.myapp.domain;

import java.sql.Date;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ContractVO {
	private Long ContractNo; //����ڵ�
	private String PartsSupply; //��ǰ���� L/T
	private String TransferConditions; //�絵/�������
	private Long UnitPrice; //�ܰ�
	private Date ContractDate; //��೯¥
	
	private String PartCode; //ǰ���ڵ�
	private String PartName; //ǰ���
	private Long Code; //��ü�ڵ�
	private String Name; //��ü��
}
