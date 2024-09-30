package uniandes.edu.co.proyecto.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import uniandes.edu.co.proyecto.modelo.Proveedor;
import uniandes.edu.co.proyecto.repositorio.ProveedorRepository;

import java.util.Collection;

@RestController
@RequestMapping("/proveedores")
public class ProveedorController {

    @Autowired
    private ProveedorRepository proveedorRepository;

    // Obtener todos los proveedores
    @GetMapping
    public ResponseEntity<Collection<Proveedor>> darProveedores() {
        try {
            Collection<Proveedor> proveedores = proveedorRepository.darProveedores();
            if (proveedores.isEmpty()) {
                return new ResponseEntity<>(HttpStatus.NO_CONTENT);
            }
            return new ResponseEntity<>(proveedores, HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    // Obtener un proveedor por NIT
    @GetMapping("/{NIT}")
    public ResponseEntity<Proveedor> darProveedor(@PathVariable("NIT") String NIT) {
        try {
            Proveedor proveedor = proveedorRepository.darProveedor(NIT);
            if (proveedor != null) {
                return new ResponseEntity<>(proveedor, HttpStatus.OK);
            } else {
                return new ResponseEntity<>(HttpStatus.NOT_FOUND);
            }
        } catch (Exception e) {
            return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    // Insertar un nuevo proveedor
    @PostMapping("/new")
    public ResponseEntity<String> insertarProveedor(@RequestBody Proveedor proveedor) {
        try {
            proveedorRepository.insertarProveedor(proveedor.getNombre(),
                    proveedor.getDireccion(),
                    proveedor.getNombre_contacto(),
                    proveedor.getTelefono());
            return new ResponseEntity<>("Proveedor creado exitosamente", HttpStatus.CREATED);
        } catch (Exception e) {
            return new ResponseEntity<>("Error al crear el proveedor", HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    // Actualizar un proveedor existente
    @PutMapping("/{NIT}")
    public ResponseEntity<String> actualizarProveedor(@PathVariable("NIT") String NIT, @RequestBody Proveedor proveedor) {
        try {
            proveedorRepository.actualizarProveedor(NIT,
                    proveedor.getNombre(),
                    proveedor.getDireccion(),
                    proveedor.getNombre_contacto(),
                    proveedor.getTelefono());
            return new ResponseEntity<>("Proveedor actualizado exitosamente", HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>("Error al actualizar el proveedor", HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    // Eliminar un proveedor
    @DeleteMapping("/{NIT}")
    public ResponseEntity<String> eliminarProveedor(@PathVariable("NIT") String NIT) {
        try {
            proveedorRepository.eliminarProveedor(NIT);
            return new ResponseEntity<>("Proveedor eliminado exitosamente", HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>("Error al eliminar el proveedor", HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
}