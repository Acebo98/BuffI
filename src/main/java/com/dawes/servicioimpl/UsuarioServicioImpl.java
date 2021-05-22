package com.dawes.servicioimpl;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.dawes.modelo.UsuarioVO;
import com.dawes.repositorio.ComentarioRepository;
import com.dawes.repositorio.RutinaRepository;
import com.dawes.repositorio.UsuarioRepository;
import com.dawes.servicio.UsuarioServicio;

@Service
public class UsuarioServicioImpl implements UsuarioServicio {
	
	@Autowired
	UsuarioRepository ur;
	
	@Autowired
	RutinaRepository rr;
	
	@Autowired
	ComentarioRepository cr;

	@Override
	public <S extends UsuarioVO> S save(S entity) {
		return ur.save(entity);
	}

	@Override
	public <S extends UsuarioVO> Iterable<S> saveAll(Iterable<S> entities) {
		return ur.saveAll(entities);
	}

	@Override
	public Optional<UsuarioVO> findById(Integer id) {
		return ur.findById(id);
	}

	@Override
	public boolean existsById(Integer id) {
		return ur.existsById(id);
	}

	@Override
	public Iterable<UsuarioVO> findAll() {
		return ur.findAll();
	}

	@Override
	public Iterable<UsuarioVO> findAllById(Iterable<Integer> ids) {
		return ur.findAllById(ids);
	}

	@Override
	public long count() {
		return ur.count();
	}

	@Override
	public void deleteById(Integer id) {
		ur.deleteById(id);
	}

	//Borramos un usuario con todos sus datos almacenados
	@Override
	public void delete(UsuarioVO entity) {
		cr.deleteByUsuario(entity);									//Borramos sus comentarios guardados
		entity.getRutinas().stream().forEach(r -> rr.delete(r));	//Borramos TODAS sus rutinas
		this.deleteById(entity.getIdusuario());						//Finalmente lo borramos
	}

	@Override
	public void deleteAll(Iterable<? extends UsuarioVO> entities) {
		ur.deleteAll(entities);
	}

	@Override
	public void deleteAll() {
		ur.deleteAll();
	}

	@Override
	public Iterable<UsuarioVO> findByFcreacionBetween(LocalDate f1, LocalDate f2) {
		return ur.findByFcreacionBetween(f1, f2);
	}

	@Override
	public Optional<UsuarioVO> findByNombre(String nombre) {
		return ur.findByNombre(nombre);
	}

	@Override
	public Iterable<UsuarioVO> findByFnacimientoBetween(LocalDate f1, LocalDate f2) {
		return ur.findByFnacimientoBetween(f1, f2);
	}
}