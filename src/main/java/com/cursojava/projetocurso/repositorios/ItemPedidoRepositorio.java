package com.cursojava.projetocurso.repositorios;

import org.springframework.data.jpa.repository.JpaRepository;

import com.cursojava.projetocurso.entidades.ItemPedido;

public interface ItemPedidoRepositorio extends JpaRepository<ItemPedido, Long> {
	
	

}
