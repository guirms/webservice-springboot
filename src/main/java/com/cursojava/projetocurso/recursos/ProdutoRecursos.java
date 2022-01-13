package com.cursojava.projetocurso.recursos;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.cursojava.projetocurso.entidades.Produto;
import com.cursojava.projetocurso.servicos.ProdutoServico;

@RestController
@RequestMapping(value = "/produtos")
public class ProdutoRecursos {

	@Autowired
	private ProdutoServico servico;
	
	@GetMapping //requisição do tipo get
	public ResponseEntity<List<Produto>> encontrarTudo(){ //retorna requisições na web
		List<Produto> lista = servico.encontrarTudo();
		return ResponseEntity.ok().body(lista);
	}
	
	@GetMapping(value = "/{id}")
	public ResponseEntity<Produto> encontrarPorId(@PathVariable Long id){
		Produto obj = servico.encontrarPorId(id);
		return ResponseEntity.ok().body(obj);
	}
	
}
