package com.example.konex.entity;


import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;

import java.sql.Date;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "inventario")
public class Inventario {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String nombre;
    private String laboratorioFabrica;
    private Date fechaFabricacion;
    private Date fechaVencimiento;
    private int stock;
    private float valorUnitario;

    @JsonIgnore
    @OneToMany(mappedBy = "inventario")
    private List<Venta> ventaList = new ArrayList<>();

    public Inventario() {
    }

    public Inventario(String nombre, String laboratorioFabrica, Date fechaFabricacion, Date fechaVencimiento, int stock, float valorUnitario) {
        this.nombre = nombre;
        this.laboratorioFabrica = laboratorioFabrica;
        this.fechaFabricacion = fechaFabricacion;
        this.fechaVencimiento = fechaVencimiento;
        this.stock = stock;
        this.valorUnitario = valorUnitario;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
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

    public List<Venta> getVentaList() {
        return ventaList;
    }

    public void setVentaList(List<Venta> ventaList) {
        this.ventaList = ventaList;
    }
}
