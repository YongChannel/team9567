package org.myapp.service;

import java.util.List;

import org.myapp.domain.Criteria;
import org.myapp.domain.SupportVO;
import org.myapp.mapper.SupportMapper;
import org.springframework.stereotype.Service;

import lombok.AllArgsConstructor;

@Service
@AllArgsConstructor
public class SupportServiceImpl implements SupportService {
	private SupportMapper supportMapper;
	
	//���� ��ȹ ����
	@Override
	public List<SupportVO> getSupport(Criteria cri) { 
		return supportMapper.getSupportWithPaging(cri);
	}
	
	//���� ��ȹ ����
	@Override
	public Long count(Criteria cri) {
		return supportMapper.count(cri);
	}
	
	//���� ��ȹ ���
	@Override
	public void register(SupportVO vo) {
		supportMapper.insertSelectKey(vo);
	}
	
	//���� ��ȹ ����
	@Override
	public void remove(Long supportNo) {
		supportMapper.delete(supportNo);
	}
	
	//���� ��ȹ ��������
	@Override
	public SupportVO get(Long supportNo) {
		return supportMapper.read(supportNo);
	}
	
	//���� ��ȹ ����
	@Override
	public boolean modify(SupportVO vo) {
		return (supportMapper.update(vo) == 1);
	}
}
