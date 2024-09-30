package uniandes.edu.co.proyecto.controller;

import java.util.Collection;
import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import uniandes.edu.co.proyecto.modelo.OrdenCompra;
import uniandes.edu.co.proyecto.repositorio.OrdenCompraRepository;

@RestController
public class OrdenCompraController {

    @Autowired
    private OrdenCompraRepository ordenCompraRepository;

    // Obtener todas las órdenes de compra
    @GetMapping("/ordenesCompra")
    public Collection<OrdenCompra> ordenesCompra() {
        return ordenCompraRepository.darOrdenesCompra();
    }

    // Guardar una nueva orden de compra
    @PostMapping("/ordenesCompra/new/save")
    public ResponseEntity<String> ordenCompraGuardar(@RequestBody OrdenCompra ordenCompra) {
        try {
            ordenCompraRepository.insertarOrdenCompra(ordenCompra.getFechaCreacion(), ordenCompra.getEstado(), ordenCompra.getFechaEntrega());
            return new ResponseEntity<>("Orden de compra creada exitosamente", HttpStatus.CREATED);
        } catch (Exception e) {
            return new ResponseEntity<>("Error al crear la orden de compra", HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    // Editar una orden de compra existente
    @PostMapping("/ordenesCompra/{id}/edit/save")
    public ResponseEntity<String> ordenCompraEditarGuardar(@PathVariable("id") int id, @RequestBody OrdenCompra ordenCompra) {
        try {
            ordenCompraRepository.actualizarOrdenCompra(id, ordenCompra.getFechaCreacion(), ordenCompra.getEstado(), ordenCompra.getFechaEntrega());
            return new ResponseEntity<>("Orden de compra actualizada exitosamente", HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>("Error al actualizar la orden de compra", HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    // Eliminar una orden de compra
    @GetMapping("/ordenesCompra/{id}/delete")
    public ResponseEntity<String> ordenCompraEliminar(@PathVariable("id") int id) {
        try {
            ordenCompraRepository.eliminarOrdenCompra(id);
            return new ResponseEntity<>("Orden de compra eliminada exitosamente", HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>("Error al eliminar la orden de compra", HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
}
