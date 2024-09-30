package uniandes.edu.co.proyecto.repositorio;

import java.util.Collection;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.transaction.annotation.Transactional;

import uniandes.edu.co.proyecto.modelo.Categoria;


public interface CategoriaRepository extends JpaRepository<Categoria, Integer>{

    @Query(value = "SELECT * FROM categorias")
    Collection<Categoria> darCategorias();

    @Query(value = "SELECT * FROM categorias WHERE codigo= : codigo", nativeQuery=true)
    Categoria darCategoria(@Param("codigo") int codigo);

    @Modifying
    @Transactional
    @Query(value = "UPDATE categorias SET nombre=:nombre, descripcion=:descripcion WHERE codigo=:codigo", nativeQuery = true)
    void actualizarCategoria(@Param("codigo") int codigo, @Param("nombre") String nombre, @Param("descripcion") String descripcion, @Param("caracteristicas") String caracteristicas);

    @Modifying
    @Transactional
    @Query(value = "DELETE FROM categorias WHERE codigo = :codigo", nativeQuery = true)
    void eliminarCategoria(@Param("codigo") int codigo);
    
}
