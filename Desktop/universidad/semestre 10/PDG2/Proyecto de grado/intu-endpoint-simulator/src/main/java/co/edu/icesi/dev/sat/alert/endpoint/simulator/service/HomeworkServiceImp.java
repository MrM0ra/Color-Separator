package co.edu.icesi.dev.sat.alert.endpoint.simulator.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import co.edu.icesi.dev.sat.alert.endpoint.simulator.model.Homework;
import co.edu.icesi.dev.sat.alert.endpoint.simulator.repo.HomeworkRepository;

/**
 * 
 * @author Camilo Castillo
 *	Service with tools to be used when info needed about the Homework class
 */
@Service
public class HomeworkServiceImp {

	private HomeworkRepository hwRepo;

	@Autowired
	public HomeworkServiceImp(HomeworkRepository hwRepo) {
		this.hwRepo = hwRepo;
	}
	
	
	public void createHomework(Homework hw) {
		hwRepo.save(hw);
	}
	
	public Homework findById(long hwId) {
		return hwRepo.findById(hwId).get();
	}
	
	public void editHomework(Homework hw) {
		hwRepo.save(hw);
	}
	
	public Iterable<Homework> findAll(){
		return hwRepo.findAll();
	}
	
	
}
