package org.myapp.service;

import java.util.List;

import org.myapp.domain.Criteria;
import org.myapp.domain.SupportVO;
import org.myapp.mapper.SupportMapper;
import org.springframework.stereotype.Service;

import lombok.AllArgsConstructor;

@Service
@AllArgsConstructor
public class SupportServiceImpl implements SupportService {
	private SupportMapper supportMapper;
	
	//조달 계획 보기
	@Override
	public List<SupportVO> getSupport(Criteria cri) { 
		return supportMapper.getSupportWithPaging(cri);
	}
	
	//조달 계획 개수
	@Override
	public Long count(Criteria cri) {
		return supportMapper.count(cri);
	}
	
	//조달 계획 등록
	@Override
	public void register(SupportVO vo) {
		supportMapper.insertSelectKey(vo);
	}
	
	//조달 계획 삭제
	@Override
	public void remove(Long supportNo) {
		supportMapper.delete(supportNo);
	}
	
	//조달 계획 개별보기
	@Override
	public SupportVO get(Long supportNo) {
		return supportMapper.read(supportNo);
	}
	
	//조달 계획 수정
	@Override
	public boolean modify(SupportVO vo) {
		return (supportMapper.update(vo) == 1);
	}
}
