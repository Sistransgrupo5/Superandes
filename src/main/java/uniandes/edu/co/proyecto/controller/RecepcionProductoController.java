package uniandes.edu.co.proyecto.controller;

import java.util.Collection;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import uniandes.edu.co.proyecto.modelo.RecepcionProductoEntity;
import uniandes.edu.co.proyecto.repositorio.RecepcionProductoRepositorio;

@RestController
@RequestMapping("/recepciones-productos")
public class RecepcionProductoController {

    @Autowired
    private RecepcionProductoRepositorio recepcionProductoRepositorio;

    // Obtener todas las recepciones de productos
    @GetMapping
    public ResponseEntity<Collection<RecepcionProductoEntity>> darRecepcionProductos() {
        try {
            Collection<RecepcionProductoEntity> recepciones = recepcionProductoRepositorio.darRecepcionProductos();
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
    public ResponseEntity<RecepcionProductoEntity> darRecepcionProducto(@PathVariable("id") int id) {
        try {
            RecepcionProductoEntity recepcion = recepcionProductoRepositorio.darRecepcionProducto(id);
            return recepcion != null ? new ResponseEntity<>(recepcion, HttpStatus.OK) : new ResponseEntity<>(HttpStatus.NOT_FOUND);
        } catch (Exception e) {

            return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    // Insertar una nueva recepción de producto
    @PostMapping
    public ResponseEntity<String> insertarRecepcionProducto(@RequestBody RecepcionProductoEntity recepcionProducto) {
        try {
            recepcionProductoRepositorio.insertarRecepcionProducto(recepcionProducto.getFechaRecepcion());
            return new ResponseEntity<>("Recepción de producto creada exitosamente", HttpStatus.CREATED);
        } catch (Exception e) {

            return new ResponseEntity<>("Error al crear la recepción de producto: " + e.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    // Actualizar una recepción de producto existente
    @PutMapping("/{id}")
    public ResponseEntity<String> actualizarRecepcionProducto(@PathVariable("id") int id, @RequestBody RecepcionProductoEntity recepcionProducto) {
        try {
            recepcionProductoRepositorio.actualizarRecepcionProducto(id, recepcionProducto.getFechaRecepcion());
            return new ResponseEntity<>("Recepción de producto actualizada exitosamente", HttpStatus.OK);
        } catch (Exception e) {

            return new ResponseEntity<>("Error al actualizar la recepción de producto: " + e.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    // Eliminar una recepción de producto
    @DeleteMapping("/{id}")
    public ResponseEntity<String> eliminarRecepcionProducto(@PathVariable("id") int id) {
        try {
            recepcionProductoRepositorio.eliminarRecepcionProducto(id);
            return new ResponseEntity<>("Recepción de producto eliminada exitosamente", HttpStatus.OK);
        } catch (Exception e) {

            return new ResponseEntity<>("Error al eliminar la recepción de producto: " + e.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
}
