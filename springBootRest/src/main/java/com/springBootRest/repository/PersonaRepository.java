package com.springBootRest.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.springBootRest.model.Persona;

public interface PersonaRepository  extends JpaRepository<Persona, Long>{

}
