package co.edu.icesi.dev.sat.alert.service.implementation;

import java.util.Date;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import co.edu.icesi.dev.sat.alert.entity.entities.Action;
import co.edu.icesi.dev.sat.alert.repository.interfaces.AlertActionRepo;
import co.edu.icesi.dev.sat.alert.service.interfaces.AlertActionServiceInterface;

/**
 * Alert action service representation
 * @author Victor Mora
 */
@Service
public class AlertActionServiceImplementation implements AlertActionServiceInterface{

	private AlertInstanceServiceImplementation alrtInstServ;
	private AlertActionRepo alertActionRep;
	
	@Autowired
	public AlertActionServiceImplementation(AlertInstanceServiceImplementation alrtInstServ,
			AlertActionRepo alertActionRep) {
		this.alrtInstServ = alrtInstServ;
		this.alertActionRep = alertActionRep;
	}

	@Override
	@Transactional
	public Action createAction(String actionComment, String actionDescription, long alrtInstId) {
		Action act = new Action();
		if(alrtInstServ.findById(alrtInstId)!=null) {
			act.setActionComment(actionComment);
			act.setActionCreationDate(new Date());
			act.setActionDescription(actionDescription);
			act.setAlertInstance(alrtInstServ.findById(alrtInstId));
			alertActionRep.save(act);
			return act;
		}
		return null;
	}

	@Override
	@Transactional
	public Action readAction(long actionID) {
		if(alertActionRep.existsById(actionID)) {
			return alertActionRep.findById(actionID);
		}
		return null;
	}

	@Override
	@Transactional
	public Action updateAction(Action action) {
		if(alertActionRep.existsById(action.getActionId())) {
			alertActionRep.save(action);
			return alertActionRep.findById(action.getActionId());
		}
		return null;
	}

	@Override
	@Transactional
	public void deleteAction(long actionID) {
		if(alertActionRep.existsById(actionID)) {
			alertActionRep.deleteById(actionID);
		}
	}
	
	 
}
