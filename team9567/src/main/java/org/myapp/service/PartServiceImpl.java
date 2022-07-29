package org.myapp.service;

import java.util.List;

import org.myapp.domain.AttachFileDTO;
import org.myapp.domain.Criteria;
import org.myapp.domain.PartVO;
import org.myapp.mapper.AttachMapper;
import org.myapp.mapper.PartMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import lombok.AllArgsConstructor;
import lombok.Setter;

@Service
@AllArgsConstructor
public class PartServiceImpl implements PartService {
	@Setter(onMethod_= @Autowired)
	private PartMapper partMapper;
	
	@Setter(onMethod_= @Autowired)
	private AttachMapper attachMapper;
	
	//품목 정보 보기
	@Override
	public List<PartVO> getPart(Criteria cri) { 
		return partMapper.getPartWithPaging(cri);
	}
	
	//품목 정보 개수
	@Override
	public Long count(Criteria cri) {
		return partMapper.count(cri);
	}
	
	//품목 정보 등록
	@Transactional
	@Override
	public void register(PartVO vo) {
		partMapper.insertSelectKey(vo);
		
		if (vo.getAttachList() == null || vo.getAttachList().size() <= 0) {
			return;
		}
		
		vo.getAttachList().forEach(attach -> {
			attach.setPartCode(vo.getPartCode());
			attachMapper.insert(attach);
		});
		
	}
	
	//품목 정보 삭제
	@Override
	public void remove(String partCode) {
		partMapper.delete(partCode);
	}
	
	//품목 정보 개별보기
	@Override
	public PartVO get(String partCode) {
		return partMapper.read(partCode);
	}
	
	//품목 정보 수정
	@Override
	public boolean modify(PartVO vo) {
		return (partMapper.update(vo) == 1);
	}
	
	//첨부파일 조회
	@Override
	public List<AttachFileDTO> getFile(String partCode) {
		return attachMapper.findByPartCode(partCode);
	}
	
	//품목 정보 개별보기
	@Override
	public PartVO getRead(String partName) {
		return partMapper.getRead(partName);
	}
	
	//첨부파일 수정
	@Override
	public void getModify(String partCode) {
		attachMapper.update(partCode);
	}
	
}
