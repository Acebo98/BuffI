package com.dawes.repositorio;

import java.time.LocalDate;
import java.util.Optional;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.dawes.modelo.RutinaVO;
import com.dawes.modelo.UsuarioVO;

@Repository
public interface RutinaRepository extends CrudRepository<RutinaVO, Integer> {
	Iterable<RutinaVO> findByFcreacionBetween(LocalDate f1, LocalDate f2);
	Iterable<RutinaVO> findAllByOrderByFcreacionAsc();		//Ascendiente
	Iterable<RutinaVO> findAllByOrderByFcreacionDesc();		//Descendiente		
	Iterable<RutinaVO> findByUsuario(UsuarioVO usuario);
	Optional<RutinaVO> findByNombre(String nombre);
	
	@Query(value = "SELECT * FROM rutinas WHERE nombre LIKE :nombre", nativeQuery = true)
	Iterable<RutinaVO> findByNombres(String nombre);
}