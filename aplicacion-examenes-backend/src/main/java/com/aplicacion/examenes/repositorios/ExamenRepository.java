package com.aplicacion.examenes.repositorios;

import java.util.List;

import com.aplicacion.examenes.entidades.Categoria;
import com.aplicacion.examenes.entidades.Examen;

import org.springframework.data.jpa.repository.JpaRepository;

public interface ExamenRepository extends JpaRepository<Examen,Long>{
	List<Examen> findByCategoria(Categoria categoria);
	
	List<Examen> findByActivo(Boolean estado);
	
	List<Examen> findByCategoriaAndActivo(Categoria categoria ,Boolean estado);
	
	

}
