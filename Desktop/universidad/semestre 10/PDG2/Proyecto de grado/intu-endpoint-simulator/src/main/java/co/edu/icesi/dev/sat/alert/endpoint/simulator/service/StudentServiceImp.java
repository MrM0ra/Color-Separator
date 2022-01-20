package co.edu.icesi.dev.sat.alert.endpoint.simulator.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import co.edu.icesi.dev.sat.alert.endpoint.simulator.model.Student;
import co.edu.icesi.dev.sat.alert.endpoint.simulator.repo.StudentRepository;


/**
 * 
 * @author Camilo Castillo
 *	Service with tools to be used when info needed about the Student class
 */
@Service
public class StudentServiceImp {

	private StudentRepository studentRepo;

	@Autowired
	public StudentServiceImp(StudentRepository studentRepo) {
		this.studentRepo = studentRepo;
	}
	
	public void createStudent(Student hw) {
		studentRepo.save(hw);
	}
	
	public Student findById(long stdId) {
		return studentRepo.findById(stdId).get();
	}
	
	public void editStudent(Student hw) {
		studentRepo.save(hw);
	}
	
	public Iterable<Student> findAll(){
		return studentRepo.findAll();
	}
	
	
	
}
