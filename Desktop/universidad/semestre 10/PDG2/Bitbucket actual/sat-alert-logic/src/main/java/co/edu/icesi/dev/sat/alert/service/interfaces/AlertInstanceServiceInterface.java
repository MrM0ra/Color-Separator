package co.edu.icesi.dev.sat.alert.service.interfaces;

import org.springframework.stereotype.Service;

import co.edu.icesi.dev.sat.alert.entity.entities.AlertInstance;

/**
 * Interface to define methods for the Alert Instance Service
 * @author Victor Mora
 */
@Service
public interface AlertInstanceServiceInterface {

	public AlertInstance createAlertInstance(String alertDeactivate, String alertState, String alertDescription, long alrtId);
	public AlertInstance readAlertInstance(long alertInstanceID);
	public AlertInstance updateAlertInstance(AlertInstance alertInstance);
	public void deleteAlertInstance(long alertInstanceID);
	public AlertInstance findById(long alrtInstId);
	
}
