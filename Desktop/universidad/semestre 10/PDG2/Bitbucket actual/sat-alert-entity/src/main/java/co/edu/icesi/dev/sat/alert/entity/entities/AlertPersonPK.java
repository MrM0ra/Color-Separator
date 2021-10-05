package co.edu.icesi.dev.sat.alert.entity.entities;

import java.io.Serializable;
import javax.persistence.*;

/**
 * The primary key class for the ALERT_PERSON database table.
 * 
 */
@Embeddable
public class AlertPersonPK implements Serializable {
	//default serial version id, required for serializable classes.
	private static final long serialVersionUID = 1L;

	@Column(name="ALERT_PERSON_ID")
	private long alertPersonId;

	@Column(name="PERS_PERS_ID", insertable=false, updatable=false)
	private long persPersId;

	@Column(name="ALT_INS_ALERT_INSTANCE_ID", insertable=false, updatable=false)
	private long altInsAlertInstanceId;

	public AlertPersonPK() {
	}
	public long getAlertPersonId() {
		return this.alertPersonId;
	}
	public void setAlertPersonId(long alertPersonId) {
		this.alertPersonId = alertPersonId;
	}
	public long getPersPersId() {
		return this.persPersId;
	}
	public void setPersPersId(long persPersId) {
		this.persPersId = persPersId;
	}
	public long getAltInsAlertInstanceId() {
		return this.altInsAlertInstanceId;
	}
	public void setAltInsAlertInstanceId(long altInsAlertInstanceId) {
		this.altInsAlertInstanceId = altInsAlertInstanceId;
	}

	public boolean equals(Object other) {
		if (this == other) {
			return true;
		}
		if (!(other instanceof AlertPersonPK)) {
			return false;
		}
		AlertPersonPK castOther = (AlertPersonPK)other;
		return 
			(this.alertPersonId == castOther.alertPersonId)
			&& (this.persPersId == castOther.persPersId)
			&& (this.altInsAlertInstanceId == castOther.altInsAlertInstanceId);
	}

	public int hashCode() {
		final int prime = 31;
		int hash = 17;
		hash = hash * prime + ((int) (this.alertPersonId ^ (this.alertPersonId >>> 32)));
		hash = hash * prime + ((int) (this.persPersId ^ (this.persPersId >>> 32)));
		hash = hash * prime + ((int) (this.altInsAlertInstanceId ^ (this.altInsAlertInstanceId >>> 32)));
		
		return hash;
	}
}