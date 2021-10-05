package co.edu.icesi.dev.sat.alert.entity.entities;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;


/**
 * The persistent class for the ALERT_INSTANCE database table.
 * 
 */
@Entity
@Table(name="ALERT_INSTANCE")
@NamedQuery(name="AlertInstance.findAll", query="SELECT a FROM AlertInstance a")
public class AlertInstance implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@Column(name="ALERT_INSTANCE_ID")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long alertInstanceId;

	@Column(name="ALERT_CREATION_DATE")
	private Date alertCreationDate;

	@Column(name="ALERT_DEACTIVATE")
	private String alertDeactivate;

	@Column(name="ALERT_STATE")
	private String alertState;

	//bi-directional many-to-one association to Action
	@OneToMany(mappedBy="alertInstance")
	private List<Action> actions;

	//bi-directional many-to-one association to Alert
	@ManyToOne
	@JoinColumn(name="ALT_ALERT_ID")
	private Alert alert;

	//bi-directional many-to-one association to AlertPerson
	@OneToMany(mappedBy="alertInstance")
	private List<AlertPerson> alertPersons;

	public AlertInstance() {
	}

	public long getAlertInstanceId() {
		return this.alertInstanceId;
	}

	public void setAlertInstanceId(long alertInstanceId) {
		this.alertInstanceId = alertInstanceId;
	}

	public Date getAlertCreationDate() {
		return this.alertCreationDate;
	}

	public void setAlertCreationDate(Date alertCreationDate) {
		this.alertCreationDate = alertCreationDate;
	}

	public String getAlertDeactivate() {
		return this.alertDeactivate;
	}

	public void setAlertDeactivate(String alertDeactivate) {
		this.alertDeactivate = alertDeactivate;
	}

	public String getAlertState() {
		return this.alertState;
	}

	public void setAlertState(String alertState) {
		this.alertState = alertState;
	}

	public List<Action> getActions() {
		return this.actions;
	}

	public void setActions(List<Action> actions) {
		this.actions = actions;
	}

	public Action addAction(Action action) {
		getActions().add(action);
		action.setAlertInstance(this);

		return action;
	}

	public Action removeAction(Action action) {
		getActions().remove(action);
		action.setAlertInstance(null);

		return action;
	}

	public Alert getAlert() {
		return this.alert;
	}

	public void setAlert(Alert alert) {
		this.alert = alert;
	}

	public List<AlertPerson> getAlertPersons() {
		return this.alertPersons;
	}

	public void setAlertPersons(List<AlertPerson> alertPersons) {
		this.alertPersons = alertPersons;
	}

	public AlertPerson addAlertPerson(AlertPerson alertPerson) {
		getAlertPersons().add(alertPerson);
		alertPerson.setAlertInstance(this);

		return alertPerson;
	}

	public AlertPerson removeAlertPerson(AlertPerson alertPerson) {
		getAlertPersons().remove(alertPerson);
		alertPerson.setAlertInstance(null);

		return alertPerson;
	}

}