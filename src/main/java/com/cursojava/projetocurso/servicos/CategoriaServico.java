package com.cursojava.projetocurso.servicos;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cursojava.projetocurso.entidades.Categoria;
import com.cursojava.projetocurso.repositorios.CategoriaRepositorio;

@Service
public class CategoriaServico {
	
	@Autowired
	private CategoriaRepositorio repositorio;
	
	public List<Categoria> encontrarTudo(){
		return repositorio.findAll();
	}
	
	public Categoria encontrarPorId(Long id) {
		Optional<Categoria> obj = repositorio.findById(id);
		return obj.get();
	}

}
