package com.cursojava.projetocurso.recursos;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.cursojava.projetocurso.entidades.Usuario;

@RestController
@RequestMapping(value = "/usuarios")
public class UsuarioRecursos {

	@GetMapping
	public ResponseEntity<Usuario> encontrarTudo(){ //retorna requisições na web
		Usuario u = new Usuario(1L, "Maria", "maria@gmail.com", "48 999351554", "12345");
		return ResponseEntity.ok().body(u);
	}
	
}
