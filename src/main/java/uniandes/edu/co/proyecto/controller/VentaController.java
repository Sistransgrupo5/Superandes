package uniandes.edu.co.proyecto.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import uniandes.edu.co.proyecto.modelo.Venta;
import uniandes.edu.co.proyecto.repositorio.VentaRepositorio;

import java.util.Collection;

@RestController
@RequestMapping("/ventas")
public class VentaController {

    @Autowired
    private VentaRepositorio ventaRepositorio;

    // Obtener todas las ventas
    @GetMapping
    public ResponseEntity<Collection<Venta>> darVentas() {
        try {
            Collection<Venta> ventas = ventaRepositorio.darVentas();
            if (ventas.isEmpty()) {
                return new ResponseEntity<>(HttpStatus.NO_CONTENT);
            }
            return new ResponseEntity<>(ventas, HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    // Obtener una venta por ID
    @GetMapping("/{id}")
    public ResponseEntity<Venta> darVenta(@PathVariable("id") int id) {
        try {
            Venta venta = ventaRepositorio.darVenta(id);
            if (venta != null) {
                return new ResponseEntity<>(venta, HttpStatus.OK);
            } else {
                return new ResponseEntity<>(HttpStatus.NOT_FOUND);
            }
        } catch (Exception e) {
            return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    // Insertar una nueva venta
    @PostMapping("/new")
    public ResponseEntity<String> insertarVenta(@RequestBody Venta venta) {
        try {
            ventaRepositorio.insertarVenta(venta.getFecha());
            return new ResponseEntity<>("Venta creada exitosamente", HttpStatus.CREATED);
        } catch (Exception e) {
            return new ResponseEntity<>("Error al crear la venta", HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    // Actualizar una venta existente
    @PutMapping("/{id}")
    public ResponseEntity<String> actualizarVenta(@PathVariable("id") int id, @RequestBody Venta venta) {
        try {
            ventaRepositorio.actualizarVenta(id, venta.getFecha());
            return new ResponseEntity<>("Venta actualizada exitosamente", HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>("Error al actualizar la venta", HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    // Eliminar una venta
    @DeleteMapping("/{id}")
    public ResponseEntity<String> eliminarVenta(@PathVariable("id") int id) {
        try {
            ventaRepositorio.eliminarVenta(id);
            return new ResponseEntity<>("Venta eliminada exitosamente", HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>("Error al eliminar la venta", HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
}
