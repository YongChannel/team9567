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
	
	//품목 정보 보기
	@Override
	public List<PartVO> getPart(Criteria cri) { 
		return partMapper.getPartWithPaging(cri);
	}
	
	//품목 정보 개수
	@Override
	public Long count(Criteria cri) {
		return partMapper.count(cri);
	}
	
	//품목 정보 등록
	@Override
	public void register(PartVO vo) {
		partMapper.insertSelectKey(vo);
	}
	
	//품목 정보 삭제
	@Override
	public void remove(Long partCode) {
		partMapper.delete(partCode);
	}
	
	//품목 정보 개별보기
	@Override
	public PartVO get(Long partCode) {
		return partMapper.read(partCode);
	}
	
	//품목 정보 수정
	@Override
	public boolean modify(PartVO vo) {
		return (partMapper.update(vo) == 1);
	}
}
