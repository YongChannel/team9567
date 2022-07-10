package org.myapp.service;

import java.util.List;

import org.myapp.domain.CompanyVO;
import org.myapp.domain.Criteria;

public interface CompanyService {
	//ȸ�� ���� ����
	public List<CompanyVO> getCompany(Criteria cri);
	
	//ȸ�� ���� ����
	public Long count(Criteria cri);
	
	//ȸ�� ���� ���
	public void register(CompanyVO vo);
	
	//ȸ�� ���� ����
	public void remove(Long code);
	
	//ȸ�� ���� ��������
	public CompanyVO get(Long code);
	
	//ȸ�� ���� ����
	public boolean modify(CompanyVO vo);
}
