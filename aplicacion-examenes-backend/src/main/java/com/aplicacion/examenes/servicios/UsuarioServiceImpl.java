package com.aplicacion.examenes.servicios;

import java.util.Set;

import com.aplicacion.examenes.entidades.Usuario;
import com.aplicacion.examenes.entidades.UsuarioRol;
import com.aplicacion.examenes.excepciones.UsuarioFoundException;
import com.aplicacion.examenes.repositorios.RolRepository;
import com.aplicacion.examenes.repositorios.UsuarioRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UsuarioServiceImpl implements UsuarioService {

	@Autowired
	private UsuarioRepository usuarioRepository;
	
	@Autowired
	private RolRepository rolRepository;

	@Override
	public Usuario guardarUsuario(Usuario usuario, Set<UsuarioRol> usuarioRoles) throws Exception {
		Usuario usuarioLocal = usuarioRepository.findByUsername(usuario.getUsername());
		if(usuarioLocal != null) {
			System.out.println("El usuario ya existe");
			throw new UsuarioFoundException("El usuario ya se encuentra presente");
		}
		else
		{
			for(UsuarioRol usuarioRol: usuarioRoles) {
				rolRepository.save(usuarioRol.getRol());
			}
			usuario.getUsuarioRoles().addAll(usuarioRoles);
			usuarioLocal = usuarioRepository.save(usuario);
		}
		return usuarioLocal;
	}

	@Override
	public Usuario obtenerUsuario(String username) {
		return usuarioRepository.findByUsername(username);
	}

	@Override
	public void eliminarUsuario(Long usuarioId) {
		usuarioRepository.deleteById(usuarioId);
		
	}
}
 