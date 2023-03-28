package com.aplicacion.examenes.servicios;

import java.util.LinkedHashSet;
import java.util.List;
import java.util.Set;

import com.aplicacion.examenes.entidades.Categoria;
import com.aplicacion.examenes.entidades.Examen;
import com.aplicacion.examenes.repositorios.ExamenRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ExamenServiceImpl implements ExamenService {

	@Autowired
	ExamenRepository examenRepository;
	@Override
	public Examen agregarExamen(Examen examen) {
		 return examenRepository.save(examen);
		 
	}

	@Override
	public Examen actualizarExamen(Examen examen) {
		return examenRepository.save(examen);
	}

	@Override
	public Set<Examen> obtenerExamenes() {
		return new LinkedHashSet<>(examenRepository.findAll());
	}

	@Override
	public Examen obtenerExamen(Long examenId) {
		return examenRepository.findById(examenId).get();
	}

	@Override
	public void eliminarExamen(Long examenId) {
		 Examen examen = new Examen();
		 examen.setExamenId(examenId);
		 examenRepository.delete(examen);
		
	}

	@Override
	public List<Examen> listarExamenesDeUnaCategoria(Categoria categoria) {
		 return this.examenRepository.findByCategoria(categoria);
	}

	@Override
	public List<Examen> obtenerExamenesActivos() {
		return examenRepository.findByActivo(true);
	}

	@Override
	public List<Examen> obtenerExamenesActivosDeUnaCategoria(Categoria categoria) {
		 		return examenRepository.findByCategoriaAndActivo(categoria, true);
	}

}
