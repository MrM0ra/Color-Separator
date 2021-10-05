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

import co.edu.icesi.dev.sat.alert.entity.entities.AlertType;
import co.edu.icesi.dev.sat.alert.service.implementation.AlertTypeServiceImplementation;

@RestController
@RequestMapping("alertType")
public class AlertTypeControllerImp {

	@Autowired
	private AlertTypeServiceImplementation alrtTServ;
	
	@PostMapping("/")
	public void createAlertType(@RequestBody AlertType alrtT) {
		alrtTServ.createAlertType(alrtT);
	}
	
	@DeleteMapping("/{alertTypeId}")
	public void deleteAlertType(@PathVariable long alertTypeId) {
		alrtTServ.deleteAlertType(alertTypeId);
	}

	@PutMapping("/{alertTypeId}")
	public void editAlertType(@PathVariable long alertTypeId, @RequestBody AlertType alrtT) {
		alrtTServ.updateAlertType(alrtT);
	}

	@GetMapping("/{alertTypeId}")
	public AlertType getAlertType(@PathVariable long alertTypeId) {
		return alrtTServ.findById(alertTypeId);
	}

	@GetMapping("/")
	public List<AlertType> getAlertType() {
		return alrtTServ.findAll();
	}
	
}
