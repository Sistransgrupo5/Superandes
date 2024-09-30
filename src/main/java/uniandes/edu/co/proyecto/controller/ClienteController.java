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

import uniandes.edu.co.proyecto.modelo.Cliente;
import uniandes.edu.co.proyecto.repositorio.ClienteRepository;

@RestController
public class ClienteController {

    @Autowired
    private ClienteRepository clienteRepository;

    // Obtener todos los clientes
    @GetMapping("/clientes")
    public Collection<Cliente> clientes() {
        return clienteRepository.darClientes();
    }

    // Guardar un nuevo cliente
    @PostMapping("/clientes/new/save")
    public ResponseEntity<String> clienteGuardar(@RequestBody Cliente cliente) {
        try {
            clienteRepository.insertarCliente(cliente.getNombre());
            return new ResponseEntity<>("Cliente creado exitosamente", HttpStatus.CREATED);
        } catch (Exception e) {
            return new ResponseEntity<>("Error al crear el cliente", HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    // Editar un cliente existente
    @PostMapping("/clientes/{cedula}/edit/save")
    public ResponseEntity<String> clienteEditarGuardar(@PathVariable("cedula") int cedula, @RequestBody Cliente cliente) {
        try {
            clienteRepository.actualizarCliente(cedula, cliente.getNombre());
            return new ResponseEntity<>("Cliente actualizado exitosamente", HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>("Error al actualizar el cliente", HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    // Eliminar un cliente
    @GetMapping("/clientes/{cedula}/delete")
    public ResponseEntity<String> clienteEliminar(@PathVariable("cedula") int cedula) {
        try {
            clienteRepository.eliminarCliente(cedula);
            return new ResponseEntity<>("Cliente eliminado exitosamente", HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>("Error al eliminar el cliente", HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
}
