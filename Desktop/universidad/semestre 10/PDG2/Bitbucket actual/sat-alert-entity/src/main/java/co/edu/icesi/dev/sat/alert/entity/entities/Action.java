package co.edu.icesi.dev.sat.alert.entity.entities;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQuery;
import javax.persistence.Table;


/**
 * The persistent class for the ACTIONS database table.
 * 
 */
@Entity
@Table(name="ACTIONS")
@NamedQuery(name="Action.findAll", query="SELECT a FROM Action a")
public class Action implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@Column(name="ACTION_ID")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long actionId;

	@Column(name="ACTION_COMMENT")
	private String actionComment;

	@Column(name="ACTION_CREATION_DATE")
	private Date actionCreationDate;

	@Column(name="ACTION_DESCRIPTION")
	private String actionDescription;

	@Column(name="APPT_APPOINTMENT_ID")
	private long apptAppointmentId;

	@Column(name="PERS_PERS_ID")
	private long persPersId;

	//bi-directional many-to-one association to AlertInstance
	@ManyToOne
	@JoinColumn(name="ALT_INS_ALERT_INSTANCE_ID")
	private AlertInstance alertInstance;

	public Action() {
	}

	public long getActionId() {
		return this.actionId;
	}

	public void setActionId(long actionId) {
		this.actionId = actionId;
	}

	public String getActionComment() {
		return this.actionComment;
	}

	public void setActionComment(String actionComment) {
		this.actionComment = actionComment;
	}

	public Date getActionCreationDate() {
		return this.actionCreationDate;
	}

	public void setActionCreationDate(Date actionCreationDate) {
		this.actionCreationDate = actionCreationDate;
	}

	public String getActionDescription() {
		return this.actionDescription;
	}

	public void setActionDescription(String actionDescription) {
		this.actionDescription = actionDescription;
	}

	public long getApptAppointmentId() {
		return this.apptAppointmentId;
	}

	public void setApptAppointmentId(long apptAppointmentId) {
		this.apptAppointmentId = apptAppointmentId;
	}

	public long getPersPersId() {
		return this.persPersId;
	}

	public void setPersPersId(long persPersId) {
		this.persPersId = persPersId;
	}

	public AlertInstance getAlertInstance() {
		return this.alertInstance;
	}

	public void setAlertInstance(AlertInstance alertInstance) {
		this.alertInstance = alertInstance;
	}

}