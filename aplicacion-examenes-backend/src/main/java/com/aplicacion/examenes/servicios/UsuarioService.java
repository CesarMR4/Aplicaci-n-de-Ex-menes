package com.aplicacion.examenes.servicios;

import java.util.Set;

import com.aplicacion.examenes.entidades.Usuario;
import com.aplicacion.examenes.entidades.UsuarioRol;

public interface UsuarioService {

	public Usuario guardarUsuario(Usuario usuario, Set<UsuarioRol> usuarioRoles)throws Exception;
	
	public Usuario obtenerUsuario(String username);
	
	public void eliminarUsuario(Long usuarioId);
}
