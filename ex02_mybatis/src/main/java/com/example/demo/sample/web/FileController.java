package com.example.demo.sample.web;

import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.URLEncoder;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;

import com.example.demo.config.FileDownloadView;
import com.example.demo.sample.mapper.SampleVO;
import com.example.demo.util.FileUtils;

import jakarta.servlet.http.HttpServletResponse;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@Controller
public class FileController {
	
	@Value("${file.upload}")
	String path;

	@GetMapping("register")
	public String registerpage() {
		return "file/register";
	}
	
	@PostMapping("/register")
	public String register(MultipartFile file, SampleVO vo) throws IllegalStateException, IOException { // 파일 타입임으로 MultipartFile 사용
		
		log.info("filename: " + file.getOriginalFilename());
		log.info("filesize: " + file.getSize());
		
		String fileName = FileUtils.uuidFilename(file.getOriginalFilename());
		file.transferTo(new File(path, fileName));
		
		
//		file.transferTo(new File("d:/upload", file.getOriginalFilename())); // hard coding
//		file.transferTo(new File(path, file.getOriginalFilename())); // Stirng fileName으로 인한 주석처리(파일 중복처리)
		return "/sample";
	}
	
	@GetMapping("/filelist")
	public String filelist(Model model) {
		model.addAttribute("list", new File(path).list(null)); // upload 폴더에 있는 목록
		return "file/list";
	}
	
	@GetMapping("/download")
	public void downloadFile(String filename, HttpServletResponse response) throws IOException {
		Path filePath = Paths.get(path).resolve(filename).normalize();

		if (!Files.exists(filePath) || !Files.isRegularFile(filePath)) {
			response.sendError(HttpServletResponse.SC_NOT_FOUND, "파일이 존재하지 않습니다.");
			return;
		}

		// 파일명 한글/특수문자 처리
		String encodedFilename = URLEncoder.encode(filePath.getFileName().toString(), "UTF-8").replaceAll("\\+", "%20");

		// 응답 헤더 설정
		response.setContentType("application/octet-stream"); // 매우 중요(다운로드 개시)
		response.setHeader("Content-Disposition", "attachment; filename=\"" + encodedFilename + "\"");
		response.setContentLengthLong(Files.size(filePath));

		// 파일 스트림 전송
		try (InputStream is = Files.newInputStream(filePath); OutputStream os = response.getOutputStream()) {

			byte[] buffer = new byte[8192]; // 8KB 버퍼
			int bytesRead;
			while ((bytesRead = is.read(buffer)) != -1) {
				os.write(buffer, 0, bytesRead);
			}
			os.flush();
		}
	}
	
	
	// view resolver 생성 후(FileDownloadView.java)
	@Autowired FileDownloadView fileDownloadView;
	
	@GetMapping("/downview")
	public ModelAndView download(String filename) {
		ModelAndView mv = new ModelAndView(fileDownloadView);
		mv.addObject("filename", filename);
		mv.addObject("path", path);
		
		return mv;
	}
}
