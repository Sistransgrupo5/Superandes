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

import uniandes.edu.co.proyecto.modelo.OrdenCompraEntity;
import uniandes.edu.co.proyecto.repositorio.OrdenCompraRepository;

@RestController
@RequestMapping("/ordenesCompra")
public class OrdenCompraController {

    @Autowired
    private OrdenCompraRepository ordenCompraRepository;

    // Obtener todas las órdenes de compra
    @GetMapping
    public Collection<OrdenCompraEntity> ordenesCompra() {
        return ordenCompraRepository.darOrdenCompras();
    }

    // Guardar una nueva orden de compra
    @PostMapping("/new")
    public ResponseEntity<String> ordenCompraGuardar(@RequestBody OrdenCompraEntity ordenCompra) {
        try {
            ordenCompraRepository.insertarOrdenCompra(
                ordenCompra.getFechaCreacion(),
                ordenCompra.getEstado(),
                ordenCompra.getFechaEntrega()
            );
            return new ResponseEntity<>("Orden de compra creada exitosamente", HttpStatus.CREATED);
        } catch (Exception e) {

            return new ResponseEntity<>("Error al crear la orden de compra: " + e.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    // Editar una orden de compra existente
    @PutMapping("/{id}")
    public ResponseEntity<String> ordenCompraEditarGuardar(@PathVariable("id") int id, @RequestBody OrdenCompraEntity ordenCompra) {
        try {
            ordenCompraRepository.actualizarOrdenCompra(
                id,
                ordenCompra.getFechaCreacion(),
                ordenCompra.getEstado(),
                ordenCompra.getFechaEntrega()
            );
            return new ResponseEntity<>("Orden de compra actualizada exitosamente", HttpStatus.OK);
        } catch (Exception e) {

            return new ResponseEntity<>("Error al actualizar la orden de compra: " + e.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    // Eliminar una orden de compra
    @DeleteMapping("/{id}")
    public ResponseEntity<String> ordenCompraEliminar(@PathVariable("id") int id) {
        try {
            ordenCompraRepository.eliminarOrdenCompra(id);
            return new ResponseEntity<>("Orden de compra eliminada exitosamente", HttpStatus.OK);
        } catch (Exception e) {

            return new ResponseEntity<>("Error al eliminar la orden de compra: " + e.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
}
