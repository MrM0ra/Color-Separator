package co.edu.icesi.dev.sat.alert.service.implementation;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import co.edu.icesi.dev.sat.alert.entity.entities.AlertType;
import co.edu.icesi.dev.sat.alert.repository.interfaces.AlertTypeRepo;
import co.edu.icesi.dev.sat.alert.service.interfaces.AlertTypeServiceInterface;

/**
 * Alert type service representation
 * @author Victor Mora
 */
@Service
public class AlertTypeServiceImplementation implements AlertTypeServiceInterface {

	private AlertTypeRepo alrtTypeRep;
	
	@Autowired
	public AlertTypeServiceImplementation(AlertTypeRepo alrtTypeRep) {
		this.alrtTypeRep=alrtTypeRep;
	}
	
	@Override
	@Transactional
	public AlertType createAlertType(AlertType alrtT) {
		return alrtTypeRep.save(alrtT);
	}

	@Override
	@Transactional
	public AlertType readAlertType(long alertTypeID) {
		if(alrtTypeRep.existsById(alertTypeID)) {
			return alrtTypeRep.findById(alertTypeID);
		}else {
			return null;
		}
	}

	@Override
	@Transactional
	public AlertType updateAlertType(AlertType alertType) {
		if(alrtTypeRep.existsById(alertType.getAlertTypeId())) {
			alrtTypeRep.save(alertType);
			return alrtTypeRep.findById(alertType.getAlertTypeId()); 
		}else {
			return null;
		}
	}

	@Override
	@Transactional
	public void deleteAlertType(long alertTypeID) {
		if(alrtTypeRep.existsById(alertTypeID)) {
			alrtTypeRep.deleteById(alertTypeID); 
		}
	}

	@Override
	@Transactional
	public AlertType findById(long alertTypeID) {
		if(alrtTypeRep.existsById(alertTypeID)) {
			return alrtTypeRep.findById(alertTypeID); 
		}else {
			return null;
		}
	}

	public List<AlertType> findAll() {
		return alrtTypeRep.findAll();
	}
	
}
