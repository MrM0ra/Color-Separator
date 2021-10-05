package co.edu.icesi.dev.sat.alert.entity.tdos;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

public class AlertStdInDTO {

	@NotNull
	@NotBlank
	private String alertDescription;

	private long alertRiskLevel;
	
	private long  alertType;

	public String getAlertDescription() {
		return alertDescription;
	}

	public void setAlertDescription(String alertDescription) {
		this.alertDescription = alertDescription;
	}

	public long getAlertRiskLevel() {
		return alertRiskLevel;
	}

	public void setAlertRiskLevel(long alertRiskLevel) {
		this.alertRiskLevel = alertRiskLevel;
	}

	public long getAlertType() {
		return alertType;
	}

	public void setAlertType(long alertType) {
		this.alertType = alertType;
	}
	
	
	
}
