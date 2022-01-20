package co.edu.icesi.dev.sat.alert.endpoint.simulator.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import co.edu.icesi.dev.sat.alert.endpoint.simulator.model.ModelClass;
import co.edu.icesi.dev.sat.alert.endpoint.simulator.repo.ClassRepository;

/**
 * 
 * @author Camilo Castillo
 *	Service with tools to be used when info needed about the ModelClass class
 */
@Service
public class ClassServiceImp {

	private ClassRepository classRepo;

	@Autowired
	public ClassServiceImp(ClassRepository classRepo) {
		this.classRepo=classRepo;
	}
	
	public void createClass(ModelClass obj) {
		classRepo.save(obj);
	}
	
	public ModelClass findById(long modelClassID) {
		return classRepo.findById(modelClassID).get();
	}
	
	public Iterable<ModelClass> findAll(){
		return classRepo.findAll();
	}
	
}
