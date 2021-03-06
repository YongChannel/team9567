package org.myapp.controller;

import javax.servlet.http.HttpServletRequest;

import org.myapp.domain.ContractVO;
import org.myapp.domain.Criteria;
import org.myapp.domain.PageDTO;
import org.myapp.service.CompanyService;
import org.myapp.service.ContractService;
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
@RequestMapping("/contract/*")
@Log4j
@AllArgsConstructor
public class ContractController {
	private ContractService contractService;
	private CompanyService companyService;
	private PartService partService;
	
	//계약 정보 보기
	@GetMapping("/contractList")
	public void contractList(Model model, Criteria cri) {
		model.addAttribute("list", contractService.getContract(cri));
		model.addAttribute("pageMaker", new PageDTO(cri, contractService.count(cri)));
	}
	
	//계약 정보 개수
	@GetMapping("/count")
	public void count(Criteria cri, Model model) {
		model.addAttribute("count", contractService.count(cri));
	}
	
	//계약 정보 등록
	@PostMapping("/register")
	public String register(ContractVO vo, RedirectAttributes rttr) {
		contractService.register(vo);
		return "redirect:/contract/contractList";
	}
	
	//계약 정보 삭제
	@PostMapping("/remove")
	public String remove(HttpServletRequest request, Criteria cri) {
		String[] ajaxMsg = request.getParameterValues("valueArr");
		
		int size = ajaxMsg.length;
		for(int i = 0; i < size; i++) {
			contractService.remove(Long.parseLong(ajaxMsg[i]));
		}
		
		return "redirect:/contract/contractList?pageNum="+cri.getPageNum()+"&amount="+cri.getAmount()+"&type="+cri.getType()+"&keyword="+cri.getKeyword();
	}
	
	//계약 정보 개별보기
	@GetMapping("/getList")
	public void getList(Long contractNo, Long code, Criteria cri, Model model) {
		 model.addAttribute("getReg", companyService.get(0L));
		 model.addAttribute("getCom", companyService.get(code));
		 model.addAttribute("get", contractService.get(contractNo));
		 model.addAttribute("pageMaker", new PageDTO(cri, contractService.count(cri)));
	}
	 
	//계약 정보 수정
	@PostMapping("/modify")
	public String modify(ContractVO vo, Criteria cri, RedirectAttributes rttr) {
		if(contractService.modify(vo)) {
			rttr.addFlashAttribute("state", "modify");
		}
		
		return "redirect:/contract/contractList?pageNum="+cri.getPageNum()+"&amount="+cri.getAmount()+"&type="+cri.getType()+"&keyword="+cri.getKeyword();
	}
	
	//계약 정보 개별보기
	@GetMapping("/getRegister")
	public void getRegister(String ckeyword, String pkeyword, Model model, Criteria cri) {
		model.addAttribute("getReg", companyService.get(0L));
		model.addAttribute("getCom", companyService.getRead(ckeyword));
		model.addAttribute("getPat", partService.getRead(pkeyword));
		model.addAttribute("pageMaker", new PageDTO(cri, companyService.count(cri)));
	}

}
