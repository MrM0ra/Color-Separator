package model;

import java.util.concurrent.Semaphore;

public class Tutor extends Thread{

	private Semaphore sem = new Semaphore(1);
	private Student s;
	private boolean flag = true;
	
	public synchronized void attendStudents(Student s) {
		try {
			sem.acquire();
			System.out.printf("El tutor está atendiendo a el estudiante %s",s.getStudentName());
			System.out.println("");
			Tutor.sleep(10000);
			sem.release();
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}
	
	@Override
	public void run() {
		while(flag) {
			try {
				if(this.getS()==null) {
					System.out.println("No hay estudiantes aun");
				}else {
					sem.acquire();
					System.out.printf("El tutor está atendiendo a el estudiante %s",this.getS().getStudentName());
					System.out.println("");
					Tutor.sleep(2000);
					setFlag(false);
					sem.release();
				}
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
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

	public Student getS() {
		return s;
	}

	public void setS(Student s) {
		this.s = s;
	}
	
	/**
	 * @return the flag
	 */
	public boolean isFlag() {
		return flag;
	}

	/**
	 * @param flag the flag to set
	 */
	public void setFlag(boolean flag) {
		this.flag = flag;
	}

}
