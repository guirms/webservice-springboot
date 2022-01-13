package com.cursojava.projetocurso.repositorios;

import org.springframework.data.jpa.repository.JpaRepository;

import com.cursojava.projetocurso.entidades.Produto;

public interface ProdutoRepositorio extends JpaRepository<Produto, Long> {
	
	

}
