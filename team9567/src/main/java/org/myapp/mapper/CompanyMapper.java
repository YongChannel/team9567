package org.myapp.mapper;

import java.util.List;

import org.myapp.domain.CompanyVO;
import org.myapp.domain.Criteria;

public interface CompanyMapper {
	//회사 정보 페이지처리
	public List<CompanyVO> getCompanyWithPaging(Criteria cri);
	
	//회사 정보 등록
	public void insertSelectKey(CompanyVO vo);
	
	//회사 정보 개수
	public Long count(Criteria cri);
	
	//회사 정보 삭제
	public void delete(Long code);
	
	//회사 정보 개별보기
	public CompanyVO read(Long code);
	
	//회사 정보 수정
	public int update(CompanyVO vo);
}
