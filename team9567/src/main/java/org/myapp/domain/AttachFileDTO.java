package org.myapp.domain;

import lombok.Data;

@Data
public class AttachFileDTO {
	private String fileName; //���ϸ�
	private String uploadPath; //���ϰ��
	private String uuid; //�����ڵ�
	
	private Long Drw_No; //�����ȣ
	private String partCode; //ǰ���ڵ�
	private String Library; //ǰ�񱸺д�
	private String Librarym; //ǰ�񱸺���
}
