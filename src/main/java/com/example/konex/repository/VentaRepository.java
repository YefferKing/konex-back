package com.example.konex.repository;

import com.example.konex.entity.Inventario;
import com.example.konex.entity.Venta;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.sql.Timestamp;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

@Repository
public interface VentaRepository extends JpaRepository<Venta, Integer> {
    @Query("select p from Venta p where p.fechaHora=:from")
    List<Venta> getByStartDateBetween(@Param("from") LocalDateTime from);

}
