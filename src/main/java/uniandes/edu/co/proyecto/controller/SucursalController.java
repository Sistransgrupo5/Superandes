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
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import uniandes.edu.co.proyecto.modelo.SucursalEntity;
import uniandes.edu.co.proyecto.repositorio.SucursalRepositorio;

@RestController
@RequestMapping("/sucursales")
public class SucursalController {

    @Autowired
    private SucursalRepositorio sucursalRepositorio;

    // Obtener todas las sucursales
    @GetMapping
    public ResponseEntity<Collection<SucursalEntity>> sucursales() {
        try {
            Collection<SucursalEntity> sucursales = sucursalRepositorio.darSucursales();
            if (sucursales.isEmpty()) {
                return new ResponseEntity<>(HttpStatus.NO_CONTENT);
            }
            return new ResponseEntity<>(sucursales, HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    // Consulta de sucursales con o sin producto disponible
    @GetMapping("/consulta")
    public ResponseEntity<?> sucursalConsulta(@RequestParam(required = false) Integer id_producto) {
        try {
            Collection<SucursalEntity> sucursales;
            if (id_producto == null) {
                sucursales = sucursalRepositorio.darSucursales();
            } else {
                sucursales = sucursalRepositorio.darSucursalesConProductoDisponible(id_producto);
            }
            if (sucursales.isEmpty()) {
                return ResponseEntity.status(HttpStatus.NOT_FOUND)
                        .body("No se encontraron sucursales con el criterio especificado.");
            }
            return ResponseEntity.ok(sucursales);
        } catch (Exception e) {
            return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    // Obtener una sucursal por ID
    @GetMapping("/{id}")
    public ResponseEntity<SucursalEntity> darSucursal(@PathVariable("id") int id) {
        try {
            SucursalEntity sucursal = sucursalRepositorio.darSucursal(id);
            if (sucursal != null) {
                return new ResponseEntity<>(sucursal, HttpStatus.OK);
            } else {
                return new ResponseEntity<>(HttpStatus.NOT_FOUND);
            }
        } catch (Exception e) {
            return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    // Insertar una nueva sucursal
    @PostMapping
    public ResponseEntity<String> insertarSucursal(@RequestBody SucursalEntity sucursal) {
        try {
            sucursalRepositorio.insertarSucursal(sucursal.getNombre(), sucursal.getTamanio(),
                    sucursal.getDireccion(), sucursal.getTelefono());
            return new ResponseEntity<>("Sucursal creada exitosamente", HttpStatus.CREATED);
        } catch (Exception e) {
            return new ResponseEntity<>("Error al crear la sucursal", HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    // Actualizar una sucursal existente
    @PutMapping("/{id}")
    public ResponseEntity<String> actualizarSucursal(@PathVariable("id") int id, @RequestBody SucursalEntity sucursal) {
        try {
            sucursalRepositorio.actualizarSucursal(id, sucursal.getNombre(), sucursal.getTamanio(),
                    sucursal.getDireccion(), sucursal.getTelefono());
            return new ResponseEntity<>("Sucursal actualizada exitosamente", HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>("Error al actualizar la sucursal", HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    // Eliminar una sucursal
    @DeleteMapping("/{id}")
    public ResponseEntity<String> eliminarSucursal(@PathVariable("id") int id) {
        try {
            sucursalRepositorio.eliminarSucursal(id);
            return new ResponseEntity<>("Sucursal eliminada exitosamente", HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>("Error al eliminar la sucursal", HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
}
