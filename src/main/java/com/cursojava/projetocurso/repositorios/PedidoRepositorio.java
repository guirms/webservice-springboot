package com.cursojava.projetocurso.repositorios;

import org.springframework.data.jpa.repository.JpaRepository;

import com.cursojava.projetocurso.entidades.Pedido;

public interface PedidoRepositorio extends JpaRepository<Pedido, Long> {
	
	

}
