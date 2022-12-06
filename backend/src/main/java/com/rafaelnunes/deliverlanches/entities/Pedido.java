package com.rafaelnunes.deliverlanches.entities;

import java.io.Serializable;
import java.time.Instant;
import java.util.HashSet;
import java.util.Objects;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import com.rafaelnunes.deliverlanches.entities.enums.FormaPagamento;
import com.rafaelnunes.deliverlanches.entities.enums.PedidoStatus;

@Entity
@Table(name = "tb_pedido")
public class Pedido implements Serializable {
	
	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	private Instant dataPedido;
	
	@Enumerated(EnumType.STRING)
	private PedidoStatus status;
	
	@Enumerated(EnumType.STRING)
	private FormaPagamento formaPagamento;
	
	@ManyToOne
	@JoinColumn(name = "cliente_id")
	private Usuario cliente;
	
	@OneToMany(mappedBy = "id.pedido")
	private Set<PedidoItem> itens = new HashSet<>();
	
	@OneToOne(mappedBy = "pedido", cascade = CascadeType.ALL)
	private Endereco endereco;
	
	public Pedido() {
	}

	public Pedido(Long id, Instant dataPedido, PedidoStatus status, FormaPagamento formaPagamento, Usuario cliente, Endereco endereco) {
		this.id = id;
		this.dataPedido = dataPedido;
		this.status = status;
		this.formaPagamento = formaPagamento;
		this.cliente = cliente;
		this.endereco = endereco;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Instant getDataPedido() {
		return dataPedido;
	}

	public void setDataPedido(Instant dataPedido) {
		this.dataPedido = dataPedido;
	}

	public PedidoStatus getStatus() {
		return status;
	}

	public void setStatus(PedidoStatus status) {
		this.status = status;
	}

	public FormaPagamento getFormaPagamento() {
		return formaPagamento;
	}

	public void setFormaPagamento(FormaPagamento formaPagamento) {
		this.formaPagamento = formaPagamento;
	}

	public Usuario getCliente() {
		return cliente;
	}

	public void setCliente(Usuario cliente) {
		this.cliente = cliente;
	}
	
	public Set<PedidoItem> getItens() {
		return itens;
	}
	
	public Endereco getEndereco() {
		return endereco;
	}

	public void setEndereco(Endereco endereco) {
		this.endereco = endereco;
	}

	public double getTotal() {
		double sum = 0.0;
		for(PedidoItem item : itens) {
			sum += item.getSubTotal();
		}
		return sum;
	}

	@Override
	public int hashCode() {
		return Objects.hash(id);
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
