package model;

import java.util.concurrent.Semaphore;

public class Student extends Thread implements Runnable{

	private String studentName;
	
	public Student(String studentName) {
		this.studentName=studentName;
	}
	
	public synchronized void programming() {
		try {
			System.out.printf("El estudiante %s se fué a programar",this.getStudentName());
			System.out.println("");
			Student.sleep(10000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}
	
	
	@Override
	public void run() {
		
	}
	
	public synchronized int lookForHelp(Semaphore sem) {
		try {
			if(sem.availablePermits()==0) {
				return -1;
			}else {
				return 1;
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return 0;
	}

	/**
	 * @return the name
	 */
	public String getStudentName() {
		return studentName;
	}

	/**
	 * @param name the name to set
	 */
	public void setStudentName(String studentName) {
		this.studentName = studentName;
	}

	
}
