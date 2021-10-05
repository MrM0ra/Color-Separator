package co.edu.icesi.dev.sat.alert.repository.interfaces;

import java.util.List;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import co.edu.icesi.dev.sat.alert.entity.entities.AlertInstance;

/**
 * 
 * @author Victor Mora
 * @version 0.0.1
 * Repository to make CRUD operations with Alert's instances
 */
@Repository
public interface AlertInstanceRepo extends CrudRepository<AlertInstance, Long>{

	@Override
	List<AlertInstance> findAll();
	
	AlertInstance findById(long alertInstancetId);
	
	
}
