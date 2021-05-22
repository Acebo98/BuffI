package com.dawes.servicioimpl;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.dawes.modelo.EtiquetaVO;
import com.dawes.repositorio.EtiquetaRepository;
import com.dawes.servicio.EtiquetaServicio;

@Service
public class EtiquetaServicioImpl implements EtiquetaServicio {

	@Autowired
	EtiquetaRepository er;

	@Override
	public <S extends EtiquetaVO> S save(S entity) {
		return er.save(entity);
	}

	@Override
	public <S extends EtiquetaVO> Iterable<S> saveAll(Iterable<S> entities) {
		return er.saveAll(entities);
	}

	@Override
	public Optional<EtiquetaVO> findById(Integer id) {
		return er.findById(id);
	}

	@Override
	public boolean existsById(Integer id) {
		return er.existsById(id);
	}

	@Override
	public Iterable<EtiquetaVO> findAll() {
		return er.findAll();
	}

	@Override
	public Iterable<EtiquetaVO> findAllById(Iterable<Integer> ids) {
		return er.findAllById(ids);
	}

	@Override
	public long count() {
		return er.count();
	}

	@Override
	public void deleteById(Integer id) {
		er.deleteById(id);
	}

	@Override
	public void delete(EtiquetaVO entity) {
		er.delete(entity);
	}

	@Override
	public void deleteAll(Iterable<? extends EtiquetaVO> entities) {
		er.deleteAll(entities);
	}

	@Override
	public void deleteAll() {
		er.deleteAll();
	}

	@Override
	public Optional<EtiquetaVO> findByNombre(String nombre) {
		return er.findByNombre(nombre);
	}
}