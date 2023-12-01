package com.example.konex.controller;

import com.example.konex.dto.InventarioDto;
import com.example.konex.dto.Mensaje;
import com.example.konex.entity.Inventario;
import com.example.konex.service.InventarioService;
import io.micrometer.common.util.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/inventario")
@CrossOrigin(origins = "http://localhost:4200")
public class InventarioController {

    @Autowired
    InventarioService inventarioService;

    @GetMapping("/lista")
    public ResponseEntity<List<Inventario>> list() {
        try {
            List<Inventario> list = inventarioService.list();
            return new ResponseEntity<>(list, HttpStatus.OK);
        } catch (Exception e) {
            e.printStackTrace(); // Loguea la excepción si es necesario
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @GetMapping("/detail/{id}")
    public ResponseEntity<Inventario> getById(@PathVariable("id") Long id){
        if(!inventarioService.existsById(id))
            return new ResponseEntity(new Mensaje("no existe"), HttpStatus.NOT_FOUND);
        Inventario inventario = inventarioService.getOne(id).get();
        return new ResponseEntity(inventario, HttpStatus.OK);
    }

    @GetMapping("/detailname/{nombre}")
    public ResponseEntity<Inventario> getByNombre(@PathVariable("nombre") String nombre){
        if(!inventarioService.existsByNombre(nombre))
            return new ResponseEntity(new Mensaje("no existe"), HttpStatus.NOT_FOUND);
        Inventario inventario = inventarioService.getByNombre(nombre).get();
        return new ResponseEntity(inventario, HttpStatus.OK);
    }

    @PostMapping("/create")
    public ResponseEntity<?> create(@RequestBody InventarioDto inventarioDto){
        if(StringUtils.isBlank(inventarioDto.getNombre()))
            return new ResponseEntity(new Mensaje("el nombre es obligatorio"), HttpStatus.BAD_REQUEST);
        if(StringUtils.isBlank(inventarioDto.getLaboratorioFabrica()))
            return new ResponseEntity(new Mensaje("el laboratorio de fabrica es obligatorio"), HttpStatus.BAD_REQUEST);
        if(inventarioDto.getFechaFabricacion() == null)
            return new ResponseEntity(new Mensaje("la fecha de fabricacion es obligatorio"), HttpStatus.BAD_REQUEST);
        if(inventarioDto.getStock()<0)
            return new ResponseEntity(new Mensaje("el stock debe ser mayor que 0"), HttpStatus.BAD_REQUEST);
        if(inventarioService.existsByNombre(inventarioDto.getNombre()))
            return new ResponseEntity(new Mensaje("ese medicamento ya existe"), HttpStatus.BAD_REQUEST);
        Inventario inventario = new Inventario(inventarioDto.getNombre(), inventarioDto.getLaboratorioFabrica(), inventarioDto.getFechaFabricacion(), inventarioDto.getFechaVencimiento(), inventarioDto.getStock(), inventarioDto.getValorUnitario());
        inventarioService.save(inventario);
        return new ResponseEntity(new Mensaje("Medicamento creado"), HttpStatus.OK);
    }

    @PutMapping("/update/{id}")
    public ResponseEntity<?> update(@PathVariable("id")Long id, @RequestBody InventarioDto inventarioDto){
        if(inventarioService.existsByNombre(inventarioDto.getNombre()) && inventarioService.getByNombre(inventarioDto.getNombre()).get().getId() != id)
            return new ResponseEntity(new Mensaje("ese nombre ya existe"), HttpStatus.BAD_REQUEST);
        if(StringUtils.isBlank(inventarioDto.getNombre()))
            return new ResponseEntity(new Mensaje("el nombre es obligatorio"), HttpStatus.BAD_REQUEST);
        if(inventarioDto.getStock()<0 )
            return new ResponseEntity(new Mensaje("el stock debe ser mayor que 0"), HttpStatus.BAD_REQUEST);

        Inventario inventario = inventarioService.getOne(id).get();
        inventario.setNombre(inventarioDto.getNombre());
        inventario.setLaboratorioFabrica(inventarioDto.getLaboratorioFabrica());
        inventario.setFechaFabricacion(inventarioDto.getFechaFabricacion());
        inventario.setFechaVencimiento(inventarioDto.getFechaVencimiento());
        inventario.setStock(inventarioDto.getStock());
        inventario.setValorUnitario(inventarioDto.getValorUnitario());
        inventarioService.save(inventario);
        return new ResponseEntity(new Mensaje("medicamento actualizado"), HttpStatus.OK);
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<?> delete(@PathVariable("id")Long id){
        if(!inventarioService.existsById(id))
            return new ResponseEntity(new Mensaje("no existe"), HttpStatus.NOT_FOUND);
        inventarioService.delete(id);
        return new ResponseEntity(new Mensaje("producto eliminado"), HttpStatus.OK);
    }

}
