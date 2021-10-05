package co.edu.icesi.dev.sat.alert.repository.interfaces;

import java.util.List;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import co.edu.icesi.dev.sat.alert.entity.entities.Alert;

/**
 * 
 * @author Victor Mora
 * @version 0.0.1
 * Repository to make CRUD operations with Alerts
 */
@Repository
public interface AlertRepo extends CrudRepository<Alert, Long>{

	@Override
	List<Alert> findAll();
	
	Alert findById(long alertId);
	
}
