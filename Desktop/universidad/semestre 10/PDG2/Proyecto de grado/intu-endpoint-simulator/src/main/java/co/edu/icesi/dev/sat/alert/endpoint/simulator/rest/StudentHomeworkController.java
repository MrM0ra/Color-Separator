package co.edu.icesi.dev.sat.alert.endpoint.simulator.rest;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import co.edu.icesi.dev.sat.alert.endpoint.simulator.model.StudentHomework;
import co.edu.icesi.dev.sat.alert.endpoint.simulator.service.StudentHomeworkServiceImp;

/**
 * 
 * @author Victor Mora
 *	Rest controller for the /student_homework endpoint 
 */
@RestController
@CrossOrigin(origins = "*", allowedHeaders = "*")
@RequestMapping("/student_homework")
public class StudentHomeworkController {

	@Autowired
	private StudentHomeworkServiceImp stdHwSrv;
	
	@GetMapping
	public Iterable<StudentHomework> getStudentHomeworks() {
		return stdHwSrv.findAll();
	}

	@GetMapping("/lt/{grade}/{hws}")
	public List<String> getStudentHomeworks(@PathVariable double grade, @PathVariable int hws) {
		return stdHwSrv.findByGrade("lt", grade, hws);
	}
	
}
