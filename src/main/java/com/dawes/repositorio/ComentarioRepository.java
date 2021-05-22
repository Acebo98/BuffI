package com.dawes.repositorio;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.dawes.modelo.ComentarioVO;
import com.dawes.modelo.RutinaVO;
import com.dawes.modelo.UsuarioVO;

@Repository
public interface ComentarioRepository extends CrudRepository<ComentarioVO, Integer> {
	Iterable<ComentarioVO> findByRutina(RutinaVO rutina);
	Iterable<ComentarioVO> findByUsuario(UsuarioVO usuario);
	
	@Modifying
	@Transactional
	long deleteByRutina(RutinaVO rutina);
	
	@Modifying
	@Transactional
	long deleteByUsuario(UsuarioVO usuario);
}