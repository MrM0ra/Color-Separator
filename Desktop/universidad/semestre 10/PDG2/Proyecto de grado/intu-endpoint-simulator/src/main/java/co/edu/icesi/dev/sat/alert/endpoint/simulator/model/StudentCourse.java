package co.edu.icesi.dev.sat.alert.endpoint.simulator.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

/**
 * 
 * @author Dennys Mosquera
 * The StudentCourse class for the simulated endpoint model
 * represents a many to many relation between students and courses
 *
 */
@Entity
public class StudentCourse {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long id;
	
	private long courseId;
	
	private long studentId;
	
	//Times the student have assisted to the specific course
	private int assists;

	public StudentCourse() {
		
	}
	
	public StudentCourse(long courseId, long studentId, int assists) {
		this.courseId = courseId;
		this.studentId = studentId;
		this.assists = assists;
	}
	
	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public long getCourseId() {
		return courseId;
	}

	public void setCourseId(long courseId) {
		this.courseId = courseId;
	}

	public long getStudentId() {
		return studentId;
	}

	public void setStudentId(long studentId) {
		this.studentId = studentId;
	}

	public int getAssists() {
		return assists;
	}

	public void setAssists(int assists) {
		this.assists = assists;
	}
	
	@Override
	public String toString() {
		return String.format("{ id: %d, StudentId: %s, CourseId: %d, Assists:%d }",
				this.getId(),this.getStudentId(),this.getCourseId(),this.getAssists());
	}
	
	
}
