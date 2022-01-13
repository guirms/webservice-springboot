package com.cursojava.projetocurso.recursos;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.cursojava.projetocurso.entidades.Categoria;
import com.cursojava.projetocurso.servicos.CategoriaServico;

@RestController
@RequestMapping(value = "/categorias")
public class CategoriaRecursos {

	@Autowired
	private CategoriaServico servico;
	
	@GetMapping //requisição do tipo get
	public ResponseEntity<List<Categoria>> encontrarTudo(){ //retorna requisições na web
		List<Categoria> lista = servico.encontrarTudo();
		return ResponseEntity.ok().body(lista);
	}
	
	@GetMapping(value = "/{id}")
	public ResponseEntity<Categoria> encontrarPorId(@PathVariable Long id){
		Categoria obj = servico.encontrarPorId(id);
		return ResponseEntity.ok().body(obj);
	}
	
}
