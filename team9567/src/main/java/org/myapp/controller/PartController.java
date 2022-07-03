package org.myapp.controller;

import javax.servlet.http.HttpServletRequest;

import org.myapp.domain.Criteria;
import org.myapp.domain.PageDTO;
import org.myapp.domain.PartVO;
import org.myapp.service.PartService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import lombok.AllArgsConstructor;
import lombok.extern.log4j.Log4j;

@Controller
@RequestMapping("/part/*")
@Log4j
@AllArgsConstructor
public class PartController {
	private PartService partService;
	
	//前格焊扁
	@GetMapping("/partList")
	public void partList(Model model, Criteria cri) {
		model.addAttribute("list", partService.getPart(cri));
		model.addAttribute("pageMaker", new PageDTO(cri, partService.count(cri)));
	}
	
	//前格俺荐
	@GetMapping("/count")
	public void count(Criteria cri, Model model) {
		model.addAttribute("count", partService.count(cri));
	}
	
	//前格殿废
	@PostMapping("/register")
	public String register(PartVO vo, RedirectAttributes rttr) {
		partService.register(vo);
		return "redirect:/part/partList";
	}
	
	//前格昏力
	@PostMapping("/remove")
	public String remove(HttpServletRequest request, Criteria cri) {
		String[] ajaxMsg = request.getParameterValues("valueArr");
		int size = ajaxMsg.length;
		for(int i = 0; i < size; i++) {
			partService.remove(Long.parseLong(ajaxMsg[i]));
		}
		return "redirect:/part/partList?pageNum="+cri.getPageNum()+"&amount="+cri.getAmount()+"&type="+cri.getType()+"&keyword="+cri.getKeyword();
	}
	
	//前格俺喊焊扁
	@GetMapping("/getList")
	public void getList(Long partCode, Criteria cri, Model model) {
		model.addAttribute("get", partService.get(partCode));
		model.addAttribute("list", partService.getPart(cri));
		model.addAttribute("pageMaker", new PageDTO(cri, partService.count(cri)));
	}
	
	//前格荐沥
	@PostMapping("/modify")
	public String modify(PartVO vo, Criteria cri, RedirectAttributes rttr) {
		if(partService.modify(vo)) {
			rttr.addFlashAttribute("state", "modify");
		}
		return "redirect:/part/partList?pageNum="+cri.getPageNum()+"&amount="+cri.getAmount()+"&type="+cri.getType()+"&keyword="+cri.getKeyword();
	}
}
