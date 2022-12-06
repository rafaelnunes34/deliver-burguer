package com.rafaelnunes.deliverlanches.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.rafaelnunes.deliverlanches.entities.PedidoItem;
import com.rafaelnunes.deliverlanches.entities.pk.PedidoItemPK;

public interface PedidoItemRepository extends JpaRepository<PedidoItem, PedidoItemPK> {

}
