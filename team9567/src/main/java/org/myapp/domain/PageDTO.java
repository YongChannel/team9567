package org.myapp.domain;

import lombok.Data;

@Data
public class PageDTO {
	//�������� ����, ����, ���۰�, ����
	private boolean prev, next;
	private int startPage, endPage;
	
	//��ü����
	private Long total;
	//��� ��������, ���� ������
	private Criteria cri;
	
	public PageDTO(Criteria cri, Long total) {
		this.cri=cri;
		this.total=total;
		
		//endPage: (����������/10)�ø� * 10
		endPage = (int) Math.ceil(cri.getPageNum() / 10.0) * 10;
		startPage = endPage-9;
		
		//ù��° �������ٰ� �ƴ϶�� ���۰��� 1�� �ƴ�
		prev = startPage > 1;
		
		//��¥ ������ �������� ��ȣ = �ø�(��ü�Խñۼ�/�������������ٰ���)
		int realEnd = (int) Math.ceil(total*1.0 / cri.getAmount());
		
		if(endPage > realEnd) {
			endPage = realEnd;
		}
		next = endPage < realEnd;
	}
	
}
