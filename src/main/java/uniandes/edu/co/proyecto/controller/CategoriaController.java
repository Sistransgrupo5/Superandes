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

import uniandes.edu.co.proyecto.modelo.CategoriaEntity;
import uniandes.edu.co.proyecto.repositorio.CategoriaRepository;

@RestController
@RequestMapping("/categorias")
public class CategoriaController {

    @Autowired
    private CategoriaRepository categoriaRepository;

    // Obtener todas las categorías
    @GetMapping
    public Collection<CategoriaEntity> categorias() {
        return categoriaRepository.darCategorias();
    }

    // Crear una nueva categoría
    @PostMapping("/new")
    public ResponseEntity<String> categoriaGuardar(@RequestBody CategoriaEntity categoria) {
        try {
            categoriaRepository.insertarCategoria(
                categoria.getCodigo(),
                categoria.getNombre(),
                categoria.getDescripcion(),
                categoria.getCaracteristicas()
            );
            return new ResponseEntity<>("CategoriaEntity creada exitosamente", HttpStatus.CREATED);
        } catch (Exception e) {
            return new ResponseEntity<>("Error al crear la categoria: " + e.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    // Editar una categoría existente
    @PutMapping("/{codigo}")
    public ResponseEntity<String> categoriaEditarGuardar(
        @PathVariable("codigo") long codigo,
        @RequestBody CategoriaEntity categoria
    ) {
        try {
            categoriaRepository.actualizarCategoria(
                codigo,
                categoria.getNombre(),
                categoria.getDescripcion(),
                categoria.getCaracteristicas()
            );
            return new ResponseEntity<>("CategoriaEntity actualizada exitosamente", HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>("Error al actualizar la categoria: " + e.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    // Eliminar una categoría
    @DeleteMapping("/{codigo}")
    public ResponseEntity<String> categoriaEliminar(@PathVariable("codigo") long codigo) {
        try {
            categoriaRepository.eliminarCategoria(codigo);
            return new ResponseEntity<>("CategoriaEntity eliminada exitosamente", HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>("Error al eliminar la categoria: " + e.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
}
