package org.myapp.mapper;

import java.util.List;

import org.myapp.domain.PartVO;
import org.myapp.domain.Criteria;

public interface PartMapper {
	//前格焊扁
	public List<PartVO> getPart();
	
	//前格其捞瘤贸府
	public List<PartVO> getPartWithPaging(Criteria cri);
	
	//前格殿废
	public void insertSelectKey(PartVO vo);
	
	//前格俺荐
	public Long count(Criteria cri);
	
	//前格昏力
	public void delete(Long partCode);
	
	//前格俺喊炼雀
	public PartVO read(Long partCode);
	
	//前格荐沥
	public int update(PartVO vo);
}
