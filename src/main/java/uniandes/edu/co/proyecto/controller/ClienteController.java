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

import uniandes.edu.co.proyecto.modelo.ClienteEntity;
import uniandes.edu.co.proyecto.repositorio.ClienteRepository;

@RestController
@RequestMapping("/clientes")
public class ClienteController {

    @Autowired
    private ClienteRepository clienteRepository;

    // Obtener todos los clientes
    @GetMapping
    public Collection<ClienteEntity> clientes() {
        return clienteRepository.darClientes();
    }

    // Guardar un nuevo cliente
    @PostMapping("/new")
    public ResponseEntity<String> clienteGuardar(@RequestBody ClienteEntity cliente) {
        try {
            clienteRepository.insertarCliente(cliente.getNombre());
            return new ResponseEntity<>("ClienteEntity creado exitosamente", HttpStatus.CREATED);
        } catch (Exception e) {

            return new ResponseEntity<>("Error al crear el cliente: " + e.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    // Editar un cliente existente
    @PutMapping("/{cedula}")
    public ResponseEntity<String> clienteEditarGuardar(@PathVariable("cedula") int cedula, @RequestBody ClienteEntity cliente) {
        try {
            clienteRepository.actualizarCliente(cedula, cliente.getNombre());
            return new ResponseEntity<>("ClienteEntity actualizado exitosamente", HttpStatus.OK);
        } catch (Exception e) {

            return new ResponseEntity<>("Error al actualizar el cliente: " + e.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    // Eliminar un cliente
    @DeleteMapping("/{cedula}")
    public ResponseEntity<String> clienteEliminar(@PathVariable("cedula") int cedula) {
        try {
            clienteRepository.eliminarCliente(cedula);
            return new ResponseEntity<>("ClienteEntity eliminado exitosamente", HttpStatus.OK);
        } catch (Exception e) {

            return new ResponseEntity<>("Error al eliminar el cliente: " + e.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
}
