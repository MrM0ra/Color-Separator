package co.edu.icesi.dev.sat.alert.entity.tdos;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

public class AlertInstanceStdInDTO {

	@NotNull
	@NotBlank
	private String alertDeactivate;
	
	@NotNull
	@NotBlank
	private String alertState;
	
	@NotNull
	@NotBlank
	private String alertDescription;
	
	private long alertID;

	public String getAlertDeactivate() {
		return alertDeactivate;
	}

	public void setAlertDeactivate(String alertDeactivate) {
		this.alertDeactivate = alertDeactivate;
	}

	public String getAlertState() {
		return alertState;
	}

	public void setAlertState(String alertState) {
		this.alertState = alertState;
	}

	public String getAlertDescription() {
		return alertDescription;
	}

	public void setAlertDescription(String alertDescription) {
		this.alertDescription = alertDescription;
	}

	public long getAlertID() {
		return alertID;
	}

	public void setAlertID(long alertID) {
		this.alertID = alertID;
	}
	
	
	
}
