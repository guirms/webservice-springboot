package com.cursojava.projetocurso.entidades;

import java.io.Serializable;
import java.time.Instant;
import java.util.HashSet;
import java.util.Objects;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import com.cursojava.projetocurso.entidades.enums.StatusPedido;
import com.fasterxml.jackson.annotation.JsonFormat;

@Entity
@Table(name = "tb_pedido")
public class Pedido implements Serializable {

	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	@JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd'T'HH:mm:ss'Z'", timezone = "GMT")
	private Instant momento;

	private Integer statusPedido;

	@ManyToOne
	@JoinColumn(name = "id_cliente")
	private Usuario cliente;

	@OneToMany(mappedBy = "id.pedido") // pq no ItemPedido vc tem o id, e o id que tem o pedido
	private Set<ItemPedido> itens = new HashSet<>();

	@OneToOne(mappedBy = "pedido", cascade = CascadeType.ALL) //na classe principal da associação, cascade serve pra mapear as 2 entidades com o mesmo id
	private Pagamento pagamento;

	public Pedido() {
	}

	public Pedido(Long id, Instant momento, StatusPedido statusPedido, Usuario cliente) {
		this.id = id;
		this.momento = momento;
		setStatusPedido(statusPedido);
		this.cliente = cliente;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Instant getMomento() {
		return momento;
	}

	public void setMomento(Instant momento) {
		this.momento = momento;
	}

	public StatusPedido getStatusPedido() {
		return StatusPedido.valorDe(statusPedido);
	}

	public void setStatusPedido(StatusPedido statusPedido) {
		if (statusPedido != null) {
			this.statusPedido = statusPedido.getCodigoTipoEnum();
		}
	}

	public Usuario getCliente() {
		return cliente;
	}

	public void setCliente(Usuario cliente) {
		this.cliente = cliente;
	}

	public Set<ItemPedido> getItens() {
		return itens;
	}
	
	public Double getTotalPedido() {
		double total = 0.0;
		for (ItemPedido x : itens) {
			total += x.getSubTotal();
		}
		return total;
	}

	@Override
	public int hashCode() {
		return Objects.hash(id);
	}

	public Pagamento getPagamento() {
		return pagamento;
	}

	public void setPagamento(Pagamento pagamento) {
		this.pagamento = pagamento;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Pedido other = (Pedido) obj;
		return Objects.equals(id, other.id);
	}

}
