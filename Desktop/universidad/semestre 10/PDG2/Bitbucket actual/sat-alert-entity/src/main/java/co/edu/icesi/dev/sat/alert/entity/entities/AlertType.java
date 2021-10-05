package co.edu.icesi.dev.sat.alert.entity.entities;

import java.io.Serializable;
import javax.persistence.*;
import java.util.List;


/**
 * The persistent class for the ALERT_TYPE database table.
 * 
 */
@Entity
@Table(name="ALERT_TYPE")
@NamedQuery(name="AlertType.findAll", query="SELECT a FROM AlertType a")
public class AlertType implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@Column(name="ALERT_TYPE_ID")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long alertTypeId;

	@Column(name="ALERT_TYPE_NAME")
	private String alertTypeName;

	@Column(name="PERM_PERM_ID")
	private long permPermId;

	//bi-directional many-to-one association to Alert
	@OneToMany(mappedBy="alertType")
	private List<Alert> alerts;

	public AlertType() {
	}

	public long getAlertTypeId() {
		return this.alertTypeId;
	}

	public void setAlertTypeId(long alertTypeId) {
		this.alertTypeId = alertTypeId;
	}

	public String getAlertTypeName() {
		return this.alertTypeName;
	}

	public void setAlertTypeName(String alertTypeName) {
		this.alertTypeName = alertTypeName;
	}

	public long getPermPermId() {
		return this.permPermId;
	}

	public void setPermPermId(long permPermId) {
		this.permPermId = permPermId;
	}

	public List<Alert> getAlerts() {
		return this.alerts;
	}

	public void setAlerts(List<Alert> alerts) {
		this.alerts = alerts;
	}

	public Alert addAlert(Alert alert) {
		getAlerts().add(alert);
		alert.setAlertType(this);

		return alert;
	}

	public Alert removeAlert(Alert alert) {
		getAlerts().remove(alert);
		alert.setAlertType(null);

		return alert;
	}

}