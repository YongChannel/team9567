package org.myapp.mapper;

import java.util.List;

import org.myapp.domain.Criteria;
import org.myapp.domain.SupportVO;

public interface SupportMapper {
	//���� ��ȹ ����
	public List<SupportVO> getSupport();
	
	//���� ��ȹ ������ó��
	public List<SupportVO> getSupportWithPaging(Criteria cri);
	
	//���� ��ȹ ���
	public void insertSelectKey(SupportVO vo);
	
	//���� ��ȹ ����
	public Long count(Criteria cri);
	
	//���� ��ȹ ����
	public void delete(Long supportNo);
	
	//���� ��ȹ ������ȸ
	public SupportVO read(Long supportNo);
	
	//���� ��ȹ ����
	public int update(SupportVO vo);
}
