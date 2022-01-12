package com.cursojava.projetocurso.recursos;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.cursojava.projetocurso.entidades.Pedido;
import com.cursojava.projetocurso.servicos.PedidoServico;

@RestController
@RequestMapping(value = "/pedidos")
public class PedidoRecursos {

	@Autowired
	private PedidoServico servico;
	
	@GetMapping //requisição do tipo get
	public ResponseEntity<List<Pedido>> encontrarTudo(){ //retorna requisições na web
		List<Pedido> lista = servico.encontrarTudo();
		return ResponseEntity.ok().body(lista);
	}
	
	@GetMapping(value = "/{id}")
	public ResponseEntity<Pedido> encontrarPorId(@PathVariable Long id){
		Pedido obj = servico.encontrarPorId(id);
		return ResponseEntity.ok().body(obj);
	}
	
}
