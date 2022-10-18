package controller;

import java.io.File;
import java.io.IOException;
import java.rmi.StubNotFoundException;
import java.util.Date;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.MultipartHttpServletRequest;

@Controller
public class ReportSubmissionController {

	
	
	private String uploadPath = "C:\\Users\\EZEN\\git\\spring\\Spring\\src\\main\\webapp\\files\\";
	
	@RequestMapping(value = "/report/submission.do", method = RequestMethod.GET)
	public String form() {
		return "report/submissionForm";
	}
	
	private void printInfo(String studentNumber, MultipartFile report) {
		System.out.println(studentNumber + "가 업로드한 파일 : " + report.getOriginalFilename());
		
	}
	
	
	
	
	
	
	@RequestMapping(value = "report/submitReport1.do", method = RequestMethod.POST)
	public String submitReport1(@RequestParam("studentNumber") String studentNumber, @RequestParam("report") MultipartFile report) {
		
		printInfo(studentNumber, report);
		
		String fileName = report.getOriginalFilename();
		File uploadFile = new File(uploadPath + fileName);
		
		if(uploadFile.exists()) {
			fileName = new Date().getTime() + fileName;
			uploadFile = new File(uploadPath + fileName);
		}
		
		try {
			report.transferTo(uploadFile);
			
		}catch(IOException ex) {
			ex.printStackTrace();
		}
		
		
		return "report/submissionComplete";
	}


	
	
	@RequestMapping(value = "/report/submitReport2.do", method = RequestMethod.POST)
	public String submitReport2(MultipartHttpServletRequest request) {
		
		String studentNumber = request.getParameter("studentNumber");
		MultipartFile report = request.getFile("report");
		
		printInfo(studentNumber, report);
		
		String fileName = report.getOriginalFilename();
		File uploadFile = new File(uploadPath + fileName);
		
		if(uploadFile.exists()) {
			fileName = new Date().getTime() + fileName;
			uploadFile = new File(uploadPath + fileName);
		}
		
		try {
			report.transferTo(uploadFile);
		}catch(Exception ex) {
			ex.printStackTrace();
		}
		
		return "report/submissionComplete";
	}

	@RequestMapping(value = "/report/submitReport3.do", method = RequestMethod.POST)
	public String submitReport3(ReportCommand reportCommand) {
		
		MultipartFile report = reportCommand.getReport();
		
		String fileName = report.getOriginalFilename();
		File uploadFile = new File(uploadPath + fileName);
		
		printInfo(reportCommand.getStudentNumber(), report);
		
		if(uploadFile.exists()) {
			fileName = new Date().getTime() + fileName;
			uploadFile = new File(uploadPath + fileName);
		}
		
		try {
			report.transferTo(uploadFile);
		}catch(Exception ex) {
			ex.printStackTrace();
		}
		
		
		return "report/submissionComplete";
	}
	
	
	
}










