package co.edu.icesi.dev.sat.alert.endpoint.simulator.model;

import java.util.ArrayList;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

/**
 * 
 * @author Dennys Mosquera
 *	Course claass for the simulated endpoint model
 */
@Entity
public class Course {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long id;
	
	private long classId;
	
	private ArrayList<Long> homeworks;
	
	private int lectures;

	private int pastsLectures;
	
	private ArrayList<Long> students;
	
	public Course(){
		
	}
	
	public ArrayList<Long> getStudents() {
		return students;
	}

	public void setStudents(ArrayList<Long> students) {
		this.students = students;
	}

	public long getId() {
		return id;
	}
	
	public void setId(long id) {
		this.id = id;
	}

	public ArrayList<Long> getHomeworks() {
		return homeworks;
	}

	public void setHomeworks(ArrayList<Long> homeworks) {
		this.homeworks = homeworks;
	}

	public long getClassId() {
		return classId;
	}

	public void setClassId(long classId) {
		this.classId = classId;
	}
	
	public int getLectures() {
		return lectures;
	}

	public void setLectures(int lectures) {
		this.lectures = lectures;
	}

	public int getPastsLectures() {
		return pastsLectures;
	}

	public void setPastsLectures(int pastsLectures) {
		this.pastsLectures = pastsLectures;
	}
	
	
}
