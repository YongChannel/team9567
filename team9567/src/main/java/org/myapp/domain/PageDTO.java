package org.myapp.domain;

import lombok.Data;

@Data
public class PageDTO {
	//페이지바 이전, 이후, 시작값, 끝값
	private boolean prev, next;
	private int startPage, endPage;
	
	//전체개수
	private Long total;
	//몇개씩 보여줄지, 현재 페이지
	private Criteria cri;
	
	public PageDTO(Criteria cri, Long total) {
		this.cri=cri;
		this.total=total;
		
		//endPage: (현재페이지/10)올림 * 10
		endPage = (int) Math.ceil(cri.getPageNum() / 10.0) * 10;
		startPage = endPage-9;
		
		//첫번째 페이지바가 아니라면 시작값이 1이 아님
		prev = startPage > 1;
		
		//진짜 마지막 페이지바 번호 = 올림(전체게시글수/한페이지보여줄개수)
		int realEnd = (int) Math.ceil(total*1.0 / cri.getAmount());
		
		if(endPage > realEnd) {
			endPage = realEnd;
		}
		next = endPage < realEnd;
	}
	
}
