package org.myapp.mapper;

import java.util.List;

import org.myapp.domain.PartVO;
import org.myapp.domain.Criteria;

public interface PartMapper {	
	//품목 정보 페이지처리
	public List<PartVO> getPartWithPaging(Criteria cri);
	
	//품목 정보 등록
	public void insertSelectKey(PartVO vo);
	
	//품목 정보 개수
	public Long count(Criteria cri);
	
	//품목 정보 삭제
	public void delete(String partCode);
	
	//품목 정보 개별조회
	public PartVO read(String partCode);
	
	//품목 정보 수정
	public int update(PartVO vo);
	
	//품목 정보 개별조회
	public PartVO getRead(String partName);
}
