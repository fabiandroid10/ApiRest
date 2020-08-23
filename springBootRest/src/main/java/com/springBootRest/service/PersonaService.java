package com.springBootRest.service;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.springBootRest.DAO.PersonaDao;
import com.springBootRest.model.Persona;

@RestController
@RequestMapping("/api-personas")
public class PersonaService {
	
	@Autowired
	PersonaDao personaDao;
	
	@CrossOrigin(origins ="*")
	@PostMapping("/personas")
	public Persona crearPersona(@Valid @RequestBody Persona per){
		return personaDao.save(per);
	}
	
	@CrossOrigin(origins ="*")
	/* tomar todas las personas*/
	@GetMapping("/personas")
	public List<Persona> getAllPersons(){
		 return personaDao.findAll();
	}
	
	@CrossOrigin(origins ="*")
	/* obtener persona por ID*/
	@GetMapping ("/personas/{id}")
	public ResponseEntity<Persona> getPersonaById(@PathVariable(value="id") Long empid){
		
		Persona ciu= personaDao.finOne(empid);
		if(ciu==null){
			return ResponseEntity.notFound().build();
		}
		return ResponseEntity.ok().body(ciu);
	}
	
	@CrossOrigin(origins ="*")
	/* actualizar persona por id*/
	@PutMapping("/personas/{id}")
	public ResponseEntity<Persona> updatePersona(@PathVariable(value="id") Long empid, @Valid @RequestBody Persona personaDetalle){
		Persona per = personaDao.finOne(empid);
		if(per==null){
			return ResponseEntity.notFound().build();
		}
		per.setNombres(personaDetalle.getNombres());
		per.setApellidos(personaDetalle.getApellidos());
		per.setProcesado(personaDetalle.isProcesado());
		
		Persona actualizarPersona= personaDao.save(per);
		return ResponseEntity.ok().body(per);
		
	}
	
	@DeleteMapping("/persona/{id}")
	public ResponseEntity<Persona> deletePersona(@PathVariable(value="id") Long empid){
		Persona ciu=personaDao.finOne(empid);
		if (ciu==null){
			return ResponseEntity.notFound().build();
		}
		personaDao.delete(ciu);
		return ResponseEntity.ok().build();
	}
	
}
