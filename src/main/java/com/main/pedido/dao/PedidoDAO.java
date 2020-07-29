package com.main.pedido.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.main.pedido.entitys.Pedido;

public interface PedidoDAO extends JpaRepository<Pedido, Long> {

}
