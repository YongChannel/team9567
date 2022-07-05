package org.myapp.mapper;

import java.util.List;

import org.myapp.domain.Criteria;
import org.myapp.domain.SupportVO;

public interface SupportMapper {
	//조달 계획 보기
	public List<SupportVO> getSupport();
	
	//조달 계획 페이지처리
	public List<SupportVO> getSupportWithPaging(Criteria cri);
	
	//조달 계획 등록
	public void insertSelectKey(SupportVO vo);
	
	//조달 계획 개수
	public Long count(Criteria cri);
	
	//조달 계획 삭제
	public void delete(Long supportNo);
	
	//조달 계획 개별조회
	public SupportVO read(Long supportNo);
	
	//조달 계획 수정
	public int update(SupportVO vo);
}
