package model;

import java.util.concurrent.Semaphore;

public class Hallway extends Thread {

	private Semaphore sem = new Semaphore(3);
	
	public synchronized void sitStudent(Student s) {
		try {
			sem.acquire();
			System.out.printf("El estudiante %s está ocupando una silla",s.getStudentName());
			System.out.println("");
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}
	
	/**
	 * @return the sem
	 */
	public Semaphore getSem() {
		return sem;
	}

	/**
	 * @param sem the sem to set
	 */
	public void setSem(Semaphore sem) {
		this.sem = sem;
	}
}
