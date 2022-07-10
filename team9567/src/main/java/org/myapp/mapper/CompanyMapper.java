package org.myapp.mapper;

import java.util.List;

import org.myapp.domain.CompanyVO;
import org.myapp.domain.Criteria;

public interface CompanyMapper {
	//ȸ�� ���� ������ó��
	public List<CompanyVO> getCompanyWithPaging(Criteria cri);
	
	//ȸ�� ���� ���
	public void insertSelectKey(CompanyVO vo);
	
	//ȸ�� ���� ����
	public Long count(Criteria cri);
	
	//ȸ�� ���� ����
	public void delete(Long code);
	
	//ȸ�� ���� ��������
	public CompanyVO read(Long code);
	
	//ȸ�� ���� ����
	public int update(CompanyVO vo);
}
