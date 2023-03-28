package com.aplicacion.examenes.servicios;

import java.util.List;
import java.util.Set;

import com.aplicacion.examenes.entidades.Categoria;
import com.aplicacion.examenes.entidades.Examen;

public interface ExamenService {

	Examen agregarExamen(Examen examen);
	
	Examen actualizarExamen(Examen examen);
	
	Set<Examen> obtenerExamenes();
	
	Examen obtenerExamen(Long examenId);
	
	void eliminarExamen(Long examenId);
	
	List<Examen> listarExamenesDeUnaCategoria(Categoria categoria);
	
	List<Examen> obtenerExamenesActivos();
	
	List<Examen> obtenerExamenesActivosDeUnaCategoria(Categoria categoria);
}
