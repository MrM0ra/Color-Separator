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

import co.edu.icesi.dev.sat.alert.entity.entities.Alert;
import co.edu.icesi.dev.sat.alert.entity.tdos.AlertStdInDTO;
import co.edu.icesi.dev.sat.alert.service.implementation.AlertServiceImplementation;

@RestController
@RequestMapping("alert")
public class AlertControllerImp {

	@Autowired
	private AlertServiceImplementation alrtServ;
	
	@PostMapping("/")
	public void createAlert(@RequestBody AlertStdInDTO alrt) {
		alrtServ.createAlert(alrt.getAlertDescription(), alrt.getAlertType(), alrt.getAlertRiskLevel());
	}
	
	@DeleteMapping("/{AlertId}")
	public void deleteAlert(@PathVariable long AlertId) {
		alrtServ.deleteAlert(AlertId);
	}

	@PutMapping("/{AlertId}")
	public void editAlert(@PathVariable long AlertId, @RequestBody Alert alrtT) {
		alrtServ.updateAlert(alrtT);
	}

	@GetMapping("/{AlertId}")
	public Alert getAlert(@PathVariable long AlertId) {
		return alrtServ.findById(AlertId);
	}

	@GetMapping("/")
	public List<Alert> getAlert() {
		return alrtServ.findAll();
	}
	
}
