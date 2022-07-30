package org.myapp.mapper;

import java.util.List;

import org.myapp.domain.ContractVO;
import org.myapp.domain.Criteria;

public interface ContractMapper {
	//계약 정보 페이지처리
	public List<ContractVO> getContractWithPaging(Criteria cri);
	
	//계약 정보 등록
	public void insertSelectKey(ContractVO vo);
	
	//계약 정보 개수
	public Long count(Criteria cri);
	
	//계약 정보 삭제
	public void delete(Long contractNo);
	
	//계약 정보 개별보기
	public ContractVO read(Long contractNo);
	
	//계약 정보 수정
	public int update(ContractVO vo);
}
