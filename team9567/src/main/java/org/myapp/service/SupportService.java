package org.myapp.service;

import java.util.List;

import org.myapp.domain.Criteria;
import org.myapp.domain.SupportVO;

public interface SupportService {
	//���� ��ȹ ����
	public List<SupportVO> getSupport(Criteria cri);
	
	//���� ��ȹ ����
	public Long count(Criteria cri);
	
	//���� ��ȹ ���
	public void register(SupportVO vo);
	
	//���� ��ȹ ����
	public void remove(Long supportNo);
	
	//���� ��ȹ ��������
	public SupportVO get(Long supportNo);
	
	//���� ��ȹ ����
	public boolean modify(SupportVO vo);
}
