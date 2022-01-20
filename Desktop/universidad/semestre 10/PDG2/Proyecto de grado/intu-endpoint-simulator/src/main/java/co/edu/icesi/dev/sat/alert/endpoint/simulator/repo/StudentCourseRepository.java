package co.edu.icesi.dev.sat.alert.endpoint.simulator.repo;

import java.util.List;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import co.edu.icesi.dev.sat.alert.endpoint.simulator.model.StudentCourse;

/**
 * @author Dennys Mosquera
 * Repository for the simulated endpoint model class StudentCourse
 */
@Repository
public interface StudentCourseRepository  extends CrudRepository<StudentCourse, Long> {

	@Override
	List<StudentCourse> findAll();
	
}
