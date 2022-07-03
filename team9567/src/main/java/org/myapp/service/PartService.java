package org.myapp.service;

import java.util.List;

import org.myapp.domain.Criteria;
import org.myapp.domain.PartVO;

public interface PartService {
	//ǰ�񺸱�
	public List<PartVO> getPart(Criteria cri);
	
	//ǰ�񰳼�
	public Long count(Criteria cri);
	
	//ǰ����
	public void register(PartVO vo);
	
	//ǰ�����
	public void remove(Long partCode);
	
	//ǰ�񰳺�����
	public PartVO get(Long partCode);
	
	//ǰ�����
	public boolean modify(PartVO vo);
}
