package org.myapp.service;

import java.util.List;

import org.myapp.domain.CompanyVO;
import org.myapp.domain.Criteria;

public interface CompanyService {
	//회사 정보 보기
	public List<CompanyVO> getCompany(Criteria cri);
	
	//회사 정보 개수
	public Long count(Criteria cri);
	
	//회사 정보 등록
	public void register(CompanyVO vo);
	
	//회사 정보 삭제
	public void remove(Long code);
	
	//회사 정보 개별보기
	public CompanyVO get(Long code);
	
	//회사 정보 수정
	public boolean modify(CompanyVO vo);
}
