package com.cursojava.projetocurso.recursos;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.cursojava.projetocurso.entidades.Usuario;
import com.cursojava.projetocurso.servicos.UsuarioServico;

@RestController
@RequestMapping(value = "/usuarios")
public class UsuarioRecursos {

	@Autowired
	private UsuarioServico servico;
	
	@GetMapping //requisição do tipo get
	public ResponseEntity<List<Usuario>> encontrarTudo(){ //retorna requisições na web
		List<Usuario> lista = servico.encontrarTudo();
		return ResponseEntity.ok().body(lista);
	}
	
	@GetMapping(value = "/{id}")
	public ResponseEntity<Usuario> encontrarPorId(@PathVariable Long id){
		Usuario obj = servico.encontrarPorId(id);
		return ResponseEntity.ok().body(obj);
	}
	
	
	
}
