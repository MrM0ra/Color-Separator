package co.edu.icesi.dev.sat.alert.endpoint.simulator.repo;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import co.edu.icesi.dev.sat.alert.endpoint.simulator.model.Homework;

/**
 * @author Dennys Mosquera
 * Repository for the simulated endpoint model class Homework
 */
@Repository
public interface HomeworkRepository  extends CrudRepository<Homework, Long>{

}
