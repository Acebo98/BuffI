package com.dawes.servicioimpl;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.dawes.modelo.RutinaVO;
import com.dawes.repositorio.ComentarioRepository;
import com.dawes.repositorio.RutinaEjercicioRepository;
import com.dawes.repositorio.RutinaRepository;
import com.dawes.servicio.RutinaServicio;

@Service
public class RutinaServicioImpl implements RutinaServicio {

	@Autowired
	RutinaRepository rr;
	
	@Autowired
	ComentarioRepository cs;
	
	@Autowired
	RutinaEjercicioRepository rer;

	@Override
	public <S extends RutinaVO> S save(S entity) {
		return rr.save(entity);
	}

	@Override
	public <S extends RutinaVO> Iterable<S> saveAll(Iterable<S> entities) {
		return rr.saveAll(entities);
	}

	@Override
	public Optional<RutinaVO> findById(Integer id) {
		return rr.findById(id);
	}

	@Override
	public boolean existsById(Integer id) {
		return rr.existsById(id);
	}

	@Override
	public Iterable<RutinaVO> findAll() {
		return rr.findAll();
	}

	@Override
	public Iterable<RutinaVO> findAllById(Iterable<Integer> ids) {
		return rr.findAllById(ids);
	}

	@Override
	public long count() {
		return rr.count();
	}

	@Override
	public void deleteById(Integer id) {
		rr.deleteById(id);
	}

	//Borrado en cascada (borramos comentarios, rutinasejercicios y finalmente la rutina)
	@Override
	public void delete(RutinaVO entity) {
		cs.deleteByRutina(entity);					//Comentarios
		rer.deleteByRutina(entity);					//Rutinasejercicios
		this.deleteById(entity.getIdrutina());		//Finalmente la rutina
	}

	@Override
	public void deleteAll(Iterable<? extends RutinaVO> entities) {
		rr.deleteAll(entities);
	}

	@Override
	public void deleteAll() {
		rr.deleteAll();
	}

	@Override
	public Iterable<RutinaVO> findByFcreacionBetween(LocalDate f1, LocalDate f2) {
		return rr.findByFcreacionBetween(f1, f2);
	}

	@Override
	public Optional<RutinaVO> findByNombre(String nombre) {
		return rr.findByNombre(nombre);
	}

	@Override
	public Iterable<RutinaVO> findByNombres(String nombre) {
		return rr.findByNombres(nombre);
	}

	@Override
	public Iterable<RutinaVO> findAllByOrderByFcreacionAsc() {
		return rr.findAllByOrderByFcreacionAsc();
	}

	@Override
	public Iterable<RutinaVO> findAllByOrderByFcreacionDesc() {
		return rr.findAllByOrderByFcreacionDesc();
	}
}