package com.dawes.repositorio;

import java.util.Optional;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.dawes.modelo.EtiquetaVO;

@Repository
public interface EtiquetaRepository extends CrudRepository<EtiquetaVO, Integer> {
	Optional<EtiquetaVO> findByNombre(String nombre);
}