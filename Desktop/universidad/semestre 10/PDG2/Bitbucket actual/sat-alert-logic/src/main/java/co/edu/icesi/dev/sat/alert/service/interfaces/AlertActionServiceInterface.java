package co.edu.icesi.dev.sat.alert.service.interfaces;

import org.springframework.stereotype.Service;

import co.edu.icesi.dev.sat.alert.entity.entities.Action;

/**
 * Interface to define the methods for the Action Service
 * @author Victor Mora
 */
@Service
public interface AlertActionServiceInterface {
	
	public Action createAction(String actionComment, String actionDescription, long alrtInstId);
	public Action readAction(long actionID);
	public Action updateAction(Action action);
	public void deleteAction(long actionID);

}
