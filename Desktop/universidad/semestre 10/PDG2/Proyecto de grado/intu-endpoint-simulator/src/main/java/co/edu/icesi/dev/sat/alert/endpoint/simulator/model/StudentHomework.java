package co.edu.icesi.dev.sat.alert.endpoint.simulator.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

/**
 * 
 * @author Dennys Mosquera
 * The StudentHomework class for the simulated endpoint model
 * represents a many to many relation between students and homeworks
 */
@Entity
public class StudentHomework {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long id;
	
	private long studentId;
	
	private long homeworkId;
	
	/**
	 * 0 = homework not delivered
	 */
	private double grade;
	
	public StudentHomework() {
		
	}

	public long getStudentId() {
		return studentId;
	}

	public void setStudentId(long studentId) {
		this.studentId = studentId;
	}

	public long getHomeworkId() {
		return homeworkId;
	}

	public void setHomeworkId(long homeworkId) {
		this.homeworkId = homeworkId;
	}

	public double getGrade() {
		return grade;
	}

	public void setGrade(double grade) {
		this.grade = grade;
	}
	
	
	
}
