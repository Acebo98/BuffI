package com.dawes.seguridad;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

@Configuration
@EnableWebSecurity
public class MiSeguridad extends WebSecurityConfigurerAdapter {
	
	@Bean
	public BCryptPasswordEncoder passwordEncoder() {
		return new BCryptPasswordEncoder();
	}

	//Encriptamos la contraseña
	public String encriptar(String contrasena) {
		return passwordEncoder().encode(contrasena);
	}
	
	//Autenficicación
	@Override
	protected void configure(AuthenticationManagerBuilder auth) throws Exception {
		auth.inMemoryAuthentication().withUser("user").password(encriptar("temporal")).roles("USER");
		auth.inMemoryAuthentication().withUser("admin").password(encriptar("temporal")).roles("ADMIN");
	}
	
	//Autorización
	@Override
	protected void configure(HttpSecurity http) throws Exception {
		http.authorizeRequests().antMatchers("/admin/**").hasRole("ADMIN");
		http.authorizeRequests().antMatchers("/user/**").hasAnyRole("USER", "ADMIN");
		http.formLogin();
		//http.formLogin().loginPage("/login");			//Página de logeo
		http.exceptionHandling().accessDeniedPage("/403");		//Página 403 personalizada
		http.logout().logoutSuccessUrl("/buscar-rutinas");		//URL cuando nos desconectamos
		http.csrf().disable();
	}
}