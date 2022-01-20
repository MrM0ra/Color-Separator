package co.edu.icesi.dev.sat.alert.endpoint.simulator.rest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import co.edu.icesi.dev.sat.alert.endpoint.simulator.model.Report;
import co.edu.icesi.dev.sat.alert.endpoint.simulator.service.ReportServiceImp;

/**
 * 
 * @author Victor Mora
 *	Rest controller for the /report endpoint
 */
@RestController
@CrossOrigin(origins = "*", allowedHeaders = "*")
@RequestMapping("/report")
public class ReportController {
	
	@Autowired
	private ReportServiceImp repServ;
	
	@GetMapping
	public Iterable<Report> getReports() {
		return repServ.findAll();
	}

}
