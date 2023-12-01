package com.example.konex.controller;

import com.example.konex.dto.InventarioDto;
import com.example.konex.dto.Mensaje;
import com.example.konex.dto.VentaDto;
import com.example.konex.entity.Inventario;
import com.example.konex.entity.Venta;
import com.example.konex.repository.VentaRepository;
import com.example.konex.service.InventarioService;
import com.example.konex.service.VentaService;
import io.micrometer.common.util.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.sql.Timestamp;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;

@RestController
@RequestMapping("/venta")
@CrossOrigin(origins = "http://localhost:4200")
public class VentaController {

    @Autowired
    VentaService ventaService;

    @Autowired
    InventarioService inventarioService;

    @Autowired
    VentaRepository ventaRepository;

    @GetMapping("/listaVentas")
    public ResponseEntity<List<Venta>> list(){
        List<Venta> list = ventaService.list();
        return new ResponseEntity(list, HttpStatus.OK);
    }

    @PostMapping("/createVenta")
    public ResponseEntity<?> create(@RequestBody VentaDto ventaDto) {
        if (ventaDto.getFechaHora() == null)
            return new ResponseEntity(new Mensaje("la fecha es obligatoria"), HttpStatus.BAD_REQUEST);
        if (ventaDto.getCantidad() <= 0)
            return new ResponseEntity(new Mensaje("la cantidad debe ser mayor que 0"), HttpStatus.BAD_REQUEST);

        float valorUnitario = ventaDto.getValorunitario();
        int cantidad = ventaDto.getCantidad();
        float valorTotal = valorUnitario * cantidad;

        // Crear la venta
        Venta venta = new Venta(ventaDto.getFechaHora(), ventaDto.getInventario(), cantidad, valorUnitario, valorTotal);
        ventaService.save(venta);

        Inventario inventario = ventaDto.getInventario();
        inventario.setStock(inventario.getStock() - cantidad);

        inventario.getVentaList().add(venta);
        inventarioService.save(inventario);

        return new ResponseEntity(new Mensaje("Venta Exitosa"), HttpStatus.OK);
    }

    @GetMapping("/fecha")
    public List<Venta> getByStartDateBetween(@RequestParam @DateTimeFormat(pattern = "yyyy-MM-dd'T'HH:mm:ss") LocalDateTime from) {
        return ventaRepository.getByStartDateBetween(from);
    }
}
