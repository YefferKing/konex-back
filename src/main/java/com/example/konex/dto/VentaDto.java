package com.example.konex.dto;

import com.example.konex.entity.Inventario;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;

import javax.validation.constraints.Min;
import javax.validation.constraints.NotBlank;
import java.sql.Timestamp;
import java.time.LocalDateTime;

public class VentaDto {

    @NotBlank
    private LocalDateTime fechaHora;
    @Min(0)
    private int cantidad;
    private Inventario inventario;
    private float valorunitario;
    private float valorTotal;

    public VentaDto() {
    }

    public VentaDto(@NotBlank LocalDateTime fechaHora, Inventario inventario, @Min(0) int cantidad,float valorunitario, float valorTotal) {
        this.fechaHora = fechaHora;
        this.inventario = inventario;
        this.cantidad = cantidad;
        this.valorunitario = valorunitario;
        this.valorTotal = valorTotal;
    }

    public LocalDateTime getFechaHora() {
        return fechaHora;
    }

    public void setFechaHora(LocalDateTime fechaHora) {
        this.fechaHora = fechaHora;
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

    public Inventario getInventario() {
        return inventario;
    }

    public void setInventario(Inventario inventario) {
        this.inventario = inventario;
    }
}
