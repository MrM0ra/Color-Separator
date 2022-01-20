package co.edu.icesi.dev.sat.alert.endpoint.simulator.repo;

import java.util.List;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import co.edu.icesi.dev.sat.alert.endpoint.simulator.model.Course;

/**
 * @author Dennys Mosquera
 * Repository for the simulated endpoint model class Course
 */
@Repository
public interface CourseRepository extends CrudRepository<Course, Long>{

	@Override
	List<Course> findAll();
	
}
