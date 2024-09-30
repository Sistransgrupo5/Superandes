package uniandes.edu.co.proyecto.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import uniandes.edu.co.proyecto.modelo.RecepcionProducto;
import uniandes.edu.co.proyecto.repositorio.RecepcionProductoRepositorio;

import java.util.Collection;

@RestController
@RequestMapping("/recepciones-productos")
public class RecepcionProductoController {

    @Autowired
    private RecepcionProductoRepositorio recepcionProductoRepositorio;

    // Obtener todas las recepciones de productos
    @GetMapping
    public ResponseEntity<Collection<RecepcionProducto>> darRecepcionProductos() {
        try {
            Collection<RecepcionProducto> recepciones = recepcionProductoRepositorio.darRecepcionProductos();
            if (recepciones.isEmpty()) {
                return new ResponseEntity<>(HttpStatus.NO_CONTENT);
            }
            return new ResponseEntity<>(recepciones, HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    // Obtener una recepción de producto por ID
    @GetMapping("/{id}")
    public ResponseEntity<RecepcionProducto> darRecepcionProducto(@PathVariable("id") int id) {
        try {
            RecepcionProducto recepcion = recepcionProductoRepositorio.darRecepcionProducto(id);
            if (recepcion != null) {
                return new ResponseEntity<>(recepcion, HttpStatus.OK);
            } else {
                return new ResponseEntity<>(HttpStatus.NOT_FOUND);
            }
        } catch (Exception e) {
            return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    // Insertar una nueva recepción de producto
    @PostMapping("/new")
    public ResponseEntity<String> insertarRecepcionProducto(@RequestBody RecepcionProducto recepcionProducto) {
        try {
            recepcionProductoRepositorio.insertarRecepcionProducto(recepcionProducto.getFechaRecepcion());
            return new ResponseEntity<>("Recepción de producto creada exitosamente", HttpStatus.CREATED);
        } catch (Exception e) {
            return new ResponseEntity<>("Error al crear la recepción de producto", HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    // Actualizar una recepción de producto existente
    @PutMapping("/{id}")
    public ResponseEntity<String> actualizarRecepcionProducto(@PathVariable("id") int id, @RequestBody RecepcionProducto recepcionProducto) {
        try {
            recepcionProductoRepositorio.actualizarRecepcionProducto(id, recepcionProducto.getFechaRecepcion());
            return new ResponseEntity<>("Recepción de producto actualizada exitosamente", HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>("Error al actualizar la recepción de producto", HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    // Eliminar una recepción de producto
    @DeleteMapping("/{id}")
    public ResponseEntity<String> eliminarRecepcionProducto(@PathVariable("id") int id) {
        try {
            recepcionProductoRepositorio.eliminarRecepcionProducto(id);
            return new ResponseEntity<>("Recepción de producto eliminada exitosamente", HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>("Error al eliminar la recepción de producto", HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
}
