package org.myapp.domain;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class Criteria {
	//������ ��ȣ, �� �������� ����
	private int pageNum=1;
	private int amount=10;
	
	//�⺻ ������ -> �⺻�� 1,10
	public Criteria() {
		
	}
	
	//�˻��� ���õ� �����߰�(�˻����� type, �˻��� keyword)
	private String type;
	private String keyword;
	
	//���� �˻� ������ ���ڿ��� �и��ؼ� ���ڿ� �迭�� �����
	public String[] getTypeArr() {
		return type==null? new String[] {} : type.split("");
	}
}
