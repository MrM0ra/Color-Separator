package co.edu.icesi.dev.sat.alert.endpoint.simulator;

import java.util.ArrayList;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import co.edu.icesi.dev.sat.alert.endpoint.simulator.model.Course;
import co.edu.icesi.dev.sat.alert.endpoint.simulator.model.Homework;
import co.edu.icesi.dev.sat.alert.endpoint.simulator.model.ModelClass;
import co.edu.icesi.dev.sat.alert.endpoint.simulator.model.Student;
import co.edu.icesi.dev.sat.alert.endpoint.simulator.model.StudentCourse;
import co.edu.icesi.dev.sat.alert.endpoint.simulator.model.StudentHomework;
import co.edu.icesi.dev.sat.alert.endpoint.simulator.repo.StudentCourseRepository;
import co.edu.icesi.dev.sat.alert.endpoint.simulator.service.ClassServiceImp;
import co.edu.icesi.dev.sat.alert.endpoint.simulator.service.CourseServiceImp;
import co.edu.icesi.dev.sat.alert.endpoint.simulator.service.HomeworkServiceImp;
//import co.edu.icesi.dev.sat.alert.endpoint.simulator.service.ReportServiceImp;
import co.edu.icesi.dev.sat.alert.endpoint.simulator.service.StudentHomeworkServiceImp;
import co.edu.icesi.dev.sat.alert.endpoint.simulator.service.StudentServiceImp;

@SpringBootApplication
public class EndpointSimulatorApplication {
	
	private ClassServiceImp clsServ;
	private CourseServiceImp crsServ;
	private HomeworkServiceImp hwServ;
	//private ReportServiceImp rptServ;
	private StudentServiceImp stdServ;
	private StudentHomeworkServiceImp stdHwServ;
	private StudentCourseRepository stdCrsRepo;
	
	@Autowired
	public EndpointSimulatorApplication(ClassServiceImp clsServ, CourseServiceImp crsServ,
			HomeworkServiceImp hwServ, /*ReportServiceImp rptServ,*/ StudentServiceImp stdServ,
			StudentHomeworkServiceImp stdHwServ, StudentCourseRepository stdCrsRepo) {
		this.clsServ = clsServ;
		this.crsServ = crsServ;
		this.hwServ = hwServ;
		//this.rptServ = rptServ;
		this.stdServ = stdServ;
		this.stdHwServ = stdHwServ;
		this.stdCrsRepo=stdCrsRepo;
	}

	public static void main(String[] args) {
		SpringApplication.run(EndpointSimulatorApplication.class, args);
	}

