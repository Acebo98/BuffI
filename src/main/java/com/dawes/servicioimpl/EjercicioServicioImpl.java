package com.dawes.servicioimpl;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.dawes.modelo.EjercicioVO;
import com.dawes.repositorio.EjercicioRepository;
import com.dawes.servicio.EjercicioServicio;

@Service
public class EjercicioServicioImpl implements EjercicioServicio {

	@Autowired
	EjercicioRepository er;

	@Override
	public <S extends EjercicioVO> S save(S entity) {
		return er.save(entity);
	}

	@Override
	public <S extends EjercicioVO> Iterable<S> saveAll(Iterable<S> entities) {
		return er.saveAll(entities);
	}

	@Override
	public Optional<EjercicioVO> findById(Integer id) {
		return er.findById(id);
	}

	@Override
	public boolean existsById(Integer id) {
		return er.existsById(id);
	}

	@Override
	public Iterable<EjercicioVO> findAll() {
		return er.findAll();
	}

	@Override
	public Iterable<EjercicioVO> findAllById(Iterable<Integer> ids) {
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
	public void delete(EjercicioVO entity) {
		er.delete(entity);
	}

	@Override
	public void deleteAll(Iterable<? extends EjercicioVO> entities) {
		er.deleteAll(entities);
	}

	@Override
	public void deleteAll() {
		er.deleteAll();
	}
}