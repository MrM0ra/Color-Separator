package main;

import java.util.ArrayList;

import model.Hallway;
import model.Student;
import model.Tutor;

public class Main {

	private ArrayList<Student> students;
	private Tutor tutor;
	private Hallway chairs;
	
	public Main() {
		students= new ArrayList<>();
		tutor = new Tutor();
		chairs = new Hallway();
		students.add(new Student("Jhon"));
		students.add(new Student("Victor"));
		students.add(new Student("Stiward"));
		students.add(new Student("Cossio"));
		students.add(new Student("Eyder"));
		students.add(new Student("Mendoza"));
	}
	
	public static void main(String[] args) {
		Main main = new Main();
		for(Student s : main.getStudents()) {
			System.out.printf("%s is asking for permission",s.getStudentName());
			System.out.println("");
			if(s.lookForHelp(main.getTutor().getSem())==1) {
				//main.getTutor().attendStudents(s);
				main.getTutor().setS(s);
				main.getTutor().setFlag(true);
				main.getTutor().run();
			}else if (s.lookForHelp(main.getTutor().getSem())==-1){
				if(main.getChairs().getSem().availablePermits()==0) {
					s.programming();
				}else {
					main.getChairs().sitStudent(s);
				}
			}
		}
	}
	
	public ArrayList<Student> getStudents() {
		return students;
	}

	public void setStudents(ArrayList<Student> students) {
		this.students = students;
	}

	public Tutor getTutor() {
		return tutor;
	}

	public void setTutor(Tutor tutor) {
		this.tutor = tutor;
	}
	
	public Hallway getChairs() {
		return chairs;
	}

	public void setChairs(Hallway chairs) {
		this.chairs = chairs;
	}
	
	

}
