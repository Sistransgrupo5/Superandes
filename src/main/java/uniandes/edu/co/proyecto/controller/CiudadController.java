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

import uniandes.edu.co.proyecto.modelo.CiudadEntity;
import uniandes.edu.co.proyecto.repositorio.CiudadRepository;

@RestController
public class CiudadController {

    @Autowired
    private CiudadRepository ciudadRepository;

    @GetMapping("/ciudades")
    public Collection<CiudadEntity> ciudades() {
        return ciudadRepository.darCiudades();
    }

    @PostMapping("/ciudades/new/save")
    public ResponseEntity<String> ciudadGuardar(@RequestBody CiudadEntity ciudad) {
        try {
            ciudadRepository.insertarCiudad(ciudad.getNombre());
            return new ResponseEntity<>("CiudadEntity creada exitosamente", HttpStatus.CREATED);
        } catch (Exception e) {

            return new ResponseEntity<>("Error al crear la ciudad", HttpStatus.INTERNAL_SERVER_ERROR);
        }

    }

    @PostMapping("/ciudades/{codigo}/edit/save")
    public ResponseEntity<String> ciudadEditarGuardar(@PathVariable("codigo") long codigo, @RequestBody CiudadEntity ciudad) {
        try {
            ciudadRepository.actualizarCiudad(codigo, ciudad.getNombre());
            return new ResponseEntity<>("CiudadEntity actualizada exitosamente", HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>("Error al actualizar la ciudad", HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @GetMapping("/ciudades/{codigo}/delete")
    public ResponseEntity<String> ciudadEliminar(@PathVariable("codigo") long codigo) {
        try {
            ciudadRepository.eliminarCiudad(codigo);
            return new ResponseEntity<>("CiudadEntity eliminada exitosamente", HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>("Error al eliminar la ciudad", HttpStatus.INTERNAL_SERVER_ERROR);
        }

    }

}
