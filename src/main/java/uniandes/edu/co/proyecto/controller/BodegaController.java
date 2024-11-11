package uniandes.edu.co.proyecto.controller;

import java.util.Collection;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import uniandes.edu.co.proyecto.modelo.BodegaEntity;
import uniandes.edu.co.proyecto.repositorio.BodegaRepository;

@RestController
public class BodegaController {

    @Autowired
    private BodegaRepository bodegaRepository;

    @GetMapping("/bodegas")
    public Collection<BodegaEntity> bodegas() {
        return bodegaRepository.darBodegas();
    }

    @PostMapping("/bodegas/new/save")
    public ResponseEntity<String> bodegaGuardar(@RequestBody BodegaEntity bodega) {
        try {
            bodegaRepository.insertarBodega(bodega.getNombre(), bodega.getTamanio());
            return new ResponseEntity<>("BodegaEntity creada exitosamente", HttpStatus.CREATED);
        } catch (Exception e) {

            return new ResponseEntity<>("Error al crear la bodega", HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @PostMapping("/bodegas/{id}/edit/save")
    public ResponseEntity<String> bodegaEditarGuardar(@PathVariable("id") long id, @RequestBody BodegaEntity bodega) {
        try {
            bodegaRepository.actualizarBodega((int) id, bodega.getNombre(), bodega.getTamanio());
            return new ResponseEntity<>("BodegaEntity actualizada exitosamente", HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>("Error al actualizar la bodega", HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @GetMapping("/bodegas/{id}/delete")
    public ResponseEntity<String> bodegaEliminar(@PathVariable("id") int id) {
        try {
            bodegaRepository.eliminarBodega(id);
            return new ResponseEntity<>("BodegaEntity eliminada exitosamente", HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>("Error al eliminar la bodega", HttpStatus.INTERNAL_SERVER_ERROR);
        }

    }

    @GetMapping("/bodegas/sucursal/{id_sucursal}")
public ResponseEntity<?> obtenerBodegasPorSucursal(@PathVariable("id_sucursal") Integer idSucursal) {
    try {
        Collection<BodegaEntity> bodegas = bodegaRepository.darBodegasPorSucursal(idSucursal);

        if (bodegas.isEmpty()) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND)
                                .body("No se encontraron bodegas para la sucursal especificada.");
        }

        return ResponseEntity.ok(bodegas);

    } catch (Exception e) {
        return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Error en la consulta de bodegas");
    }
}

}
