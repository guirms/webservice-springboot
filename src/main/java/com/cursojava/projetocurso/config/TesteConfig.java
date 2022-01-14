package com.cursojava.projetocurso.config;

import java.time.Instant;
import java.util.Arrays;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;

import com.cursojava.projetocurso.entidades.Categoria;
import com.cursojava.projetocurso.entidades.Pedido;
import com.cursojava.projetocurso.entidades.Produto;
import com.cursojava.projetocurso.entidades.Usuario;
import com.cursojava.projetocurso.entidades.enums.StatusPedido;
import com.cursojava.projetocurso.repositorios.CategoriaRepositorio;
import com.cursojava.projetocurso.repositorios.PedidoRepositorio;
import com.cursojava.projetocurso.repositorios.ProdutoRepositorio;
import com.cursojava.projetocurso.repositorios.UsuarioRepositorio;

@Configuration
@Profile("test")
public class TesteConfig implements CommandLineRunner {

	@Autowired // tras as dependencias do objeto instanciado
	private UsuarioRepositorio usuarioRepositorio;

	@Autowired
	private PedidoRepositorio pedidoRepositorio;

	@Autowired
	private CategoriaRepositorio categoriaRepositorio;

	@Autowired
	private ProdutoRepositorio produtoRepositorio;

	@Override
	public void run(String... args) throws Exception {

		Categoria c1 = new Categoria(null, "Eletronicos");
		Categoria c2 = new Categoria(null, "Livros");
		Categoria c3 = new Categoria(null, "Computadores");

		Produto pr1 = new Produto(null, "The Lord of the Rings", "Lorem ipsum dolor sit amet, consectetur.", 90.5, "");
		Produto pr2 = new Produto(null, "Smart TV", "Nulla eu imperdiet purus. Maecenas ante.", 2190.0, "");
		Produto pr3 = new Produto(null, "Macbook Pro", "Nam eleifend maximus tortor, at mollis.", 1250.0, "");
		Produto pr4 = new Produto(null, "PC Gamer", "Donec aliquet odio ac rhoncus cursus.", 1200.0, "");
		Produto pr5 = new Produto(null, "Rails for Dummies", "Cras fringilla convallis sem vel faucibus.", 100.99, "");

		categoriaRepositorio.saveAll(Arrays.asList(c1, c2, c3));
		produtoRepositorio.saveAll(Arrays.asList(pr1, pr2, pr3, pr4, pr5));

		pr1.getCategorias().add(c2);
		pr2.getCategorias().add(c1);
		pr2.getCategorias().add(c3);
		pr3.getCategorias().add(c3);
		pr4.getCategorias().add(c3);
		pr5.getCategorias().add(c2);

		produtoRepositorio.saveAll(Arrays.asList(pr1, pr2, pr3, pr4, pr5));

		Usuario u1 = new Usuario(null, "Maria Brown", "maria@gmail.com", "988888888", "123456");
		Usuario u2 = new Usuario(null, "Alex Green", "alex@gmail.com", "977777777", "123456");

		Pedido p1 = new Pedido(null, Instant.parse("2019-06-20T19:53:07Z"), StatusPedido.PAGO, u1);
		Pedido p2 = new Pedido(null, Instant.parse("2019-07-21T03:42:10Z"), StatusPedido.AGUARDANDO_PAGAMENTO, u2);
		Pedido p3 = new Pedido(null, Instant.parse("2019-07-22T15:21:22Z"), StatusPedido.AGUARDANDO_PAGAMENTO, u1);

		usuarioRepositorio.saveAll(Arrays.asList(u1, u2));
		pedidoRepositorio.saveAll(Arrays.asList(p1, p2, p3));

	}

}
