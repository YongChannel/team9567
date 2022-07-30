package org.myapp.service;

import java.util.List;

import org.myapp.domain.CompanyVO;
import org.myapp.domain.Criteria;
import org.myapp.mapper.CompanyMapper;
import org.springframework.stereotype.Service;

import lombok.AllArgsConstructor;

@Service
@AllArgsConstructor
public class CompanyServiceImpl implements CompanyService {
	private CompanyMapper companyMapper;
	
	//회사 정보 보기
	@Override
	public List<CompanyVO> getCompany(Criteria cri) { 
		return companyMapper.getCompanyWithPaging(cri);
	}
	
	//회사 정보 개수
	@Override
	public Long count(Criteria cri) {
		return companyMapper.count(cri);
	}
	
	//회사 정보 등록
	@Override
	public void register(CompanyVO vo) {
		companyMapper.insertSelectKey(vo);
	}
	
	//회사 정보 삭제
	@Override
	public void remove(Long code) {
		companyMapper.delete(code);
	}
	
	//회사 정보 개별보기
	@Override
	public CompanyVO get(Long code) {
		return companyMapper.read(code);
	}
	
	//회사 정보 수정
	@Override
	public boolean modify(CompanyVO vo) {
		return (companyMapper.update(vo) == 1);
	}
	
	//회사 정보 개별보기
	@Override
	public CompanyVO getRead(String name) {
		return companyMapper.getRead(name);
	}
}
