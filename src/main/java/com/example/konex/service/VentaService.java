package com.example.konex.service;

import com.example.konex.entity.Inventario;
import com.example.konex.entity.Venta;
import com.example.konex.repository.InventarioRepository;
import com.example.konex.repository.VentaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.sql.Timestamp;
import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

@Service
@Transactional
public class VentaService {

    @Autowired
    VentaRepository ventaRepository;

    public List<Venta> list(){
        return ventaRepository.findAll();
    }

    public Optional<Venta> getOne(int id){
        return ventaRepository.findById(id);
    }

    public void  save(Venta venta){
        ventaRepository.save(venta);
    }

    public void delete(int id){
        ventaRepository.deleteById(id);
    }

    public boolean existsById(int id){
        return ventaRepository.existsById(id);
    }

}
