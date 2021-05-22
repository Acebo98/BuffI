package com.dawes;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import java.time.LocalDate;

import javax.persistence.Persistence;

import org.junit.BeforeClass;
import org.junit.FixMethodOrder;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.junit.runners.MethodSorters;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.dawes.modelo.ComentarioVO;
import com.dawes.modelo.EjercicioVO;
import com.dawes.modelo.EtiquetaVO;
import com.dawes.modelo.RolVO;
import com.dawes.modelo.RutinaEjercicioVO;
import com.dawes.modelo.RutinaVO;
import com.dawes.modelo.UsuarioVO;
import com.dawes.servicio.ComentarioServicio;
import com.dawes.servicio.EjercicioServicio;
import com.dawes.servicio.EtiquetaServicio;
import com.dawes.servicio.RolServicio;
import com.dawes.servicio.RutinaEjercicioServicio;
import com.dawes.servicio.RutinaServicio;
import com.dawes.servicio.UsuarioServicio;

@RunWith(SpringJUnit4ClassRunner.class)
@SpringBootTest
@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class BuffyTests {
	
	@Autowired
	ComentarioServicio cs;
	
	@Autowired
	EjercicioServicio es;
	
	@Autowired
	EtiquetaServicio ets;
	
	@Autowired
	RutinaEjercicioServicio res;
	
	@Autowired
	RutinaServicio rs;
	
	@Autowired
	UsuarioServicio us;
	
	@Autowired
	RolServicio rls;
	
	@BeforeClass
	public static void crearEsquema() {
		Persistence.generateSchema("jpa", null);
	}

	//Metemos datos de prueba
	@Test
	public void t1() {
		
		//Roles
		RolVO rol01 = new RolVO(0, null, "admin");
		RolVO rol02 = new RolVO(0, null, "user");
		
		rls.save(rol01);
		rls.save(rol02);
		//--------------------
		
		//Usuarios
		UsuarioVO usuario01 = new UsuarioVO(0, "Sergio Acebal", "contra1234", "sergio98.am30@gmail.com", LocalDate.now(), 
				LocalDate.of(1998, 7, 7), "Gijón", null, rol01);
		UsuarioVO usuario02 = new UsuarioVO(0, "Rosa Menéndez", "contra5678", "rosina_cangas@gmail.com", LocalDate.now(), 
				LocalDate.of(1965, 5, 5), "Gijón", null, rol02);
		UsuarioVO usuario03 = new UsuarioVO(0, "Javier Maroto", "soyjavi96", "javieldel96.gmail.com", LocalDate.now(), 
				LocalDate.of(1996, 12, 21), "Oviedo", null, rol02);
			
		us.save(usuario01);
		us.save(usuario02);
		us.save(usuario03);
		//--------------------
		
		//Etiquetas
		EtiquetaVO etiqueta01 = new EtiquetaVO("Tren superior", null);
		EtiquetaVO etiqueta02 = new EtiquetaVO("Tren inferior", null);
		
		ets.save(etiqueta01);
		ets.save(etiqueta02);
		//--------------------
		
		//Rutinas
		RutinaVO rutina01 = new RutinaVO(0, "Rutina para brazos. Lunes y Viernes. Descando de 45' entre serie, 1 minuto entre ejercicio.", 
				LocalDate.now(), "Rutina para brazos de Sergio", ets.findById(1).get(), us.findById(1).get(), null, null);
		RutinaVO rutina02 = new RutinaVO(0, "Rutina para las piernas. Sábado y Domingo. Descando de 45' entre serie, 1 minuto entre ejercicio.", 
				LocalDate.now(), "Rutina para las piernas", ets.findById(2).get(), us.findById(2).get(), null, null);
		
		rs.save(rutina01);
		rs.save(rutina02);
		//--------------------
			
		//Comentarios
		ComentarioVO comentario01 = new ComentarioVO(0, "La verdad, que está chula la rutina :D", rs.findById(1).get(), us.findById(2).get());
		ComentarioVO comentario02 = new ComentarioVO(0, "Podría estar mejor...", rs.findById(2).get(), us.findById(1).get());
		ComentarioVO comentario03 = new ComentarioVO(0, "Muy chulo. Gracias!", rs.findById(2).get(), us.findById(3).get());
		
		cs.save(comentario01);
		cs.save(comentario02);
		cs.save(comentario03);
		//--------------------
		
		assertTrue(true);
	}
	
	//Metemos ejercicios en las rutinas
	@Test
	public void t2() {
		
		//Ejercicios
		EjercicioVO ejercicio01 = new EjercicioVO(0, "Mancuernas", "Mancuernas", null, null);
		EjercicioVO ejercicio02 = new EjercicioVO(0, "Jaula", "Jaula para hacer sentadillas con barra", null, null);
		EjercicioVO ejercicio03 = new EjercicioVO(0, "Banco plano", "Banco plano para pecho u otras funciones", null, null);
		EjercicioVO ejercicio04 = new EjercicioVO(0, "Banco plano inclinado", "Banco plano para pecho u otras funciones", null, null);
		EjercicioVO ejercicio05 = new EjercicioVO(0, "Press de hombro", "Trapecio, deltoides anterior, posterior y medio", null, null);
		EjercicioVO ejercicio06 = new EjercicioVO(0, "Extensión de pierna", "Cuádriceps", null, null);
		
		es.save(ejercicio01);
		es.save(ejercicio02);
		es.save(ejercicio03);
		es.save(ejercicio04);
		es.save(ejercicio05);
		es.save(ejercicio06);
		//--------------------
		
		//Metemos los ejercicios a las rutinas
		RutinaEjercicioVO rutejer01 = new RutinaEjercicioVO(0, es.findById(3).get(), rs.findById(1).get(), "4x12");
		RutinaEjercicioVO rutejer02 = new RutinaEjercicioVO(0, es.findById(1).get(), rs.findById(1).get(), "4x12");
		RutinaEjercicioVO rutejer03 = new RutinaEjercicioVO(0, es.findById(5).get(), rs.findById(1).get(), "3x15");
		
		RutinaEjercicioVO rutejer04 = new RutinaEjercicioVO(0, es.findById(2).get(), rs.findById(2).get(), "4x12");
		RutinaEjercicioVO rutejer05 = new RutinaEjercicioVO(0, es.findById(6).get(), rs.findById(2).get(), "3x12");
		
		res.save(rutejer01);
		res.save(rutejer02);
		res.save(rutejer03);
		res.save(rutejer04);
		res.save(rutejer05);
		//--------------------
			
		assertTrue(true);
	}
	
	//Borramos una rutina con todos sus ejercicios y comentarios
	@Test
	public void t3() {	
		RutinaVO rutina = rs.findById(1).get();
		rs.delete(rutina);
		
		assertFalse(rs.findById(1).isPresent());
	}
	
	//Borramos un usuario con todos sus datos
	@Test
	public void t4() {
		UsuarioVO usuario = us.findById(1).get();
		us.delete(usuario);
		
		assertFalse(rs.findById(1).isPresent());
	}
}