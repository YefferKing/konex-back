package com.example.konex.entity;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;

import java.sql.Timestamp;
import java.time.LocalDateTime;

@Entity
@Table(name = "venta")
public class Venta {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @JsonFormat(pattern="yyyy-MM-dd")
    @Column(name = "fecha_alta")
    private LocalDateTime fechaHora;
    @JoinColumn(name = "medicamento_id")
    @JsonIgnore
    @ManyToOne
    private Inventario inventario;
    private int cantidad;
    private float valorunitario;
    private float valorTotal;

    public Venta() {
    }

    public Venta(LocalDateTime fechaHora, Inventario inventario, int cantidad, float valorunitario, float valorTotal) {
        this.fechaHora = fechaHora;
        this.inventario = inventario;
        this.cantidad = cantidad;
        this.valorunitario = valorunitario;
        this.valorTotal = valorTotal;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public LocalDateTime getFechaHora() {
        return fechaHora;
    }

    public void setFechaHora(LocalDateTime fechaHora) {
        this.fechaHora = fechaHora;
    }

    public Inventario getMedicamento() {
        return inventario;
    }

    public void setMedicamento(Inventario inventario) {
        this.inventario = inventario;
    }

    public int getCantidad() {
        return cantidad;
    }

    public void setCantidad(int cantidad) {
        this.cantidad = cantidad;
    }

    public float getValorunitario() {
        return valorunitario;
    }

    public void setValorunitario(float valorunitario) {
        this.valorunitario = valorunitario;
    }

    public float getValorTotal() {
        return valorTotal;
    }

    public void setValorTotal(float valorTotal) {
        this.valorTotal = valorTotal;
    }
}
