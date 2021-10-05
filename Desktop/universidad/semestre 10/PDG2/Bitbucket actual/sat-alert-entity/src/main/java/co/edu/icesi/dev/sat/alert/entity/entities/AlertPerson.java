package co.edu.icesi.dev.sat.alert.entity.entities;

import java.io.Serializable;
import javax.persistence.*;

/**
 * The persistent class for the ALERT_PERSON database table.
 * 
 */
@Entity
@Table(name="ALERT_PERSON")
@NamedQuery(name="AlertPerson.findAll", query="SELECT a FROM AlertPerson a")
public class AlertPerson implements Serializable {
	private static final long serialVersionUID = 1L;

	@EmbeddedId
	private AlertPersonPK id;

	@Column(name="ALERT_ROLE")
	private String alertRole;

	//bi-directional many-to-one association to AlertInstance
	@ManyToOne
	@JoinColumn(name="ALT_INS_ALERT_INSTANCE_ID", insertable=false, updatable=false)
	private AlertInstance alertInstance;

	public AlertPerson() {
	}

	public AlertPersonPK getId() {
		return this.id;
	}

	public void setId(AlertPersonPK id) {
		this.id = id;
	}

	public String getAlertRole() {
		return this.alertRole;
	}

	public void setAlertRole(String alertRole) {
		this.alertRole = alertRole;
	}

	public AlertInstance getAlertInstance() {
		return this.alertInstance;
	}

	public void setAlertInstance(AlertInstance alertInstance) {
		this.alertInstance = alertInstance;
	}

}