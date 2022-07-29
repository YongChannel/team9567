package org.myapp.mapper;

import java.util.List;

import org.myapp.domain.PartVO;
import org.myapp.domain.Criteria;

public interface PartMapper {	
	//ǰ�� ���� ������ó��
	public List<PartVO> getPartWithPaging(Criteria cri);
	
	//ǰ�� ���� ���
	public void insertSelectKey(PartVO vo);
	
	//ǰ�� ���� ����
	public Long count(Criteria cri);
	
	//ǰ�� ���� ����
	public void delete(String partCode);
	
	//ǰ�� ���� ������ȸ
	public PartVO read(String partCode);
	
	//ǰ�� ���� ����
	public int update(PartVO vo);
	
	//ǰ�� ���� ������ȸ
	public PartVO getRead(String partName);
}
