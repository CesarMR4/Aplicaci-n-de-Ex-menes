package com.aplicacion.examenes;

import java.util.HashSet;
import java.util.Set;

import com.aplicacion.examenes.entidades.Rol;
import com.aplicacion.examenes.entidades.Usuario;
import com.aplicacion.examenes.entidades.UsuarioRol;
import com.aplicacion.examenes.excepciones.UsuarioFoundException;
import com.aplicacion.examenes.servicios.UsuarioService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

@SpringBootApplication
public class AplicacionExamenesBackendApplication implements CommandLineRunner {

	@Autowired
	private UsuarioService usuarioService;
	
	@Autowired
	private BCryptPasswordEncoder bCryptPasswordEncoder;
	
	
	public static void main(String[] args) {
		SpringApplication.run(AplicacionExamenesBackendApplication.class, args);
	}


	@Override
	public void run(String... args) throws Exception {
		/*try {
			
		 
		 Usuario usuario = new Usuario();
		 
		 usuario.setNombre("Cesar");
		 usuario.setApellido("Martinez");
		 usuario.setUsername("Rambo");
		 usuario.setPassword(bCryptPasswordEncoder.encode("12345"));
		 usuario.setEmail("cesar@gmail.com");
		 usuario.setTelefono("980994412");
		 usuario.setPerfil("foto.png");
		 
		 Rol rol = new Rol();
		 rol.setId(1L);
		 rol.setNombre("ADMIN");
		 
		Set<UsuarioRol> usuarioRoles = new HashSet<>();
		UsuarioRol usuarioRol = new UsuarioRol();
		usuarioRol.setRol(rol);
		usuarioRol.setUsuario(usuario);
		usuarioRoles.add(usuarioRol);
		
		Usuario usuarioGuardado = usuarioService.guardarUsuario(usuario, usuarioRoles);
		System.out.println(usuarioGuardado.getUsername());
		}catch(UsuarioFoundException exception) {
			exception.printStackTrace();
		}*/
	}

}
