package co.edu.icesi.dev.sat.alert.endpoint.simulator.model;

import java.util.ArrayList;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

/**
 * 
 * @author Camilo Castillo
 *	Student class for the simulated endpoint model
 */
@Entity
public class Student {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long id;
	
	private String studName;
	
	private String studCode;
	
	private String document;

	private boolean academicTrial;
	
	private boolean readmitted;
	
	private ArrayList<Long> courses;
	
	public Student() {
		
	}
	
	public ArrayList<Long> getCourses() {
		return courses;
	}

	public void setCourses(ArrayList<Long> courses) {
		this.courses = courses;
	}

	public long getId() {
		return id;
	}
	
	public void setId(long id) {
		this.id = id;
	}
	
	public String getStudName() {
		return studName;
	}
	
	public void setStudName(String studName) {
		this.studName = studName;
	}
	
	public String getStudCode() {
		return studCode;
	}
	
	public void setStudCode(String studCode) {
		this.studCode = studCode;
	}
	
	public boolean isAcademicTrial() {
		return academicTrial;
	}
	
	public void setAcademicTrial(boolean academicTrial) {
		this.academicTrial = academicTrial;
	}

	public boolean isReadmitted() {
		return readmitted;
	}

	public void setReadmitted(boolean readmitted) {
		this.readmitted = readmitted;
	}
	
	public String getDocument() {
		return document;
	}

	public void setDocument(String document) {
		this.document = document;
	}
	
}
