package co.edu.icesi.dev.sat.alert.endpoint.simulator.rest;

import java.lang.reflect.Method;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import co.edu.icesi.dev.sat.alert.endpoint.simulator.service.StudentHomeworkServiceImp;

/**
 * 
 * @author Victor Mora
 * Rest controller for the /student_absence endpoint
 */
@RestController
@CrossOrigin(origins = "*", allowedHeaders = "*")
@RequestMapping("/student_absence")
public class StudentAbsenceController {

	@Autowired
	private StudentHomeworkServiceImp stdHwSrv;
	
	@SuppressWarnings("unchecked")
	@GetMapping("/{comparator}/{assistsPercentage}/{methodName}")
	public List<String> getStudentAbsences(@PathVariable String comparator, @PathVariable double assistsPercentage,
			@PathVariable String methodName) {
		
		System.out.println("Entro al rest del endopoint simulado");
		
		Class<?>[] paramTypes = {String.class, double.class};
		try {
			Method findByAbsencesMethod = stdHwSrv.getClass().getMethod(methodName, paramTypes);
			return (List<String>) findByAbsencesMethod.invoke(stdHwSrv, comparator, assistsPercentage);
		}catch(Exception e) {
			e.printStackTrace();
		}
		return null;
	}
	
}
