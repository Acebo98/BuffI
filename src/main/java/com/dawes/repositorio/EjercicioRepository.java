package com.dawes.repositorio;

import java.util.Optional;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.dawes.modelo.EjercicioVO;

@Repository
public interface EjercicioRepository extends CrudRepository<EjercicioVO, Integer> {
	Optional<EjercicioVO> findByNombre(String nombre);
}