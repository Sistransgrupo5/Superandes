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

import uniandes.edu.co.proyecto.modelo.ProveedorEntity;
import uniandes.edu.co.proyecto.repositorio.ProveedorRepository;

@RestController
@RequestMapping("/Proveedor")
public class ProveedorController {

    @Autowired
    private ProveedorRepository proveedorRepository;

    // Obtener todos los proveedores
    @GetMapping
    public Collection<ProveedorEntity> darProveedores() {
        try {
            Collection<ProveedorEntity> proveedores = proveedorRepository.darProveedores();
            if (proveedores.isEmpty()) {
                return null;
            }
            return proveedores;
        } catch (Exception e) {

            return null;
        }
    }

    // Obtener un proveedor por NIT
    @GetMapping("/{NIT}")
    public ResponseEntity<ProveedorEntity> darProveedor(@PathVariable("NIT") String NIT) {
        try {
            ProveedorEntity proveedor = proveedorRepository.darProveedor(NIT);
            return proveedor != null ? new ResponseEntity<>(proveedor, HttpStatus.OK) : new ResponseEntity<>(HttpStatus.NOT_FOUND);
        } catch (Exception e) {

            return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    // Insertar un nuevo proveedor
    @PostMapping
    public ResponseEntity<String> insertarProveedor(@RequestBody ProveedorEntity proveedor) {
        try {
            proveedorRepository.insertarProveedor(
                    proveedor.getNombre(),
                    proveedor.getDireccion(),
                    proveedor.getNombre_contacto(),
                    proveedor.getTelefono());
            return new ResponseEntity<>("Proveedor creado exitosamente", HttpStatus.CREATED);
        } catch (Exception e) {

            return new ResponseEntity<>("Error al crear el proveedor: " + e.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    // Actualizar un proveedor existente
    @PutMapping("/{NIT}")
    public ResponseEntity<String> actualizarProveedor(@PathVariable("NIT") String NIT, @RequestBody ProveedorEntity proveedor) {
        try {
            proveedorRepository.actualizarProveedor(
                    NIT,
                    proveedor.getNombre(),
                    proveedor.getDireccion(),
                    proveedor.getNombre_contacto(),
                    proveedor.getTelefono());
            return new ResponseEntity<>("Proveedor actualizado exitosamente", HttpStatus.OK);
        } catch (Exception e) {

            return new ResponseEntity<>("Error al actualizar el proveedor: " + e.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    // Eliminar un proveedor
    @DeleteMapping("/{NIT}")
    public ResponseEntity<String> eliminarProveedor(@PathVariable("NIT") String NIT) {
        try {
            proveedorRepository.eliminarProveedor(NIT);
            return new ResponseEntity<>("Proveedor eliminado exitosamente", HttpStatus.OK);
        } catch (Exception e) {

            return new ResponseEntity<>("Error al eliminar el proveedor: " + e.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    // Obtener proveedores por dirección
    @GetMapping("/direccion/{direccion}")
    public ResponseEntity<Collection<ProveedorEntity>> obtenerProveedoresPorDireccion(@PathVariable("direccion") String direccion) {
        try {
            Collection<ProveedorEntity> proveedores = proveedorRepository.darProveedorPorDireccion(direccion);
            if (proveedores.isEmpty()) {
                return new ResponseEntity<>(HttpStatus.NO_CONTENT);
            }
            return new ResponseEntity<>(proveedores, HttpStatus.OK);
        } catch (Exception e) {

            return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
}
