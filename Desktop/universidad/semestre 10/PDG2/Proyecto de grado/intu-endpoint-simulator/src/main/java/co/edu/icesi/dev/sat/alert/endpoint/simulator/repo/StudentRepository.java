package co.edu.icesi.dev.sat.alert.endpoint.simulator.repo;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import co.edu.icesi.dev.sat.alert.endpoint.simulator.model.Student;

/**
 * @author Dennys Mosquera
 * Repository for the simulated endpoint model class Student
 */
@Repository
public interface StudentRepository extends CrudRepository<Student, Long> {

}
