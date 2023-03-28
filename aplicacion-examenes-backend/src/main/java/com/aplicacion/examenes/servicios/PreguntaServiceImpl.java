package com.aplicacion.examenes.servicios;

import java.util.LinkedHashSet;
import java.util.Set;

import com.aplicacion.examenes.entidades.Examen;
import com.aplicacion.examenes.entidades.Pregunta;
import com.aplicacion.examenes.repositorios.PreguntaRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class PreguntaServiceImpl implements PreguntaService {

	@Autowired
	PreguntaRepository preguntaRepository;
	
	@Override
	public Pregunta agregarPregunta(Pregunta pregunta) {
		return preguntaRepository.save(pregunta);
	}

	@Override
	public Pregunta actualizarPregunta(Pregunta pregunta) {
	return preguntaRepository.save(pregunta);
	}

	@Override
	public Set<Pregunta> obtenerPreguntas() {
		return new LinkedHashSet<>(preguntaRepository.findAll());
	}

	@Override
	public Pregunta obtenerPregunta(Long preguntaId) {
		return preguntaRepository.findById(preguntaId).get();
	}

	@Override
	public Set<Pregunta> obtenerPreguntasDelExamen(Examen examen) {
		return preguntaRepository.findByExamen(examen);
	}

	@Override
	public void eliminarPregunta(Long preguntaId) {
		Pregunta pregunta = new Pregunta();
		pregunta.setPreguntaId(preguntaId);
		preguntaRepository.delete(pregunta);
		
	}

	@Override
	public Pregunta listarPregunta(Long preguntaId) {
		 return this.preguntaRepository.getOne(preguntaId);
	}

}
