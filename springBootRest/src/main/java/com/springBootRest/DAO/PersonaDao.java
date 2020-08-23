package com.springBootRest.DAO;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.springBootRest.model.Persona;
import com.springBootRest.repository.PersonaRepository;

@Service
public class PersonaDao {
	
	@Autowired
	PersonaRepository personaRepository;
	/* guardar Persona */
	public Persona save(Persona per){
		return  personaRepository.save(per);
	}
	/* Buscar Persona */
	public List<Persona> findAll(){
		return personaRepository.findAll();
	}
	/* Buscar Persona por ID */
	public Persona finOne(Long empid){
		return personaRepository.findOne(empid);
	}
	/* borrar Persona por ID*/
	
	public void delete(Persona emp){
		personaRepository.delete(emp);
	}
}
