package co.edu.icesi.dev.sat.alert.endpoint.simulator.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import co.edu.icesi.dev.sat.alert.endpoint.simulator.model.Report;
import co.edu.icesi.dev.sat.alert.endpoint.simulator.repo.ReportRepository;

/**
 * 
 * @author Camilo Castillo
 *	Service with tools to be used when info needed about the Report class
 */
@Service
public class ReportServiceImp {

	private ReportRepository reportRepo;

	@Autowired
	public ReportServiceImp(ReportRepository reportRepo) {
		this.reportRepo=reportRepo;
	}
	
	public void createReport(Report rep) {
		reportRepo.save(rep);
	}
	
	public Iterable<Report> findAll(){
		return reportRepo.findAll();
	}
	
}
