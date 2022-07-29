package org.myapp.controller;

import javax.servlet.http.HttpServletRequest;

import org.myapp.domain.Criteria;
import org.myapp.domain.PageDTO;
import org.myapp.domain.SupportVO;
import org.myapp.service.PartService;
import org.myapp.service.SupportService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import lombok.AllArgsConstructor;
import lombok.extern.log4j.Log4j;

@Controller
@RequestMapping("/support/*")
@Log4j
@AllArgsConstructor
public class SupportController {
	private SupportService supportService;
	private PartService partService;
	
	//조달 계획 보기
	@GetMapping("/supportList")
	public void supportList(String pkeyword, Model model, Criteria cri) {
		model.addAttribute("list", supportService.getSupport(cri));
		model.addAttribute("getReg", partService.getRead(pkeyword));
		model.addAttribute("pageMaker", new PageDTO(cri, supportService.count(cri)));
	}
	
	//조달 계획 개수
	@GetMapping("/count")
	public void count(Criteria cri, Model model) {
		model.addAttribute("count", supportService.count(cri));
	}
	
	//조달 계획 등록
	@PostMapping("/register")
	public String register(SupportVO vo, RedirectAttributes rttr) {
		supportService.register(vo);
		return "redirect:/support/supportList";
	}
	
	//조달 계획 삭제
	@PostMapping("/remove")
	public String remove(HttpServletRequest request, Criteria cri) {
		String[] ajaxMsg = request.getParameterValues("valueArr");
		
		int size = ajaxMsg.length;
		for(int i = 0; i < size; i++) {
			supportService.remove(Long.parseLong(ajaxMsg[i]));
		}
		
		return "redirect:/support/supportList?pageNum="+cri.getPageNum()+"&amount="+cri.getAmount()+"&type="+cri.getType()+"&keyword="+cri.getKeyword();
	}
	
	//조달 계획 개별보기
	@GetMapping("/getList")
	public void getList(Long supportNo, Criteria cri, Model model) {
		model.addAttribute("get", supportService.get(supportNo));
		model.addAttribute("list", supportService.getSupport(cri));
		model.addAttribute("pageMaker", new PageDTO(cri, supportService.count(cri)));
	}
	
	//조달 계획 수정
	@PostMapping("/modify")
	public String modify(SupportVO vo, Criteria cri, RedirectAttributes rttr) {
		if(supportService.modify(vo)) {
			rttr.addFlashAttribute("state", "modify");
		}
		
		return "redirect:/support/supportList?pageNum="+cri.getPageNum()+"&amount="+cri.getAmount()+"&type="+cri.getType()+"&keyword="+cri.getKeyword();
	}
}
