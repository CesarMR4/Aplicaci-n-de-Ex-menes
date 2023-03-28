package com.aplicacion.examenes.repositorios;

import com.aplicacion.examenes.entidades.Usuario;

import org.springframework.data.jpa.repository.JpaRepository;

public interface UsuarioRepository extends JpaRepository<Usuario,Long> {

	public Usuario findByUsername(String username);
}
