package org.myapp.service;

import java.util.List;

import org.myapp.domain.AttachFileDTO;
import org.myapp.domain.Criteria;
import org.myapp.domain.PartVO;

public interface PartService {
	//품목 정보 보기
	public List<PartVO> getPart(Criteria cri);
	
	//품목 정보 개수
	public Long count(Criteria cri);
	
	//품목 정보 등록
	public void register(PartVO vo);
	
	//품목 정보 삭제
	public void remove(String partCode);
	
	//품목 정보 개별보기
	public PartVO get(String partCode);
	
	//품목 정보 수정
	public boolean modify(PartVO vo);
	
	//첨부파일 조회
	public List<AttachFileDTO> getFile(String partCode);
	
	//품목 정보 개별보기
	public PartVO getRead(String partName);
	
	//첨부파일 수정
	public void getModify(String partCode);
}
