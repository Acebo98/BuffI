package com.dawes.servicioimpl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.dawes.modelo.ComentarioVO;
import com.dawes.modelo.RutinaVO;
import com.dawes.modelo.UsuarioVO;
import com.dawes.repositorio.ComentarioRepository;
import com.dawes.servicio.ComentarioServicio;

@Service
public class ComentarioServicioImpl implements ComentarioServicio {

	@Autowired
	ComentarioRepository cr;

	@Override
	public <S extends ComentarioVO> S save(S entity) {
		return cr.save(entity);
	}

	@Override
	public <S extends ComentarioVO> Iterable<S> saveAll(Iterable<S> entities) {
		return cr.saveAll(entities);
	}

	@Override
	public Optional<ComentarioVO> findById(Integer id) {
		return cr.findById(id);
	}

	@Override
	public boolean existsById(Integer id) {
		return cr.existsById(id);
	}

	@Override
	public Iterable<ComentarioVO> findAll() {
		return cr.findAll();
	}

	@Override
	public Iterable<ComentarioVO> findAllById(Iterable<Integer> ids) {
		return cr.findAllById(ids);
	}

	@Override
	public long count() {
		return cr.count();
	}

	@Override
	public void deleteById(Integer id) {
		cr.deleteById(id);
	}

	@Override
	public void delete(ComentarioVO entity) {
		cr.delete(entity);
	}

	@Override
	public void deleteAll(Iterable<? extends ComentarioVO> entities) {
		cr.deleteAll(entities);
	}

	@Override
	public void deleteAll() {
		cr.deleteAll();
	}

	@Override
	public Iterable<ComentarioVO> findByRutina(RutinaVO rutina) {
		return cr.findByRutina(rutina);
	}

	@Override
	public Iterable<ComentarioVO> findByUsuario(UsuarioVO usuario) {
		return cr.findByUsuario(usuario);
	}

	@Override
	public long deleteByRutina(RutinaVO rutina) {
		return cr.deleteByRutina(rutina);
	}

	@Override
	public long deleteByUsuario(UsuarioVO usuario) {
		return cr.deleteByUsuario(usuario);
	}

	@Override
	public Iterable<ComentarioVO> findAllByOrderByFcreacionDesc() {
		return cr.findAllByOrderByFcreacionDesc();
	}
}