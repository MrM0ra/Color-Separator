package co.edu.icesi.dev.sat.alert.endpoint.simulator.repo;

import java.util.List;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import co.edu.icesi.dev.sat.alert.endpoint.simulator.model.StudentHomework;

/**
 * @author Dennys Mosquera
 * Repository for the simulated endpoint model class StudentHomework
 */
@Repository
public interface StudentHomeworkRepository extends CrudRepository<StudentHomework, Long> {

	@Override
	List<StudentHomework> findAll();
	
}
