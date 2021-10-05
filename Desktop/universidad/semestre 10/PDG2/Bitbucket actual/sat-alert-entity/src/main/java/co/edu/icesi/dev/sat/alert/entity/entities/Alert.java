package co.edu.icesi.dev.sat.alert.entity.entities;

import java.io.Serializable;
import javax.persistence.*;
import java.util.List;


/**
 * The persistent class for the ALERT database table.
 * 
 */
@Entity
@NamedQuery(name="Alert.findAll", query="SELECT a FROM Alert a")
public class Alert implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@Column(name="ALERT_ID")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long alertId;

	@Column(name="ALERT_DESCRIPTION")
	private String alertDescription;

	//bi-directional many-to-one association to AlertRiskLevel
	@ManyToOne
	@JoinColumn(name="ALT_RSK_LVL_ALERT_RSK_LEVEL_ID")
	private AlertRiskLevel alertRiskLevel;

	//bi-directional many-to-one association to AlertType
	@ManyToOne
	@JoinColumn(name="ALT_TYPE_ALERT_TYPE_ID")
	private AlertType alertType;

	//bi-directional many-to-one association to AlertInstance
	@OneToMany(mappedBy="alert")
	private List<AlertInstance> alertInstances;

	public Alert() {
	}

	public long getAlertId() {
		return this.alertId;
	}

	public void setAlertId(long alertId) {
		this.alertId = alertId;
	}

	public String getAlertDescription() {
		return this.alertDescription;
	}

	public void setAlertDescription(String alertDescription) {
		this.alertDescription = alertDescription;
	}

	public AlertRiskLevel getAlertRiskLevel() {
		return this.alertRiskLevel;
	}

	public void setAlertRiskLevel(AlertRiskLevel alertRiskLevel) {
		this.alertRiskLevel = alertRiskLevel;
	}

	public AlertType getAlertType() {
		return this.alertType;
	}

	public void setAlertType(AlertType alertType) {
		this.alertType = alertType;
	}

	public List<AlertInstance> getAlertInstances() {
		return this.alertInstances;
	}

	public void setAlertInstances(List<AlertInstance> alertInstances) {
		this.alertInstances = alertInstances;
	}

	public AlertInstance addAlertInstance(AlertInstance alertInstance) {
		getAlertInstances().add(alertInstance);
		alertInstance.setAlert(this);

		return alertInstance;
	}

	public AlertInstance removeAlertInstance(AlertInstance alertInstance) {
		getAlertInstances().remove(alertInstance);
		alertInstance.setAlert(null);

		return alertInstance;
	}

}