package org.myapp.service;

import java.util.List;

import org.myapp.domain.Criteria;
import org.myapp.domain.PartVO;

public interface PartService {
	//前格焊扁
	public List<PartVO> getPart(Criteria cri);
	
	//前格俺荐
	public Long count(Criteria cri);
	
	//前格殿废
	public void register(PartVO vo);
	
	//前格昏力
	public void remove(Long partCode);
	
	//前格俺喊焊扁
	public PartVO get(Long partCode);
	
	//前格荐沥
	public boolean modify(PartVO vo);
}
