package org.myapp.service;

import java.util.List;

import org.myapp.domain.ContractVO;
import org.myapp.domain.Criteria;

public interface ContractService {
	//계약 정보 보기
	public List<ContractVO> getContract(Criteria cri);
	
	//계약 정보 개수
	public Long count(Criteria cri);
	
	//계약 정보 등록
	public void register(ContractVO vo);
	
	//계약 정보 삭제
	public void remove(Long partCode);
	
	//계약 정보 개별보기
	public ContractVO get(Long partCode);
	
	//계약 정보 수정
	public boolean modify(ContractVO vo);
}
