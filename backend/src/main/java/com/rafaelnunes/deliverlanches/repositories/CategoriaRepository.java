package com.rafaelnunes.deliverlanches.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.rafaelnunes.deliverlanches.entities.Categoria;

public interface CategoriaRepository extends JpaRepository<Categoria, Long> {

}
