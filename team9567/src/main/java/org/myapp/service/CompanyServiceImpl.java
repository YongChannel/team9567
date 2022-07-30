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
	
	//ȸ�� ���� ����
	@Override
	public List<CompanyVO> getCompany(Criteria cri) { 
		return companyMapper.getCompanyWithPaging(cri);
	}
	
	//ȸ�� ���� ����
	@Override
	public Long count(Criteria cri) {
		return companyMapper.count(cri);
	}
	
	//ȸ�� ���� ���
	@Override
	public void register(CompanyVO vo) {
		companyMapper.insertSelectKey(vo);
	}
	
	//ȸ�� ���� ����
	@Override
	public void remove(Long code) {
		companyMapper.delete(code);
	}
	
	//ȸ�� ���� ��������
	@Override
	public CompanyVO get(Long code) {
		return companyMapper.read(code);
	}
	
	//ȸ�� ���� ����
	@Override
	public boolean modify(CompanyVO vo) {
		return (companyMapper.update(vo) == 1);
	}
	
	//ȸ�� ���� ��������
	@Override
	public CompanyVO getRead(String name) {
		return companyMapper.getRead(name);
	}
}
