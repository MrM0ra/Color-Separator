package co.edu.icesi.dev.sat.alert.service.implementation;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import co.edu.icesi.dev.sat.alert.entity.entities.Alert;
import co.edu.icesi.dev.sat.alert.repository.interfaces.AlertRepo;
import co.edu.icesi.dev.sat.alert.service.interfaces.AlertServiceInterface;

/**
 * Alert service representation
 * @author Victor Mora
 */
@Service
public class AlertServiceImplementation implements AlertServiceInterface{

	private AlertTypeServiceImplementation alertTypeServ;
	private AlertRiskLevelServiceImplementation alertRLServ;
	private AlertRepo alertRep;
	
	@Autowired
	public AlertServiceImplementation(AlertTypeServiceImplementation alertTypeServ,
			AlertRiskLevelServiceImplementation alertRLServ, AlertRepo alertRep) {
		this.alertTypeServ = alertTypeServ;
		this.alertRLServ = alertRLServ;
		this.alertRep = alertRep;
	}

	@Override
	@Transactional
	public Alert createAlert(String alertDescription, long alertTypeId, long alertRskLevelId) {
		if(alertTypeServ.findById(alertTypeId)!=null) {
			if(alertRLServ.findById(alertRskLevelId)!=null) {
				Alert alert = new Alert();
				alert.setAlertDescription(alertDescription);
				alert.setAlertType(alertTypeServ.findById(alertTypeId));
				alert.setAlertRiskLevel(alertRLServ.findById(alertRskLevelId));
				alertRep.save(alert);
				return alert;
			}
		}
		return null;
	}

	@Override
	@Transactional
	public Alert readAlert(long alertID) {
		if(alertRep.existsById(alertID)) {
			return alertRep.findById(alertID);
		}else {
			return null;
		}		
	}

	@Override
	@Transactional
	public Alert updateAlert(Alert alert) {
		if(alertRep.existsById(alert.getAlertId())) {
			if(alertTypeServ.findById(alert.getAlertType().getAlertTypeId())!=null) {
				if(alertRLServ.findById(alert.getAlertRiskLevel().getAlertRskLevelId())!=null) {
					alertRep.save(alert);
					return alertRep.findById(alert.getAlertId());
				}
			}
		}
		return null;
	}

	@Override
	@Transactional
	public void deleteAlert(long alertID) {
		if(alertRep.existsById(alertID)) {
			alertRep.deleteById(alertID);
		}
	}
	
	@Override
	public Alert findById(long alertID) {
		if(alertRep.existsById(alertID)) {
			return alertRep.findById(alertID); 
		}else {
			return null;
		}
	}

	public List<Alert> findAll() {
		return alertRep.findAll();
	}
	
	
}
