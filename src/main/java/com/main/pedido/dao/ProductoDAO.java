package com.main.pedido.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.main.pedido.entitys.Producto;

public interface ProductoDAO extends JpaRepository<Producto, Long> {

}
