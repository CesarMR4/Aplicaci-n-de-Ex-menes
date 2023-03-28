package com.aplicacion.examenes.repositorios;

import com.aplicacion.examenes.entidades.Categoria;

import org.springframework.data.jpa.repository.JpaRepository;

public interface CategoriaRepository extends JpaRepository<Categoria,Long> {

}
