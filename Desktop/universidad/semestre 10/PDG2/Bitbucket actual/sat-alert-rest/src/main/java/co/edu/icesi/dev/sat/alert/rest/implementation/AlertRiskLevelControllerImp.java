package co.edu.icesi.dev.sat.alert.rest.implementation;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import co.edu.icesi.dev.sat.alert.entity.entities.AlertRiskLevel;
import co.edu.icesi.dev.sat.alert.service.implementation.AlertRiskLevelServiceImplementation;

@RestController
@RequestMapping("alertRiskLevel")
public class AlertRiskLevelControllerImp {

	@Autowired
	private AlertRiskLevelServiceImplementation alrtRLServ;
	
	@PostMapping("/")
	public void createRiskLevel(@RequestBody AlertRiskLevel alrtRL) {
		alrtRLServ.createRiskLevel(alrtRL.getAlertRskLevelName());
	}
	
	@DeleteMapping("/{RiskLevelId}")
	public void deleteRiskLevel(@PathVariable long riskLevelId) {
		alrtRLServ.deleteRiskLevel(riskLevelId);
	}

	@PutMapping("/{RiskLevelId}")
	public void editRiskLevel(@PathVariable long RiskLevelId, @RequestBody AlertRiskLevel alrtT) {
		alrtRLServ.updateRiskLevel(alrtT);
	}

	@GetMapping("/{RiskLevelId}")
	public AlertRiskLevel getRiskLevel(@PathVariable long RiskLevelId) {
		return alrtRLServ.findById(RiskLevelId);
	}

	@GetMapping("/")
	public List<AlertRiskLevel> getRiskLevel() {
		return alrtRLServ.findAll();
	}
	
}
