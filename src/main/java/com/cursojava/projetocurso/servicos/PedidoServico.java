package com.cursojava.projetocurso.servicos;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cursojava.projetocurso.entidades.Pedido;
import com.cursojava.projetocurso.repositorios.PedidoRepositorio;

@Service
public class PedidoServico {
	
	@Autowired
	private PedidoRepositorio repositorio;
	
	public List<Pedido> encontrarTudo(){
		return repositorio.findAll();
	}
	
	public Pedido encontrarPorId(Long id) {
		Optional<Pedido> obj = repositorio.findById(id);
		return obj.get();
	}

}
