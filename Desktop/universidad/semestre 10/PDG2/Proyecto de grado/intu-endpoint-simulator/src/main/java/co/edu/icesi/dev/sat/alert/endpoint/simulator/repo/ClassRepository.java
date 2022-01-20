package co.edu.icesi.dev.sat.alert.endpoint.simulator.repo;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import co.edu.icesi.dev.sat.alert.endpoint.simulator.model.ModelClass;

/**
 * @author Dennys Mosquera
 * Repository for the simulated endpoint model class ModelClass
 */
@Repository
public interface ClassRepository extends CrudRepository<ModelClass, Long>{

}
