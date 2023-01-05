package com.rafaelnunes.deliverlanches.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.rafaelnunes.deliverlanches.entities.Pedido;
import com.rafaelnunes.deliverlanches.projections.PedidoProjection;

public interface PedidoRepository extends JpaRepository<Pedido, Long> {
	
	@Query(nativeQuery = true, value = "SELECT p.id, p.data_pedido AS dataPedido, p.forma_pagamento AS formaPagamento, p.status, u.nome AS clienteNome, "
			+ "e.localidade AS cidade, e.bairro, CONCAT(e.logradouro,  ' ' ,e.numero) AS logradouro, e.complemento AS enderecoComplemento, "
			+ "SUM(pi.QUANTIDADE * pi.VALOR) AS total "
			+ "FROM tb_endereco e INNER JOIN tb_pedido p ON e.pedido_id=p.id "
			+ "INNER JOIN tb_usuario u ON p.cliente_id=u.id "
			+ "INNER JOIN tb_pedido_item pi ON p.id=pi.pedido_id "
			+ "WHERE u.id= :clienteId "
			+ "GROUP BY p.id, p.data_pedido, p.forma_pagamento, p.status, u.nome, e.localidade, e.bairro, e.logradouro, e.numero, e.complemento "
			+ "ORDER BY p.data_pedido")
	List<PedidoProjection> listarPedidos(long clienteId); 
}
