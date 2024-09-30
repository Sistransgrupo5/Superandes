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

import uniandes.edu.co.proyecto.modelo.Categoria;
import uniandes.edu.co.proyecto.repositorio.CategoriaRepository;

@RestController
public class CategoriaController {

    @Autowired
    private CategoriaRepository categoriaRepository;

    @GetMapping("/categorias")
    public Collection<Categoria> categorias()
    {
        return categoriaRepository.darCategorias();
    }

    @PostMapping("/categorias/new/save)")
    public ResponseEntity<String> categoriaGuardar (@RequestBody Categoria categoria)
    {
        try
        {
            categoriaRepository.insertarCategoria(categoria.getNombre(), categoria.getDescripcion(), categoria.getCaracteristicas());
            return new ResponseEntity<>("Categoria creada exitosamente", HttpStatus.CREATED);
        }
        catch(Exception e) {
            return new ResponseEntity<>("Error al crear la categoria", HttpStatus.INTERNAL_SERVER_ERROR);

        }
    }


    @PostMapping("/categorias/{codigo}/edit/save")
    public ResponseEntity<String> categoriaEditarGuardar(@PathVariable("codigo") long codigo, @RequestBody Categoria categoria)
    {
        try {
            categoriaRepository.actualizarCategoria(codigo, categoria.getNombre(), categoria.getDescripcion(),categoria.getCaracteristicas());
            return new ResponseEntity<>("Categoria actualizada exitosamente",HttpStatus.OK);
        }
        catch(Exception e)
        {
            return new ResponseEntity<>("Error al actualizar la categoria",HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @GetMapping("/categorias/{codigo}/delete")
    public ResponseEntity<String> categoriaEliminar(@PathVariable("codigo") long codigo)
    {
        try{
            categoriaRepository.eliminarCategoria(codigo);
            return new ResponseEntity<>("Categoria eliminada exitosamente", HttpStatus.OK);
        }

        catch(Exception e)
        {
            return new ResponseEntity<>("Error al eliminar la categoria",HttpStatus.INTERNAL_SERVER_ERROR);
        }
        
    }

    
}
