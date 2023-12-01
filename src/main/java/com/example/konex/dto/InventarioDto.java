package com.example.konex.dto;

import javax.validation.constraints.Min;
import javax.validation.constraints.NotBlank;

import java.sql.Date;


public class InventarioDto {

    @NotBlank
    private String nombre;
    @NotBlank
    private String laboratorioFabrica;
    @NotBlank
    private Date fechaFabricacion;
    @NotBlank
    private Date fechaVencimiento;
    @Min(0)
    private int stock;
    private float valorUnitario;

    public InventarioDto() {
    }

    public InventarioDto(@NotBlank String nombre, @NotBlank String laboratorioFabrica, @NotBlank Date fechaFabricacion, @NotBlank Date fechaVencimiento, @Min(0) int stock, float valorUnitario) {
        this.nombre = nombre;
        this.laboratorioFabrica = laboratorioFabrica;
        this.fechaFabricacion = fechaFabricacion;
        this.fechaVencimiento = fechaVencimiento;
        this.stock = stock;
        this.valorUnitario = valorUnitario;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getLaboratorioFabrica() {
        return laboratorioFabrica;
    }

    public void setLaboratorioFabrica(String laboratorioFabrica) {
        this.laboratorioFabrica = laboratorioFabrica;
    }

    public Date getFechaFabricacion() {
        return fechaFabricacion;
    }

    public void setFechaFabricacion(Date fechaFabricacion) {
        this.fechaFabricacion = fechaFabricacion;
    }

    public Date getFechaVencimiento() {
        return fechaVencimiento;
    }

    public void setFechaVencimiento(Date fechaVencimiento) {
        this.fechaVencimiento = fechaVencimiento;
    }

    public int getStock() {
        return stock;
    }

    public void setStock(int stock) {
        this.stock = stock;
    }

    public float getValorUnitario() {
        return valorUnitario;
    }

    public void setValorUnitario(float valorUnitario) {
        this.valorUnitario = valorUnitario;
    }
}
