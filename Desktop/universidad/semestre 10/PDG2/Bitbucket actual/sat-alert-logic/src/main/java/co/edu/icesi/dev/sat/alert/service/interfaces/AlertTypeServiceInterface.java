package co.edu.icesi.dev.sat.alert.service.interfaces;

import org.springframework.stereotype.Service;

import co.edu.icesi.dev.sat.alert.entity.entities.AlertType;

/**
 * Interface to define the methods for the Alert type Service
 * @author Victor Mora
 */
@Service
public interface AlertTypeServiceInterface {

	public AlertType createAlertType(AlertType alrtT);
	public AlertType readAlertType(long alertTypeID);
	public AlertType updateAlertType(AlertType alertType);
	public void deleteAlertType(long alertTypeID);
	public AlertType findById(long alertTypeID);
	
}
