package com.aplicacion.examenes.controladores;

import com.aplicacion.examenes.entidades.Categoria;
import com.aplicacion.examenes.servicios.CategoriaService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/categoria")
@CrossOrigin("*")
public class CategoriaController {

	@Autowired
	private CategoriaService categoriaService;
	
	@PostMapping("/")
	public ResponseEntity<Categoria> guardarCategoria(@RequestBody Categoria categoria){
		Categoria categoriaGuardada = categoriaService.agregarCategoria(categoria);
		return ResponseEntity.ok(categoriaGuardada);
	}
	
	@GetMapping("/{categoriaId}")
	public Categoria listarCategoiraPorId (@PathVariable("categoriaId") Long categoriaId) {
		return categoriaService.obtenerCategoria(categoriaId);
	}
	@GetMapping("/")
	public ResponseEntity<?> listarCategorias(){
		return ResponseEntity.ok(categoriaService.obtenerCategorias());
	}
	@PutMapping("/")
	public Categoria actualizarCategoria(@RequestBody Categoria categoria) {
		return categoriaService.actualizarCategoria(categoria);
	}
	@DeleteMapping("/{categoriaId}")
	public void eliminarCategoria(@PathVariable("categoriaId") Long categoriaId) {
		categoriaService.eliminarCategoria(categoriaId);
	}
}
