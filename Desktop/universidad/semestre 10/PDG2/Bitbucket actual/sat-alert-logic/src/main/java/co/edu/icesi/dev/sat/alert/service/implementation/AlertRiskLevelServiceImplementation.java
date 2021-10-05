package co.edu.icesi.dev.sat.alert.service.implementation;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;

import co.edu.icesi.dev.sat.alert.entity.entities.AlertRiskLevel;
import co.edu.icesi.dev.sat.alert.repository.interfaces.AlertRiskLevelRepo;
import co.edu.icesi.dev.sat.alert.service.interfaces.AlertRiskLevelServiceInterface;

public class AlertRiskLevelServiceImplementation implements AlertRiskLevelServiceInterface {

	private AlertRiskLevelRepo alrtRskLvlRep;
	
	@Autowired
	public AlertRiskLevelServiceImplementation(AlertRiskLevelRepo alrtRskLvlRep){
		this.alrtRskLvlRep=alrtRskLvlRep;
	}
	
	@Override
	@Transactional
	public void createRiskLevel(String alertRskLevelName) {
		AlertRiskLevel alrtRskLvl = new AlertRiskLevel();
		alrtRskLvl.setAlertRskLevelName(alertRskLevelName);
		alrtRskLvlRep.save(alrtRskLvl);
	}

	@Override
	@Transactional
	public AlertRiskLevel readRiskLevel(long alertRskLevelId) {
		if(alrtRskLvlRep.existsById(alertRskLevelId)) {
			return alrtRskLvlRep.findById(alertRskLevelId);
		}else {
			return null;
		}
	}

	@Override
	@Transactional
	public AlertRiskLevel updateRiskLevel(AlertRiskLevel alertRiskLvl) {
		if(alrtRskLvlRep.existsById(alertRiskLvl.getAlertRskLevelId())) {
			alrtRskLvlRep.save(alertRiskLvl);
			return alrtRskLvlRep.findById(alertRiskLvl.getAlertRskLevelId());
		}else {
			return null;
		}
	}

	@Override
	@Transactional
	public void deleteRiskLevel(long alertRskLevelId) {
		if(alrtRskLvlRep.existsById(alertRskLevelId)) {
			alrtRskLvlRep.deleteById(alertRskLevelId);
		}
	}
	
	@Override
	@Transactional
	public AlertRiskLevel findById(long alertRskLevelId) {
		if(alrtRskLvlRep.existsById(alertRskLevelId)) {
			return alrtRskLvlRep.findById(alertRskLevelId); 
		}else {
			return null;
		}
	}

	public List<AlertRiskLevel> findAll() {
		return alrtRskLvlRep.findAll();
	}
	

}
