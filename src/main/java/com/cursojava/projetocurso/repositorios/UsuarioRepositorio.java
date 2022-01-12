package com.cursojava.projetocurso.repositorios;

import org.springframework.data.jpa.repository.JpaRepository;

import com.cursojava.projetocurso.entidades.Usuario;

public interface UsuarioRepositorio extends JpaRepository<Usuario, Long> {
	
	

}
