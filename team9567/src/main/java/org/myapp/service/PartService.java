package org.myapp.service;

import java.util.List;

import org.myapp.domain.Criteria;
import org.myapp.domain.PartVO;

public interface PartService {
	//품목 정보 보기
	public List<PartVO> getPart(Criteria cri);
	
	//품목 정보 개수
	public Long count(Criteria cri);
	
	//품목 정보 등록
	public void register(PartVO vo);
	
	//품목 정보 삭제
	public void remove(Long partCode);
	
	//품목 정보 개별보기
	public PartVO get(Long partCode);
	
	//품목 정보 수정
	public boolean modify(PartVO vo);
}
