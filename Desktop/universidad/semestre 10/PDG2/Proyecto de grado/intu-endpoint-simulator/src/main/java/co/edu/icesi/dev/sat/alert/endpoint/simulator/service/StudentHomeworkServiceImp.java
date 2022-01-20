package co.edu.icesi.dev.sat.alert.endpoint.simulator.service;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import co.edu.icesi.dev.sat.alert.endpoint.simulator.model.PairV;
import co.edu.icesi.dev.sat.alert.endpoint.simulator.model.StudentHomework;
import co.edu.icesi.dev.sat.alert.endpoint.simulator.repo.StudentCourseRepository;
import co.edu.icesi.dev.sat.alert.endpoint.simulator.repo.StudentHomeworkRepository;

/**
 * 
 * @author Camilo Castillo
 *	Service with tools to be used when info needed about the StudentHomework class
 */
@Service
public class StudentHomeworkServiceImp {
	
	private StudentHomeworkRepository stHwRepo;
	private CourseServiceImp crsServ;
	private StudentCourseRepository stdCrsRepo;
	private StudentServiceImp stdSrv;

	@Autowired
	public StudentHomeworkServiceImp(StudentHomeworkRepository stHwRepo, StudentCourseRepository stdCrsRepo, 
			StudentServiceImp stdSrv, CourseServiceImp crsServ) {
		this.stHwRepo = stHwRepo;
		this.stdSrv=stdSrv;
		this.stdCrsRepo=stdCrsRepo;
		this.crsServ=crsServ;
	}
	
	public void createStudentHomework(StudentHomework hw) {
		stHwRepo.save(hw);
	}
	
	public StudentHomework findById(long stdId) {
		return stHwRepo.findById(stdId).get();
	}
	
	public void editStudentHomework(StudentHomework hw) {
		stHwRepo.save(hw);
	}
	
	public List<StudentHomework> findAll(){
		return stHwRepo.findAll();
	}
	
	/**
	 * Finds the students that have failed to attend to classes given a comparator and a assistency percentage 
	 * @param assistsPercentage the assistency percentage to be commpared
	 * @param comparator *lt* for less than or *gt* for greater than the given assistancy percentage
	 * @return a list with the documents of the students that match the condition stablished by the comparator and assistsPercentage   
	 */
	public List<String> findByAbsences(String comparator, double assistsPercentage){
		switch(comparator) {
			case "gt":
				List<String> response = new ArrayList<>();
				stdCrsRepo.findAll().parallelStream().forEach( stdCr ->	{
					double res = 1 - (double) stdCr.getAssists() / crsServ.findById(stdCr.getCourseId()).getPastsLectures();
					System.out.printf("Con %s asistencias a %s clases dictadas, el porcentaje de faltas es de %s\n", stdCr.getAssists(), crsServ.findById(stdCr.getCourseId()).getPastsLectures(), res);
					System.out.println(res);
				});
				var found = stdCrsRepo.findAll().parallelStream().filter(stdCr -> (1 - (double) stdCr.getAssists() / crsServ.findById(stdCr.getCourseId()).getPastsLectures()) >= assistsPercentage).collect(Collectors.toList());
				
				found.stream().forEach(f -> response.add(stdSrv.findById(f.getStudentId()).getDocument()));
				return response;
			case "lt":
				List<String> response1 = new ArrayList<>();
				stdCrsRepo.findAll().parallelStream().forEach( stdCr ->	{
					double res = 1 - (double) stdCr.getAssists() / crsServ.findById(stdCr.getCourseId()).getPastsLectures();
					System.out.printf("Con %s asistencias a %s clases dictadas, el porcentaje de faltas es de %s\n", stdCr.getAssists(), crsServ.findById(stdCr.getCourseId()).getPastsLectures(), res);
					System.out.println(res);
				});
				var found1 = stdCrsRepo.findAll().parallelStream().filter(stdCr -> (1 - (double) stdCr.getAssists() / crsServ.findById(stdCr.getCourseId()).getPastsLectures()) <= assistsPercentage).collect(Collectors.toList());
				
				found1.stream().forEach(f -> response1.add(stdSrv.findById(f.getStudentId()).getDocument()));
				return response1;
			default:
				break;
		}
		return null;
	}
	
	/**
	 * Finds the students that have assignments with more than or less than, depending on the comparator value, grade. 
	 * @param grade grade under which assignments is considered missed
	 * @param missedAssignments threshold for the missed assignments 
	 * @param comparator *lt* for less than or *gt* for greater than the given missedAssignments
	 * @return a list with the documents of the students that match the condition stablished by the comparator, grade and 
	 * missedAssignments
	 */
	public List<String> findByGrade(String comparator, double grade, int missedAssignments){
		List<String> result = new ArrayList<>();
		List<PairV<Long, Integer>> stds = new ArrayList<>();
		switch(comparator) {
			case "lt":
				for (int i=0;i<this.findAll().size();i++) {
					if(stds.isEmpty()) {
						if(this.findAll().get(i).getGrade()<=grade) {
							stds.add(new PairV<Long, Integer>(this.findAll().get(i).getStudentId(), 0));
						}						
					}else {
						int pos=0;
						boolean flag=false;
						for(int j=0;j<stds.size();j++) {
							if(stds.get(j).getKey()==this.findAll().get(i).getStudentId()) {
								if(this.findAll().get(i).getGrade()<=grade) {
									pos = j;
									flag=true;
								}
							}
						}
						if(flag) {
							stds.get(pos).setValue(stds.get(pos).getValue()+1);
						}else {
							if(this.findAll().get(i).getGrade()<=grade) {
								stds.add(new PairV<Long, Integer>(this.findAll().get(i).getStudentId(), 0));
							}
						}
					}
				}
				for(PairV<Long, Integer> pv : stds) {
					if(pv.getValue() >= missedAssignments) {
						result.add(stdSrv.findById(pv.getKey()).getDocument());
					}
				}
				return result;
			case "gt":
				for (int i=0;i<this.findAll().size();i++) {
					if(stds.isEmpty()) {
						if(this.findAll().get(i).getGrade()>=grade) {
							stds.add(new PairV<Long, Integer>(this.findAll().get(i).getStudentId(), 0));
						}						
					}else {
						int pos=0;
						boolean flag=false;
						for(int j=0;j<stds.size();j++) {
							if(stds.get(j).getKey()==this.findAll().get(i).getStudentId()) {
								if(this.findAll().get(i).getGrade()>=grade) {
									pos = j;
									flag=true;
								}
							}
						}
						if(flag) {
							stds.get(pos).setValue(stds.get(pos).getValue()+1);
						}else {
							if(this.findAll().get(i).getGrade()>=grade) {
								stds.add(new PairV<Long, Integer>(this.findAll().get(i).getStudentId(), 0));
							}
						}
					}
				}
				for(PairV<Long, Integer> pv : stds) {
					if(pv.getValue() >= missedAssignments) {
						result.add(stdSrv.findById(pv.getKey()).getDocument());
					}
				}
				return result;
			default:
				break;
		}
		return null;
	}
	
	
	
	
}
