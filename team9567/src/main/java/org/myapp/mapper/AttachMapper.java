package org.myapp.mapper;

import java.util.List;

import org.myapp.domain.AttachFileDTO;

public interface AttachMapper {
	//÷������ ���
	public void insert(AttachFileDTO vo);
	
	//÷������ ����
	public void update(String partCode);
	
	//÷������ ��ȸ
	public List<AttachFileDTO> findByPartCode(String partCode);
}
