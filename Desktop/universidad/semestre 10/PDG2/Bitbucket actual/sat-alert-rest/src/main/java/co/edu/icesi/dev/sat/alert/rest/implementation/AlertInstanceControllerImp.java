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

import co.edu.icesi.dev.sat.alert.entity.entities.AlertInstance;
import co.edu.icesi.dev.sat.alert.entity.tdos.AlertInstanceStdInDTO;
import co.edu.icesi.dev.sat.alert.service.implementation.AlertInstanceServiceImplementation;

@RestController
@RequestMapping("alert")
public class AlertInstanceControllerImp {

	@Autowired
	private AlertInstanceServiceImplementation alrtInstServ;
	
	@PostMapping("/")
	public void createAlertInstance(@RequestBody AlertInstanceStdInDTO alrtI) {
		alrtInstServ.createAlertInstance(alrtI.getAlertDeactivate(), alrtI.getAlertState(),
				alrtI.getAlertDescription(), alrtI.getAlertID());
		getAlertInstance();
	}
	
	@DeleteMapping("/{AlertInstanceId}")
	public void deleteAlertInstance(@PathVariable long AlertInstanceId) {
		alrtInstServ.deleteAlertInstance(AlertInstanceId);
		getAlertInstance();
	}

	@PutMapping("/{AlertInstanceId}")
	public void editAlertInstance(@PathVariable long alertInstanceId, @RequestBody AlertInstanceStdInDTO alrtI) {
		//alrtInstServ.updateAlertInstance(alertInstanceId, alrtI);
		getAlertInstance();
	}

	@GetMapping("/{AlertInstanceId}")
	public AlertInstance getAlertInstance(@PathVariable long alertInstanceId) {
		return alrtInstServ.findById(alertInstanceId);
	}

	@GetMapping("/")
	public List<AlertInstance> getAlertInstance() {
		return alrtInstServ.findAll();
	}
	
}
