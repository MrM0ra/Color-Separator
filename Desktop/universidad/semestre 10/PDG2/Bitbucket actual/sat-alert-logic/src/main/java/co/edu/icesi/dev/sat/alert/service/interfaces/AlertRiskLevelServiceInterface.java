package co.edu.icesi.dev.sat.alert.service.interfaces;

import org.springframework.stereotype.Service;

import co.edu.icesi.dev.sat.alert.entity.entities.AlertRiskLevel;

/**
 * Interface to define methods for the Alert Risk Level Service
 * @author Victor Mora
 */
@Service
public interface AlertRiskLevelServiceInterface {

	public void createRiskLevel(String alertRskLevelName);
	public AlertRiskLevel readRiskLevel(long alertRskLevelId);
	public AlertRiskLevel updateRiskLevel(AlertRiskLevel alertRiskLvl);
	public void deleteRiskLevel(long alertRskLevelId);
	public AlertRiskLevel findById(long alertRskLevelId);
	
}
