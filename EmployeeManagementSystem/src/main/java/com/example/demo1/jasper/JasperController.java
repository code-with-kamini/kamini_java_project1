package com.example.demo1.jasper;

import java.io.FileInputStream;

import java.io.FileNotFoundException;
import java.util.HashMap;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import net.sf.jasperreports.engine.JRException;
import net.sf.jasperreports.engine.JasperCompileManager;
import net.sf.jasperreports.engine.JasperExportManager;
import net.sf.jasperreports.engine.JasperFillManager;
import net.sf.jasperreports.engine.JasperPrint;
import net.sf.jasperreports.engine.JasperReport;
import net.sf.jasperreports.engine.data.JRBeanCollectionDataSource;

@RestController
public class JasperController {
	
	
	@GetMapping("/pdf")
	public String generatePdf() throws FileNotFoundException, JRException {
		
		JRBeanCollectionDataSource beanCollectionDataSource = new JRBeanCollectionDataSource(EmployeeService.generateUserList());
		
		JasperReport compileReport = JasperCompileManager.compileReport(new FileInputStream("src/main/resources/employee.jrxml")); 
		
		HashMap<String, Object> map= new HashMap<>();
		JasperPrint report = JasperFillManager.fillReport(compileReport, map,beanCollectionDataSource);
		
		JasperExportManager.exportReportToPdfFile(report,"employee.pdf");
		
		return "generated";
	}

}
