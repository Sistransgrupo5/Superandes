package uniandes.edu.co.proyecto.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

// Controlador principal
@RestController
public class HomeController {

    @Autowired
    private ProductoController productoController;

    @Autowired
    private ProveedorController proveedorController;

    @Autowired
    private SucursalController sucursalController;

    @Autowired
    private VentaController ventaController;

    @Autowired
    private RecepcionProductoController recepcionProductoController;

    @GetMapping("/")
    public String home() {
        StringBuilder response = new StringBuilder();
        return null;

    }
}
