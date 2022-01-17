package com.cursojava.projetocurso.recursos;

import java.net.URI;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

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
	
	@PostMapping //postar
	public ResponseEntity<Usuario> inserir(@RequestBody Usuario obj){
		obj = servico.inserir(obj); // para inserir de forma correta com o código 201 created
		URI uri	= ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(obj.getId()).toUri();
		return ResponseEntity.created(uri).body(obj); //para criar o corpo com o codigo 201 created
	}
	
	@DeleteMapping(value = "/{id}")
	public ResponseEntity<Void> deletar(@PathVariable Long id){
		servico.deletar(id);
		return ResponseEntity.noContent().build(); //para retornar sem corpo
	}
	
	@PutMapping(value = "/{id}")
	public ResponseEntity<Usuario> atualizar(@PathVariable Long id, @RequestBody Usuario obj){
		obj = servico.atualizar(id, obj);
		return ResponseEntity.ok().body(obj);
		
	}
}