	@Bean
	@Transactional
	public CommandLineRunner dummy() {
		return (args) -> {
			ArrayList<Long> crss1 = new ArrayList<>();
			crss1.add((long) 1);
			crss1.add((long) 2);
			crss1.add((long) 3);
			
			ArrayList<Long> crss2 = new ArrayList<>();
			crss2.add((long) 1);
			crss2.add((long) 2);
			crss2.add((long) 3);
			crss2.add((long) 4);
			crss2.add((long) 5);
			
			ArrayList<Long> crss3 = new ArrayList<>();
			crss3.add((long) 1);
			crss3.add((long) 2);
			crss3.add((long) 3);
			crss3.add((long) 4);
			crss3.add((long) 6);
			
			ArrayList<Long> crss4 = new ArrayList<>();
			crss4.add((long) 1);
			crss4.add((long) 3);
			crss4.add((long) 6);
			
			Student std1 = new Student();
			Student std2 = new Student();
			Student std3 = new Student();
			Student std4 = new Student();
			
			std1.setStudName("Victor Esteban Mora Arce");
			std1.setStudCode("A00348661");
			std1.setAcademicTrial(false);
			std1.setReadmitted(true);
			std1.setCourses(crss1);
			std1.setDocument("4508124943810769");
			
			std2.setStudName("Juan Camilo Castillo Quinonez");
			std2.setStudCode("A00340605");
			std2.setAcademicTrial(false);
			std2.setReadmitted(false);
			std2.setCourses(crss2);
			std2.setDocument("3569256396462421");
			
			std3.setStudName("Dennys Valentina Mosquera Maturin");
			std3.setStudCode("A00347874");
			std3.setAcademicTrial(false);
			std3.setReadmitted(false);
			std3.setCourses(crss3);
			std3.setDocument("3574906114607912");
			
			std4.setStudName("Carlos Andreas Quintero Arias");
			std4.setStudCode("A00330628");
			std4.setAcademicTrial(true);
			std4.setReadmitted(false);
			std4.setCourses(crss4);
			std4.setDocument("1234567890");
			
			stdServ.createStudent(std1);
			stdServ.createStudent(std2);
			stdServ.createStudent(std3);
			stdServ.createStudent(std4);
			
			ModelClass mc1 = new ModelClass();
			ModelClass mc2 = new ModelClass();
			ModelClass mc3 = new ModelClass();
			ModelClass mc4 = new ModelClass();
			ModelClass mc5 = new ModelClass();
			
			mc1.setName("Programacion web avanzada");
			mc1.setDescription("Desarrollo frontend a full, mongodb, react, vuejs y nodejs a lo que marca");
			
			mc2.setName("Algoritmos y estructuras de datos");
			mc2.setDescription("Vas a desarrollar la mejor logica que hayas visto en tu vida, man");
			
			mc3.setName("Proyecto de grado 1");
			mc3.setDescription("Comienzan las verdaderas lagrimas");
			
			mc4.setName("Algoritmos y programacion 2");
			mc4.setDescription("Tas bien pinchi muerto nene, bien pinchi muerto");
			
			mc5.setName("Calculo de una variable");
			mc5.setDescription("Metanla con Jazmin ;)");
			
			clsServ.createClass(mc1);
			clsServ.createClass(mc2);
			clsServ.createClass(mc3);
			clsServ.createClass(mc4);
			clsServ.createClass(mc5);
			
			Course crs1 = new Course();
			Course crs2 = new Course();
			Course crs3 = new Course();
			Course crs4 = new Course();
			Course crs5 = new Course();
			Course crs6 = new Course();
			
			ArrayList<Long> stds1 = new ArrayList<>();
			stds1.add((long) 1);
			stds1.add((long) 2);
			stds1.add((long) 3);
			stds1.add((long) 4);
			crs1.setStudents(stds1);
			crs1.setClassId(1);
			crs1.setLectures(32);
			crs1.setPastsLectures(20);
			
			ArrayList<Long> stds2 = new ArrayList<>();
			stds2.add((long) 1);
			stds2.add((long) 2);
			stds2.add((long) 3);
			crs2.setStudents(stds2);
			crs2.setClassId(2);
			crs2.setLectures(16);
			crs2.setPastsLectures(10);
			
			ArrayList<Long> stds3 = new ArrayList<>();
			stds3.add((long) 1);
			stds3.add((long) 2);
			stds3.add((long) 3);
			stds3.add((long) 4);
			crs3.setStudents(stds3);
			crs3.setClassId(3);
			crs3.setLectures(48);
			crs3.setPastsLectures(30);
			
			ArrayList<Long> stds4 = new ArrayList<>();
			stds4.add((long) 2);
			stds4.add((long) 3);
			crs4.setStudents(stds4);
			crs4.setClassId(4);
			crs4.setLectures(16);
			crs4.setPastsLectures(10);
			
			ArrayList<Long> stds5 = new ArrayList<>();
			stds5.add((long) 2);
			crs5.setStudents(stds5);
			crs5.setClassId(5);
			crs5.setLectures(32);
			crs5.setPastsLectures(20);
			
			ArrayList<Long> stds6 = new ArrayList<>();
			stds6.add((long) 3);
			stds6.add((long) 4);
			crs6.setStudents(stds6);
			crs6.setClassId(5);
			crs6.setLectures(32);
			crs6.setPastsLectures(20);
			
			Homework hw1 = new Homework();
			hw1.setCourseId(1);
			hw1.setDescription("Recrear un cv de los ejemplos adjuntos");
			Homework hw2 = new Homework();
			hw2.setCourseId(1);
			hw2.setDescription("Realizar los queries descritos en el pdf adjunto en una base de datos mongo");
			Homework hw3 = new Homework();
			hw3.setCourseId(1);
			hw3.setDescription("Realizar una aplicación tipo foro con el framework de su eleccion y desplegarlo en github pages");
			Homework hw4 = new Homework();
			hw4.setCourseId(2);
			hw4.setDescription("Realizar el tad de la estructura de datos Pila");
			Homework hw5 = new Homework();
			hw5.setCourseId(2);
			hw5.setDescription("Calcule la complejidad temporal del algoritmo que se encuentra en el pdf adjunto");
			Homework hw6 = new Homework();
			hw6.setCourseId(2);
			hw6.setDescription("Balancee el arbol AVL");
			Homework hw7 = new Homework();
			hw7.setCourseId(3);
			hw7.setDescription("Primera entrega del documento");
			Homework hw8 = new Homework();
			hw8.setCourseId(3);
			hw8.setDescription("Segunda entrega del documento");
			Homework hw9 = new Homework();
			hw9.setCourseId(3);
			hw9.setDescription("Tercera entrega del documento");
			Homework hw10 = new Homework();
			hw10.setCourseId(4);
			hw10.setDescription("Desarrolle un ajedrez con las especificaciones del pdf adjunto");
			Homework hw11 = new Homework();
			hw11.setCourseId(4);
			hw11.setDescription("Desarrolle un juego basado en hilos con las especificaciones del pdf adjunto");
			Homework hw12 = new Homework();
			hw12.setCourseId(4);
			hw12.setDescription("Entrega del proyecto");
			Homework hw13 = new Homework();
			hw13.setCourseId(5);
			hw13.setDescription("Taller de calculo de derivadas");
			Homework hw14 = new Homework();
			hw14.setCourseId(5);
			hw14.setDescription("Taller de calculo de integrales");
			Homework hw15 = new Homework();
			hw15.setCourseId(5);
			hw15.setDescription("Parcial Final");
			Homework hw16 = new Homework();
			hw16.setCourseId(5);
			hw16.setDescription("Expo 1");
			Homework hw17 = new Homework();
			hw17.setCourseId(5);
			hw17.setDescription("Expo 2");
			Homework hw18 = new Homework();
			hw18.setCourseId(6);
			hw18.setDescription("Expo Final");
			
			hwServ.createHomework(hw1);
			hwServ.createHomework(hw2);
			hwServ.createHomework(hw3);
			hwServ.createHomework(hw4);
			hwServ.createHomework(hw5);
			hwServ.createHomework(hw6);
			hwServ.createHomework(hw7);
			hwServ.createHomework(hw8);
			hwServ.createHomework(hw9);
			hwServ.createHomework(hw10);
			hwServ.createHomework(hw11);
			hwServ.createHomework(hw12);
			hwServ.createHomework(hw13);
			hwServ.createHomework(hw14);
			hwServ.createHomework(hw15);
			hwServ.createHomework(hw16);
			hwServ.createHomework(hw17);
			hwServ.createHomework(hw18);
			
			ArrayList<Long> hws1 = new ArrayList<>();
			hws1.add(hw1.getId());
			hws1.add(hw2.getId());
			hws1.add(hw3.getId());
			crs1.setHomeworks(hws1);
			
			ArrayList<Long> hws2 = new ArrayList<>();
			hws2.add(hw4.getId());
			hws2.add(hw5.getId());
			hws2.add(hw6.getId());
			crs2.setHomeworks(hws2);
			
			ArrayList<Long> hws3 = new ArrayList<>();
			hws3.add(hw7.getId());
			hws3.add(hw8.getId());
			hws3.add(hw9.getId());
			crs3.setHomeworks(hws3);
			
			ArrayList<Long> hws4 = new ArrayList<>();
			hws4.add(hw10.getId());
			hws4.add(hw11.getId());
			hws4.add(hw12.getId());
			crs4.setHomeworks(hws4);
			
			ArrayList<Long> hws5 = new ArrayList<>();
			hws5.add(hw13.getId());
			hws5.add(hw14.getId());
			hws5.add(hw15.getId());
			crs5.setHomeworks(hws5);
			
			ArrayList<Long> hws6 = new ArrayList<>();
			hws6.add(hw16.getId());
			hws6.add(hw17.getId());
			hws6.add(hw18.getId());
			crs6.setHomeworks(hws6);
			
			crsServ.createCourse(crs1);
			crsServ.createCourse(crs2);
			crsServ.createCourse(crs3);
			crsServ.createCourse(crs4);
			crsServ.createCourse(crs5);
			crsServ.createCourse(crs6);
			
			StudentCourse stdCrs1 = new StudentCourse(1,1,12);
			StudentCourse stdCrs2 = new StudentCourse(1,2,19);
			StudentCourse stdCrs3 = new StudentCourse(1,3,3);
			StudentCourse stdCrs4 = new StudentCourse(1,4,13);
			
			StudentCourse stdCrs5 = new StudentCourse(2,1,10);
			StudentCourse stdCrs6 = new StudentCourse(2,2,3);
			StudentCourse stdCrs7 = new StudentCourse(2,3,2);
			
			StudentCourse stdCrs8 = new StudentCourse(3,1,21);
			StudentCourse stdCrs9 = new StudentCourse(3,2,18);
			StudentCourse stdCrs10 = new StudentCourse(3,3,5);
			StudentCourse stdCrs11 = new StudentCourse(3,4,22);
			
			StudentCourse stdCrs12 = new StudentCourse(4,2,3);
			StudentCourse stdCrs13 = new StudentCourse(4,3,2);
			
			StudentCourse stdCrs14 = new StudentCourse(5,2,20);
			
			StudentCourse stdCrs15 = new StudentCourse(6,3,15);
			StudentCourse stdCrs16 = new StudentCourse(6,4,20);
			
			stdCrsRepo.save(stdCrs1);
			stdCrsRepo.save(stdCrs2);
			stdCrsRepo.save(stdCrs3);
			stdCrsRepo.save(stdCrs4);
			stdCrsRepo.save(stdCrs5);
			stdCrsRepo.save(stdCrs6);
			stdCrsRepo.save(stdCrs7);
			stdCrsRepo.save(stdCrs8);
			stdCrsRepo.save(stdCrs9);
			stdCrsRepo.save(stdCrs10);
			stdCrsRepo.save(stdCrs11);
			stdCrsRepo.save(stdCrs12);
			stdCrsRepo.save(stdCrs13);
			stdCrsRepo.save(stdCrs14);
			stdCrsRepo.save(stdCrs15);
			stdCrsRepo.save(stdCrs16);			
			
			for(int i=0;i<crsServ.findAll().size();i++) {
				for(int j=0; j<crsServ.findAll().get(i).getStudents().size();j++) {
					for(int k=0;k<crsServ.findAll().get(i).getHomeworks().size();k++) {
						StudentHomework hws = new StudentHomework();
						hws.setStudentId(stdServ.findById(crsServ.findAll().get(i).getStudents().get(j)).getId());
						hws.setHomeworkId(hwServ.findById(crsServ.findAll().get(i).getHomeworks().get(k)).getId());
						stdHwServ.createStudentHomework(hws);
					}
				}
			}
			
			System.out.println("***********Estudiantes***********");
			for(Student s : stdServ.findAll()) {
				System.out.println(s.getStudName()+"::"+s.getId());
			}
			
			System.out.println("***********Clases***********");
			for(ModelClass mc : clsServ.findAll()) {
				System.out.println(mc.getName()+"::"+mc.getId());
			}
			
			System.out.println("***********Cursos***********");
			for(Course c : crsServ.findAll()) {
				System.out.println(c.getClassId()+"::"+c.getId());
			}
			
			System.out.println("***********Tareas***********");
			for(Homework hw : hwServ.findAll()) {
				System.out.println(hw.getDescription()+"::"+hw.getId());
			}
			
			System.out.println("***********Estudiante-Tarea***********");
			for(StudentHomework shw : stdHwServ.findAll()) {
				System.out.println(shw.getStudentId()+"::"+shw.getHomeworkId());
			}
			
			System.out.println("***********Estudiantes por curso***********");
			for(Course c : crsServ.findAll()) {
				for(long l : c.getStudents()) {
					System.out.println(clsServ.findById(c.getClassId()).getName()+"::"+stdServ.findById(l).getStudName());
				}
			}
		};
	}
	
}
