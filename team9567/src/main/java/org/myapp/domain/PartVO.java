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
	private String PartCode; //ǰ���ڵ�
	private String PartName; //ǰ���
	private String NickName; //��Ī
	private String Library; //ǰ�񱸺д�
	private String Librarym; //ǰ�񱸺���
	private String Remark; //��ǰ����
	private Long Common; //���뿩��
	private Long Drw_No; //�����ȣ
	private Date PartDate; //�����
	
	private String fileName; //���ϸ�
	private String uuid; //�����ڵ�
	private String uploadPath; //���ϰ��
	private List<AttachFileDTO> attachList; //÷������
	
}
