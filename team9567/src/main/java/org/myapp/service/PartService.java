package org.myapp.service;

import java.util.List;

import org.myapp.domain.AttachFileDTO;
import org.myapp.domain.Criteria;
import org.myapp.domain.PartVO;

public interface PartService {
	//ǰ�� ���� ����
	public List<PartVO> getPart(Criteria cri);
	
	//ǰ�� ���� ����
	public Long count(Criteria cri);
	
	//ǰ�� ���� ���
	public void register(PartVO vo);
	
	//ǰ�� ���� ����
	public void remove(String partCode);
	
	//ǰ�� ���� ��������
	public PartVO get(String partCode);
	
	//ǰ�� ���� ����
	public boolean modify(PartVO vo);
	
	//÷������ ��ȸ
	public List<AttachFileDTO> getFile(String partCode);
	
	//ǰ�� ���� ��������
	public PartVO getRead(String partName);
	
	//÷������ ����
	public void getModify(String partCode);
}
