package org.myapp.mapper;

import java.util.List;

import org.myapp.domain.AttachFileDTO;

public interface AttachMapper {
	//첨부파일 등록
	public void insert(AttachFileDTO vo);
	
	//첨부파일 수정
	public void update(String partCode);
	
	//첨부파일 조회
	public List<AttachFileDTO> findByPartCode(String partCode);
}
