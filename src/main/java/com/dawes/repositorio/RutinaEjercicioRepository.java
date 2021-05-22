package com.dawes.repositorio;

import javax.transaction.Transactional;

import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.dawes.modelo.RutinaEjercicioVO;
import com.dawes.modelo.RutinaVO;

@Repository
public interface RutinaEjercicioRepository extends CrudRepository<RutinaEjercicioVO, Integer> {
	
	@Modifying
	@Transactional
	long deleteByRutina(RutinaVO rutina);
}