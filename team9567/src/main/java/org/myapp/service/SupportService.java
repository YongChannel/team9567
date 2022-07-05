package org.myapp.service;

import java.util.List;

import org.myapp.domain.Criteria;
import org.myapp.domain.SupportVO;

public interface SupportService {
	//조달 계획 보기
	public List<SupportVO> getSupport(Criteria cri);
	
	//조달 계획 개수
	public Long count(Criteria cri);
	
	//조달 계획 등록
	public void register(SupportVO vo);
	
	//조달 계획 삭제
	public void remove(Long supportNo);
	
	//조달 계획 개별보기
	public SupportVO get(Long supportNo);
	
	//조달 계획 수정
	public boolean modify(SupportVO vo);
}
