package com.dawes.repositorio;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.dawes.modelo.EjercicioVO;

@Repository
public interface EjercicioRepository extends CrudRepository<EjercicioVO, Integer> {
}