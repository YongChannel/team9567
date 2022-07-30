package org.myapp.mapper;

import java.util.List;

import org.myapp.domain.ContractVO;
import org.myapp.domain.Criteria;

public interface ContractMapper {
	//��� ���� ������ó��
	public List<ContractVO> getContractWithPaging(Criteria cri);
	
	//��� ���� ���
	public void insertSelectKey(ContractVO vo);
	
	//��� ���� ����
	public Long count(Criteria cri);
	
	//��� ���� ����
	public void delete(Long contractNo);
	
	//��� ���� ��������
	public ContractVO read(Long contractNo);
	
	//��� ���� ����
	public int update(ContractVO vo);
}
