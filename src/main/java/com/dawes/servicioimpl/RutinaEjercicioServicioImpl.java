package com.dawes.servicioimpl;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.dawes.modelo.RutinaEjercicioVO;
import com.dawes.modelo.RutinaVO;
import com.dawes.repositorio.RutinaEjercicioRepository;
import com.dawes.servicio.RutinaEjercicioServicio;

@Service
public class RutinaEjercicioServicioImpl implements RutinaEjercicioServicio {

	@Autowired
	RutinaEjercicioRepository rer;

	@Override
	public <S extends RutinaEjercicioVO> S save(S entity) {
		return rer.save(entity);
	}

	@Override
	public <S extends RutinaEjercicioVO> Iterable<S> saveAll(Iterable<S> entities) {
		return rer.saveAll(entities);
	}

	@Override
	public Optional<RutinaEjercicioVO> findById(Integer id) {
		return rer.findById(id);
	}

	@Override
	public boolean existsById(Integer id) {
		return rer.existsById(id);
	}

	@Override
	public Iterable<RutinaEjercicioVO> findAll() {
		return rer.findAll();
	}

	@Override
	public Iterable<RutinaEjercicioVO> findAllById(Iterable<Integer> ids) {
		return rer.findAllById(ids);
	}

	@Override
	public long count() {
		return rer.count();
	}

	@Override
	public void deleteById(Integer id) {
		rer.deleteById(id);
	}

	@Override
	public void delete(RutinaEjercicioVO entity) {
		rer.delete(entity);
	}

	@Override
	public void deleteAll(Iterable<? extends RutinaEjercicioVO> entities) {
		rer.deleteAll(entities);
	}

	@Override
	public void deleteAll() {
		rer.deleteAll();
	}

	@Override
	public long deleteByRutina(RutinaVO rutina) {
		return rer.deleteByRutina(rutina);
	}
}