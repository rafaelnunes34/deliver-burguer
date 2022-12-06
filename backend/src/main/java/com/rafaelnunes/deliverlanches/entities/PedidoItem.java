package com.rafaelnunes.deliverlanches.entities;

import java.io.Serializable;

import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.Table;

import com.rafaelnunes.deliverlanches.entities.pk.PedidoItemPK;

@Entity
@Table(name = "tb_pedido_item")
public class PedidoItem implements Serializable {
	
	private static final long serialVersionUID = 1L;
	
	@EmbeddedId
	private PedidoItemPK id = new PedidoItemPK();
	private Integer quantidade;
	private Double valor;
	
	public PedidoItem() {
	}

	public PedidoItem(Pedido pedido, Produto produto, Integer quantidade, Double valor) {
		id.setPedido(pedido);
		id.setProduto(produto);
		this.quantidade = quantidade;
		this.valor = valor;
	}

	public Pedido getPedido() {
		return id.getPedido();
	}
	
	public void setPedido(Pedido pedido) {
		id.setPedido(pedido);
	}
	
	public Produto getProduto() {
		return id.getProduto();
	}
	
	public void setProduto(Produto produto) {
		id.setProduto(produto);
	}

	public Integer getQuantidade() {
		return quantidade;
	}

	public void setQuantidade(Integer quantidade) {
		this.quantidade = quantidade;
	}

	public Double getValor() {
		return valor;
	}

	public void setValor(Double valor) {
		this.valor = valor;
	}
	
	public double getSubTotal() {
		return quantidade * valor;
	}
}
