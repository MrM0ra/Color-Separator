package co.edu.icesi.dev.sat.alert.entity.entities;

import java.io.Serializable;
import javax.persistence.*;
import java.util.List;


/**
 * The persistent class for the ALERT_RISK_LEVEL database table.
 * 
 */
@Entity
@Table(name="ALERT_RISK_LEVEL")
@NamedQuery(name="AlertRiskLevel.findAll", query="SELECT a FROM AlertRiskLevel a")
public class AlertRiskLevel implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@Column(name="ALERT_RSK_LEVEL_ID")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long alertRskLevelId;

	@Column(name="ALERT_RSK_LEVEL_NAME")
	private String alertRskLevelName;

	//bi-directional many-to-one association to Alert
	@OneToMany(mappedBy="alertRiskLevel")
	private List<Alert> alerts;

	public AlertRiskLevel() {
	}

	public long getAlertRskLevelId() {
		return this.alertRskLevelId;
	}

	public void setAlertRskLevelId(long alertRskLevelId) {
		this.alertRskLevelId = alertRskLevelId;
	}

	public String getAlertRskLevelName() {
		return this.alertRskLevelName;
	}

	public void setAlertRskLevelName(String alertRskLevelName) {
		this.alertRskLevelName = alertRskLevelName;
	}

	public List<Alert> getAlerts() {
		return this.alerts;
	}

	public void setAlerts(List<Alert> alerts) {
		this.alerts = alerts;
	}

	public Alert addAlert(Alert alert) {
		getAlerts().add(alert);
		alert.setAlertRiskLevel(this);

		return alert;
	}

	public Alert removeAlert(Alert alert) {
		getAlerts().remove(alert);
		alert.setAlertRiskLevel(null);

		return alert;
	}

}