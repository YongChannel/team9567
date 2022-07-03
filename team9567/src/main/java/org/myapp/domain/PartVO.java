package org.myapp.domain;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class PartVO {
	private Long PartCode; //ǰ���ڵ�
	private String PartName; //ǰ���
	private String NickName; //��Ī
	private String Library; //ǰ�񱸺�
	private String Remark; //��ǰ����
	private Long Common; //���뿩��
	private Long Drw_No; //�����ȣ
	private String Drw_Img; //���� �̹���
}
