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
	private Long Code; //��ü�ڵ�
	private String Name; //��ü��
	private String Business_Number; //����ڹ�ȣ
	private String Taxcode; //�����ڵ�
	private String Owner; //��ǥ��
	private String Contact; //����ó
	private String Address; //�ּ�
	private String Account; //��������
	private String Company_Size; //��ü�Ը�
	private String Category; //���ºз�
	private Long Sales; //�����
	private String Deal_Type; //�ŷ�����
	private String Domestic_Foreign; //������
	private String Currency; //������ȭ
	@DateTimeFormat(pattern="yyyy-MM-dd")
	private Date Start_Date; //�ŷ�������
	@DateTimeFormat(pattern="yyyy-MM-dd")
	private Date End_Date; //�ŷ�������
	private String Invoice_Issue; //��꼭����
	private String Comemployee; //�����
	private String Comemail; //�̸���
	private Date CompanyDate; //�����
}
