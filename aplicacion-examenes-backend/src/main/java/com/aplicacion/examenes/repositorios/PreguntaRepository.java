package com.aplicacion.examenes.repositorios;

import java.util.Set;

import com.aplicacion.examenes.entidades.Examen;
import com.aplicacion.examenes.entidades.Pregunta;

import org.springframework.data.jpa.repository.JpaRepository;

public interface PreguntaRepository extends JpaRepository<Pregunta,Long> {

	Set<Pregunta> findByExamen(Examen examen);
}
