package com.example.konex.repository;

import com.example.konex.entity.Inventario;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface InventarioRepository extends JpaRepository<Inventario, Long> {

    Optional<Inventario> findByNombre(String nombre);
    boolean existsByNombre(String nombre);
}
