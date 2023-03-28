package com.aplicacion.examenes.servicios;

import java.util.Set;

import com.aplicacion.examenes.entidades.Examen;
import com.aplicacion.examenes.entidades.Pregunta;

public interface PreguntaService {

	Pregunta agregarPregunta(Pregunta pregunta);
	
	Pregunta actualizarPregunta(Pregunta pregunta);
	
	Set<Pregunta> obtenerPreguntas();
	
	Pregunta obtenerPregunta(Long preguntaId);
	
	Set<Pregunta> obtenerPreguntasDelExamen(Examen examen);
	
	void eliminarPregunta(Long preguntaId);
	
	Pregunta listarPregunta(Long preguntaId);
	
} 
