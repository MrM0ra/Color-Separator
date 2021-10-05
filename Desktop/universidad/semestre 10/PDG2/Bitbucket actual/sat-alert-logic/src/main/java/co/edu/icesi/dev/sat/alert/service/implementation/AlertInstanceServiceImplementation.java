package co.edu.icesi.dev.sat.alert.service.implementation;

import java.util.Date;
import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import co.edu.icesi.dev.sat.alert.entity.entities.Alert;
import co.edu.icesi.dev.sat.alert.entity.entities.AlertInstance;
import co.edu.icesi.dev.sat.alert.repository.interfaces.AlertInstanceRepo;
import co.edu.icesi.dev.sat.alert.service.interfaces.AlertInstanceServiceInterface;

/**
 * Alert instance service representation
 * @author Victor Mora
 */
@Service
public class AlertInstanceServiceImplementation implements AlertInstanceServiceInterface {

	private AlertInstanceRepo alertInstRepo;
	private AlertRiskLevelServiceImplementation alrtRskLvlServ;
	private AlertServiceImplementation alertServ;
	private AlertTypeServiceImplementation alrtTypeServ;
	
	@Autowired
	public AlertInstanceServiceImplementation(AlertInstanceRepo alertInstRepo,
			AlertRiskLevelServiceImplementation alrtRskLvlServ, AlertServiceImplementation alertServ,
			AlertTypeServiceImplementation alrtTypeServ) {
		this.alertInstRepo = alertInstRepo;
		this.alrtRskLvlServ = alrtRskLvlServ;
		this.alertServ = alertServ;
		this.alrtTypeServ = alrtTypeServ;
	}

	@Override
	@Transactional
	public AlertInstance createAlertInstance(String alertDeactivate, String alertState, String alertDescription, long alrtId) {
		AlertInstance alIns = new AlertInstance();
		alIns.setAlertCreationDate(new Date());
		if(alertServ.findById(alrtId)!=null) {
			alIns.setAlertDeactivate(alertDeactivate);
			alIns.setAlertState(alertState);
			alertServ.findById(alrtId).setAlertDescription(alertDescription);
			alertServ.updateAlert(alertServ.findById(alrtId));
			alIns.setAlert(alertServ.findById(alrtId));
			alertInstRepo.save(alIns);
			return alIns;
		}
		return null;
	}
	
	@Transactional
	public AlertInstance createAlertInstance(long alertRskLevelId, String alertDescription, 
			long alertTypeId, String alertDeactivate, String alertState) {
		AlertInstance alIns = new AlertInstance();
		alIns.setAlertCreationDate(new Date());
		if(alrtRskLvlServ.findById(alertRskLevelId)!=null) {
			if(alrtTypeServ.findById(alertTypeId)!=null) {
				Alert alert = alertServ.createAlert(alertDescription, alertTypeId, alertRskLevelId);
				if(alert != null) {
					alIns.setAlertDeactivate(alertDeactivate);
					alIns.setAlertState(alertState);
					alIns.setAlert(alert);
					alertInstRepo.save(alIns);
					return alIns;
				}
			}
		}
		return null;
	}

	@Override
	@Transactional
	public AlertInstance readAlertInstance(long alertInstanceID) {
		if(alertInstRepo.existsById(alertInstanceID)) {
			return alertInstRepo.findById(alertInstanceID);
		}
		return null;
	}

	@Override
	@Transactional
	public AlertInstance updateAlertInstance(AlertInstance alertInstance) {
		if(alertInstRepo.existsById(alertInstance.getAlertInstanceId())) {
			return alertInstRepo.save(alertInstance);
		}
		return null;
	}

	@Override
	@Transactional
	public void deleteAlertInstance(long alertInstanceID) {
		if(alertInstRepo.existsById(alertInstanceID)) {
			alertInstRepo.deleteById(alertInstanceID);
		}
	}
	
	@Override
	public AlertInstance findById(long alrtInstId) {
		if(alertInstRepo.existsById(alrtInstId)) {
			return alertInstRepo.findById(alrtInstId);
		}
		return null;
	}

	public List<AlertInstance> findAll() {
		return alertInstRepo.findAll();
	}
	
}
