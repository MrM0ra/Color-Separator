package co.edu.icesi.dev.sat.alert.endpoint.simulator.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

/**
 * 
 * @author Camilo Castillo
 * Report class for the simulated endpoint model
 */
@Entity
public class Report {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long id;
	
	private long studentId;
	
	private boolean hasAlert;
	
	public Report() {
		
	}
	
	public long getId() {
		return id;
	}
	
	public void setId(long id) {
		this.id = id;
	}
	
	public boolean isHasAlert() {
		return hasAlert;
	}
	
	public void setHasAlert(boolean hasAlert) {
		this.hasAlert = hasAlert;
	}

	public long getStudentId() {
		return studentId;
	}

	public void setStudentId(long studentId) {
		this.studentId = studentId;
	}
	
	/*@Override
	public String toString() {
		String result="";
		return result;
	}*/
	
}
