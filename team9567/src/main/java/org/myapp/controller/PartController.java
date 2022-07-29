package org.myapp.controller;

import java.io.File;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.UUID;

import javax.servlet.http.HttpServletRequest;

import org.myapp.domain.AttachFileDTO;
import org.myapp.domain.Criteria;
import org.myapp.domain.PageDTO;
import org.myapp.domain.PartVO;
import org.myapp.service.PartService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import lombok.AllArgsConstructor;
import lombok.extern.log4j.Log4j;

@Controller
@RequestMapping("/part/*")
@Log4j
@AllArgsConstructor
public class PartController {
	private PartService partService;
	
	//품목 정보 보기
	@GetMapping("/partList")
	public void partList(String partCode, Model model, Criteria cri) {
		model.addAttribute("list", partService.getPart(cri));
		model.addAttribute("pageMaker", new PageDTO(cri, partService.count(cri)));
	}
	
	//품목 정보 개수
	@GetMapping("/count")
	public void count(Criteria cri, Model model) {
		model.addAttribute("count", partService.count(cri));
	}
	
	//첨부파일 폴더 생성
	private String getFolder() {
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
		Date date = new Date();
		String str = sdf.format(date);
		return str.replace("-", File.separator);
	}
	
	//품목 정보 등록
	@PostMapping("/register")
	public String register(MultipartFile[] Drw_Img, PartVO vo, RedirectAttributes rttr) {
		String RegCode = vo.getLibrary() + vo.getLibrarym();
		vo.setPartCode(RegCode);
		
		List<AttachFileDTO> list = new ArrayList<>();
		String uploadFolder = "C:\\upload";
		
		String uploadFolderPath = getFolder();
		File uploadPath = new File(uploadFolder, uploadFolderPath);
		
		if(uploadPath.exists() == false) {
			uploadPath.mkdirs();
		}
		
		for(MultipartFile multipartFile: Drw_Img) {
			AttachFileDTO attachDTO = new AttachFileDTO();
			
			String uploadFileName = multipartFile.getOriginalFilename();
			
			if(!uploadFileName.equals("")) {
				uploadFileName = uploadFileName.substring(uploadFileName.lastIndexOf("\\") + 1);
				
				attachDTO.setFileName(uploadFileName);
				
				UUID uuid = UUID.randomUUID();
				uploadFileName = uuid.toString() + "_" + uploadFileName;
				
				try {
					File saveFile = new File(uploadPath, uploadFileName);
					multipartFile.transferTo(saveFile);
					
					attachDTO.setUuid(uuid.toString());
					attachDTO.setUploadPath(uploadFolderPath);
					attachDTO.setPartCode(vo.getPartCode());
					
				} catch(Exception e) {
					e.printStackTrace();
				}
				
				list.add(attachDTO);
			}
			
		}
		vo.setAttachList(list);
		
		partService.register(vo);
		return "redirect:/part/partList";
	}
	
	//품목 정보 삭제
	@PostMapping("/remove")
	public String remove(HttpServletRequest request, Criteria cri) {
		String[] ajaxMsg = request.getParameterValues("valueArr");
		
		int size = ajaxMsg.length;
		for(int i = 0; i < size; i++) {
			List<AttachFileDTO> list = partService.getFile(ajaxMsg[i]);
			
			for(AttachFileDTO dto :list) {
				String deleteFile;
				deleteFile="C:\\upload\\"+dto.getUploadPath()+"\\"+dto.getUuid()+"_"+dto.getFileName();
				
				File file = new File(deleteFile);
				
				if(file.delete()) {
					log.error("파일삭제 성공");
				} else {
					log.error("파일삭제 실패");
				}
				
			}
			
			partService.remove(ajaxMsg[i]);
		}
		
		return "redirect:/part/partList?pageNum="+cri.getPageNum()+"&amount="+cri.getAmount()+"&type="+cri.getType()+"&keyword="+cri.getKeyword();
	}
	
	//품목 정보 개별보기
	@GetMapping("/getList")
	public void getList(String partCode, Criteria cri, Model model) {
		model.addAttribute("get", partService.get(partCode));
		model.addAttribute("list", partService.getPart(cri));
		model.addAttribute("pageMaker", new PageDTO(cri, partService.count(cri)));
	}
	
	//품목 정보 수정
	@PostMapping("/modify")
	public String modify(PartVO vo, AttachFileDTO dto, Criteria cri, RedirectAttributes rttr) {
		String RegCode = vo.getLibrary();
		vo.setLibrary(RegCode);
		
		String RegCode2 = vo.getLibrarym();
		vo.setLibrarym(RegCode2);
		
		String ComCode = vo.getLibrary();
		dto.setLibrary(ComCode);
		
		String ComCode2 = vo.getLibrarym();
		dto.setLibrarym(ComCode2);
		
		if(partService.modify(vo)) {
			rttr.addFlashAttribute("state", "modify");
		}
		
		return "redirect:/part/partList?pageNum="+cri.getPageNum()+"&amount="+cri.getAmount()+"&type="+cri.getType()+"&keyword="+cri.getKeyword();
	}
}
