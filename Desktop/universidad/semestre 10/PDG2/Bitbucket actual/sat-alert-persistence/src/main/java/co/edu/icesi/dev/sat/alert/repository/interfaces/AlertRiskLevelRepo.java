package co.edu.icesi.dev.sat.alert.repository.interfaces;

import java.util.List;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import co.edu.icesi.dev.sat.alert.entity.entities.AlertRiskLevel;

/**
 * 
 * @author Victor Mora
 * @version 0.0.1
 * Repository to make CRUD operations with Alert's Risk Level
 */
@Repository
public interface AlertRiskLevelRepo extends CrudRepository<AlertRiskLevel, Long>{

	@Override
	List<AlertRiskLevel> findAll();
	AlertRiskLevel findById(long alertRiskLevelId);
	
}
