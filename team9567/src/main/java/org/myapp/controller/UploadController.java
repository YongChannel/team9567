package org.myapp.controller;

import java.io.UnsupportedEncodingException;

import org.springframework.core.io.FileSystemResource;
import org.springframework.core.io.Resource;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import lombok.extern.log4j.Log4j;

@RestController
@Log4j
public class UploadController {
	@GetMapping(value="/download", produces=MediaType.APPLICATION_OCTET_STREAM_VALUE)
	@ResponseBody
	public ResponseEntity<Resource> downloadFile(String fileName, String uuid, String uploadPath) {
		Resource resource = new FileSystemResource("C:\\upload\\"+uploadPath.replaceAll("[-]", "\\\\")+"\\"+uuid+"_"+fileName);
		/* Resource resource = new FileSystemResource("/upload/"+uploadPath.replaceAll("[-]", "/")+"/"+uuid+"_"+fileName); */
		
		String resourceName = resource.getFilename();
		
		HttpHeaders headers = new HttpHeaders();
		try {
			headers.add("Content-Disposition", "attachment; filename="+new String(resourceName.getBytes("utf-8"),"iso-8859-1"));
			
		} catch(UnsupportedEncodingException e) {
			e.printStackTrace();
			
		}
		
		return new ResponseEntity<Resource>(resource,headers, HttpStatus.OK);

	}
}
