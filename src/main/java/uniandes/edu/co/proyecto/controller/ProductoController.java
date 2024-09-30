package uniandes.edu.co.proyecto.controller;

import java.util.Collection;
import java.util.Date;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import uniandes.edu.co.proyecto.modelo.Producto;
import uniandes.edu.co.proyecto.repositorio.ProductoRepository;

@RestController
@RequestMapping("/productos")
public class ProductoController {

    @Autowired
    private ProductoRepository productoRepository;

    // Obtener todos los productos
    @GetMapping("/all")
    public ResponseEntity<Collection<Producto>> darProductos() {
        try {
            Collection<Producto> productos = productoRepository.darProductos();
            return new ResponseEntity<>(productos, HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    // Obtener un producto por código de barras
    @GetMapping("/{codigoBarras}")
    public ResponseEntity<Producto> darProducto(@PathVariable("codigoBarras") String codigoBarras) {
        try {
            Producto producto = productoRepository.darProducto(codigoBarras);
            if (producto != null) {
                return new ResponseEntity<>(producto, HttpStatus.OK);
            } else {
                return new ResponseEntity<>(HttpStatus.NOT_FOUND);
            }
        } catch (Exception e) {
            return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    // Insertar un nuevo producto
    @PostMapping("/new")
    public ResponseEntity<String> insertarProducto(@RequestBody Producto producto) {
        try {
            productoRepository.insertarProducto(
                    producto.getNombre(),
                    producto.getPrecioUnitarioVenta(),
                    producto.getPresentacion(),
                    producto.getCantidadPresentacion(),
                    producto.getUnidadMedida(),
                    producto.getFechaExpiracion());
            return new ResponseEntity<>("Producto creado exitosamente", HttpStatus.CREATED);
        } catch (Exception e) {
            return new ResponseEntity<>("Error al crear el producto", HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    // Actualizar un producto existente
    @PutMapping("/{codigoBarras}/edit")
    public ResponseEntity<String> actualizarProducto(@PathVariable("codigoBarras") String codigoBarras,
            @RequestBody Producto producto) {
        try {
            productoRepository.actualizarProducto(codigoBarras,
                    producto.getNombre(),
                    producto.getPrecioUnitarioVenta(),
                    producto.getPresentacion(),
                    producto.getCantidadPresentacion(),
                    producto.getUnidadMedida(),
                    producto.getFechaExpiracion());
            return new ResponseEntity<>("Producto actualizado exitosamente", HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>("Error al actualizar el producto", HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    // Eliminar un producto por código de barras
    @DeleteMapping("/{codigoBarras}/delete")
    public ResponseEntity<String> eliminarProducto(@PathVariable("codigoBarras") String codigoBarras) {
        try {
            productoRepository.eliminarProducto(codigoBarras);
            return new ResponseEntity<>("Producto eliminado exitosamente", HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>("Error al eliminar el producto", HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
}
