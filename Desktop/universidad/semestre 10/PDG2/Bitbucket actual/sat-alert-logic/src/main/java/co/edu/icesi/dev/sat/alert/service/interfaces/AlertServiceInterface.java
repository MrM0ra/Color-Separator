package co.edu.icesi.dev.sat.alert.service.interfaces;

import org.springframework.stereotype.Service;

import co.edu.icesi.dev.sat.alert.entity.entities.Alert;

/**
 * Interface to define the methods for the Alert Service
 * @author Victor Mora
 */
@Service
public interface AlertServiceInterface {

	public Alert createAlert(String alertDescription, long alertTypeId, long alertRskLevelId);
	public Alert readAlert(long alertID);
	public Alert updateAlert(Alert alertID);
	public void deleteAlert(long alertID);
	public Alert findById(long alertID);
	
}
