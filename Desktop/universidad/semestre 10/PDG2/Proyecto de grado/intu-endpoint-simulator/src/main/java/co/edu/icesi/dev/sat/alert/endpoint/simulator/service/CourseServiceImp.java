package co.edu.icesi.dev.sat.alert.endpoint.simulator.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import co.edu.icesi.dev.sat.alert.endpoint.simulator.model.Course;
import co.edu.icesi.dev.sat.alert.endpoint.simulator.repo.CourseRepository;

/**
 * 
 * @author Camilo Castillo
 *	Service with tools to be used when info needed about the Course class
 */
@Service
public class CourseServiceImp {

	private CourseRepository courseRepo;

	@Autowired
	public CourseServiceImp(CourseRepository courseRepo) {
		this.courseRepo = courseRepo;
	}
	
	public void createCourse(Course crs) {
		courseRepo.save(crs);
	}
	
	public Course findById(long crsId) {
		return courseRepo.findById(crsId).get();
	}
	
	public List<Course> findAll(){
		return courseRepo.findAll();
	}
	
	
	
}
