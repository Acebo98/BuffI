package com.dawes.servicio;

import java.time.LocalDate;
import java.util.Optional;

import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;

import com.dawes.modelo.RutinaVO;
import com.dawes.modelo.UsuarioVO;

public interface UsuarioServicio {

	<S extends UsuarioVO> S save(S entity);

	<S extends UsuarioVO> Iterable<S> saveAll(Iterable<S> entities);

	Optional<UsuarioVO> findById(Integer id);

	boolean existsById(Integer id);

	Iterable<UsuarioVO> findAll();

	Iterable<UsuarioVO> findAllById(Iterable<Integer> ids);

	long count();

	void deleteById(Integer id);

	//Borramos un usuario con todos sus datos almacenados
	void delete(UsuarioVO entity);

	void deleteAll(Iterable<? extends UsuarioVO> entities);

	void deleteAll();

	Iterable<UsuarioVO> findByFcreacionBetween(LocalDate f1, LocalDate f2);

	Optional<UsuarioVO> findByUsername(String username);

	Iterable<UsuarioVO> findByFnacimientoBetween(LocalDate f1, LocalDate f2);
	
	Optional<UsuarioVO> findByIdusuario(int idusuario);

	/*
	 * MÉTODO DE INICIO
	 */
	UserDetails loadUserByUsername(String username) throws UsernameNotFoundException;

}