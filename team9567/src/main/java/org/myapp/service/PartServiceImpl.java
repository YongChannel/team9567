package org.myapp.service;

import java.util.List;

import org.myapp.domain.Criteria;
import org.myapp.domain.PartVO;
import org.myapp.mapper.PartMapper;
import org.springframework.stereotype.Service;

import lombok.AllArgsConstructor;

@Service
@AllArgsConstructor
public class PartServiceImpl implements PartService {
	private PartMapper partMapper;
	
	//前格焊扁
	@Override
	public List<PartVO> getPart(Criteria cri) { 
		return partMapper.getPartWithPaging(cri);
	}
	
	//前格俺荐
	@Override
	public Long count(Criteria cri) {
		return partMapper.count(cri);
	}
	
	//前格殿废
	@Override
	public void register(PartVO vo) {
		partMapper.insertSelectKey(vo);
	}
	
	//前格昏力
	@Override
	public void remove(Long partCode) {
		partMapper.delete(partCode);
	}
	
	//前格俺喊焊扁
	@Override
	public PartVO get(Long partCode) {
		return partMapper.read(partCode);
	}
	
	//前格荐沥
	@Override
	public boolean modify(PartVO vo) {
		return (partMapper.update(vo) == 1);
	}
}
