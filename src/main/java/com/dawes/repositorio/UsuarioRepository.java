package com.dawes.repositorio;

import java.time.LocalDate;
import java.util.Optional;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.dawes.modelo.UsuarioVO;

@Repository
public interface UsuarioRepository extends CrudRepository<UsuarioVO, Integer> {
	
	Iterable<UsuarioVO> findByFcreacionBetween(LocalDate f1, LocalDate f2);
	Iterable<UsuarioVO> findByFnacimientoBetween(LocalDate f1, LocalDate f2);
	Optional<UsuarioVO> findByUsername(String username);
}