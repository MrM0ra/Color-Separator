package co.edu.icesi.dev.sat.alert.repository.interfaces;

import java.util.List;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import co.edu.icesi.dev.sat.alert.entity.entities.Action;

/**
 * 
 * @author Victor Mora
 * @version 0.0.1
 * Repository to make CRUD operations with Alert's Actions
 */
@Repository
public interface AlertActionRepo extends CrudRepository<Action, Long>{

	@Override
	List<Action> findAll();
	Action findById(long actiontId);
	
}
