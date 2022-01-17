package com.cursojava.projetocurso.recursos.exceptions;

import java.time.Instant;

import javax.servlet.http.HttpServletRequest;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import com.cursojava.projetocurso.servicos.exceptions.BancoDeDadosException;
import com.cursojava.projetocurso.servicos.exceptions.RecursoNaoEncontradoException;

@ControllerAdvice // intercepta as exceções
public class ManipuladorExcecoesRecursos {
	
	@ExceptionHandler(RecursoNaoEncontradoException.class) // identifica e intercepta a excecao requisitada
	public ResponseEntity<ErroPadrao> recursoNaoEncontrado(RecursoNaoEncontradoException e, HttpServletRequest request){
		String erro = "Recurso não encontrado";
		HttpStatus status = HttpStatus.NOT_FOUND;
		ErroPadrao erroo = new ErroPadrao(Instant.now(), status.value(), erro, e.getMessage(), request.getRequestURI());
		return ResponseEntity.status(status).body(erroo);
	}
	
	@ExceptionHandler(BancoDeDadosException.class) // identifica e intercepta a excecao requisitada
	public ResponseEntity<ErroPadrao> bancoDeDados(BancoDeDadosException e, HttpServletRequest request){
		String erro = "Erro no banco de dados";
		HttpStatus status = HttpStatus.BAD_REQUEST;
		ErroPadrao erroo = new ErroPadrao(Instant.now(), status.value(), erro, e.getMessage(), request.getRequestURI());
		return ResponseEntity.status(status).body(erroo);
	}

}
