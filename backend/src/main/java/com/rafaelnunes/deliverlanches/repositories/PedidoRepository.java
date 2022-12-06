package com.rafaelnunes.deliverlanches.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.rafaelnunes.deliverlanches.entities.Pedido;
import com.rafaelnunes.deliverlanches.projections.PedidoProjection;

public interface PedidoRepository extends JpaRepository<Pedido, Long> {
	
	@Query(nativeQuery = true, value = "SELECT P.ID, P.DATA_PEDIDO AS DATAPEDIDO, P.FORMA_PAGAMENTO AS FORMAPAGAMENTO, P.STATUS, U.NOME AS CLIENTENOME, "
			+ "E.LOCALIDADE AS CIDADE, E.BAIRRO, CONCAT(E.LOGRADOURO,  ' ' ,E.NUMERO) AS LOGRADOURO, E.COMPLEMENTO AS ENDERECOCOMPLEMENTO, "
			+ "SUM(PI.QUANTIDADE * PI.VALOR) AS TOTAL "
			+ "FROM TB_ENDERECO E INNER JOIN TB_PEDIDO P ON E.PEDIDO_ID=P.ID "
			+ "INNER JOIN TB_USUARIO U ON P.CLIENTE_ID=U.ID "
			+ "INNER JOIN TB_PEDIDO_ITEM PI ON P.ID=PI.PEDIDO_ID "
			+ "WHERE U.ID= :clienteId "
			+ "GROUP BY P.ID, P.DATA_PEDIDO, P.FORMA_PAGAMENTO, P.STATUS, U.NOME, E.LOCALIDADE, E.BAIRRO, E.LOGRADOURO, E.NUMERO, E.COMPLEMENTO "
			+ "ORDER BY P.DATA_PEDIDO DESC")
	List<PedidoProjection> listarPedidos(long clienteId); 
}
