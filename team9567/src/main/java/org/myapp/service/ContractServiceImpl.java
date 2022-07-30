package org.myapp.service;

import java.util.List;

import org.myapp.domain.ContractVO;
import org.myapp.domain.Criteria;
import org.myapp.mapper.ContractMapper;
import org.springframework.stereotype.Service;

import lombok.AllArgsConstructor;

@Service
@AllArgsConstructor
public class ContractServiceImpl implements ContractService {
	private ContractMapper contractMapper;
	
	//계약 정보 보기
	@Override
	public List<ContractVO> getContract(Criteria cri) { 
		return contractMapper.getContractWithPaging(cri);
	}
	
	//계약 정보 개수
	@Override
	public Long count(Criteria cri) {
		return contractMapper.count(cri);
	}
	
	//계약 정보 등록
	@Override
	public void register(ContractVO vo) {
		contractMapper.insertSelectKey(vo);
	}
	
	//계약 정보 삭제
	@Override
	public void remove(Long contractNo) {
		contractMapper.delete(contractNo);
	}
	
	//계약 정보 개별보기
	@Override
	public ContractVO get(Long contractNo) {
		return contractMapper.read(contractNo);
	}
	
	//계약 정보 수정
	@Override
	public boolean modify(ContractVO vo) {
		return (contractMapper.update(vo) == 1);
	}
}
