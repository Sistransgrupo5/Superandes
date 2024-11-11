/* package uniandes.edu.co.proyecto.controller;

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

import uniandes.edu.co.proyecto.modelo.ProductoEntity;
import uniandes.edu.co.proyecto.repositorio.ProductoRepository;

@RestController
@RequestMapping("/Producto")
public class ProductoController {

    @Autowired
    private ProductoRepository productoRepository;


    // Obtener todos los productos
    @GetMapping
    public ResponseEntity<Collection<ProductoEntity>> darProductos() {
        try {
            Collection<ProductoEntity> productos = productoRepository.darProductos();
            System.out.println(productos);
            return new ResponseEntity<>(productos, HttpStatus.OK);
        } catch (Exception e) {
            e.printStackTrace();
            return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    // Obtener un producto por código de barras
    @GetMapping("/{codigoBarras}")
    public ResponseEntity<ProductoEntity> darProducto(@PathVariable("codigoBarras") String codigoBarras) {
        try {
            ProductoEntity producto = productoRepository.darProducto(codigoBarras);
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
    @PostMapping
    public ResponseEntity<String> insertarProducto(@RequestBody ProductoEntity producto) {
        try {
            productoRepository.insertarProducto(
                producto.getNombre(),
                producto.getPrecioUnitarioVenta(),
                producto.getPresentacion(),
                producto.getCantidadPresentacion(),
                producto.getUnidadMedida(),
                producto.getFechaExpiracion()
            );
            return new ResponseEntity<>("Producto creado exitosamente", HttpStatus.CREATED);
        } catch (Exception e) {

            return new ResponseEntity<>("Error al crear el producto: " + e.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    // Actualizar un producto existente
    @PutMapping("/{codigoBarras}")
    public ResponseEntity<String> actualizarProducto(@PathVariable("codigoBarras") String codigoBarras,
                                                    @RequestBody ProductoEntity producto) {
        try {
            productoRepository.actualizarProducto(
                codigoBarras,
                producto.getNombre(),
                producto.getPrecioUnitarioVenta(),
                producto.getPresentacion(),
                producto.getCantidadPresentacion(),
                producto.getUnidadMedida(),
                producto.getFechaExpiracion()
            );
            return new ResponseEntity<>("Producto actualizado exitosamente", HttpStatus.OK);
        } catch (Exception e) {

            return new ResponseEntity<>("Error al actualizar el producto: " + e.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    // Eliminar un producto por código de barras
    @DeleteMapping("/{codigoBarras}")
    public ResponseEntity<String> eliminarProducto(@PathVariable("codigoBarras") String codigoBarras) {
        try {
            productoRepository.eliminarProducto(codigoBarras);
            return new ResponseEntity<>("Producto eliminado exitosamente", HttpStatus.OK);
        } catch (Exception e) {

            return new ResponseEntity<>("Error al eliminar el producto: " + e.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
}
 */
package uniandes.edu.co.proyecto.controller;

import java.util.Collection;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import uniandes.edu.co.proyecto.modelo.ProductoEntity;
import uniandes.edu.co.proyecto.repositorio.ProductoRepository;

@RestController
public class ProductoController {

    @Autowired
    private ProductoRepository productoRepository;

    // Obtener todos los productos
    @GetMapping("/productos")
    public Collection<ProductoEntity> obtenerProductos() {
        return productoRepository.darProductos();
    }

    // Crear un nuevo producto
    @PostMapping("/productos/new/save")
    public ResponseEntity<String> guardarProducto(@RequestBody ProductoEntity producto) {
        try {
            productoRepository.save(producto);
            return new ResponseEntity<>("ProductoEntity creado exitosamente", HttpStatus.CREATED);
        } catch (Exception e) {
            return new ResponseEntity<>("Error al crear el producto", HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    // Actualizar un producto existente
    @PostMapping("/productos/{id}/edit/save")
    public ResponseEntity<String> actualizarProducto(@PathVariable("id") Integer id, @RequestBody ProductoEntity producto) {
        try {
            if (productoRepository.existsById(id)) {
                producto.setId(id);
                productoRepository.save(producto);
                return new ResponseEntity<>("ProductoEntity actualizado exitosamente", HttpStatus.OK);
            } else {
                return new ResponseEntity<>("Producto no encontrado", HttpStatus.NOT_FOUND);
            }
        } catch (Exception e) {
            return new ResponseEntity<>("Error al actualizar el producto", HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    // Eliminar un producto
    @DeleteMapping("/productos/{id}/delete")
    public ResponseEntity<String> eliminarProducto(@PathVariable("id") Integer id) {
        try {
            if (productoRepository.existsById(id)) {
                productoRepository.deleteById(id);
                return new ResponseEntity<>("ProductoEntity eliminado exitosamente", HttpStatus.OK);
            } else {
                return new ResponseEntity<>("Producto no encontrado", HttpStatus.NOT_FOUND);
            }
        } catch (Exception e) {
            return new ResponseEntity<>("Error al eliminar el producto", HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }


}

