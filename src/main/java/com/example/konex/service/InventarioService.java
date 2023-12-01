package com.example.konex.service;

import com.example.konex.entity.Inventario;
import com.example.konex.repository.InventarioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Service
@Transactional
public class InventarioService {

    @Autowired
    InventarioRepository inventarioRepository;

    public List<Inventario> list(){
        return inventarioRepository.findAll();
    }

    public Optional<Inventario> getOne(Long id){
        return inventarioRepository.findById(id);
    }

    public Optional<Inventario> getByNombre(String nombre){
        return inventarioRepository.findByNombre(nombre);
    }

    public void  save(Inventario inventario){
        inventarioRepository.save(inventario);
    }

    public void delete(Long id){
        inventarioRepository.deleteById(id);
    }

    public boolean existsById(Long id){
        return inventarioRepository.existsById(id);
    }

    public boolean existsByNombre(String nombre){
        return inventarioRepository.existsByNombre(nombre);
    }
}
