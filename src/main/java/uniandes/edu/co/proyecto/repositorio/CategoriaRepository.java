package uniandes.edu.co.proyecto.repositorio;

import java.util.Collection;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.transaction.annotation.Transactional;

import uniandes.edu.co.proyecto.modelo.CategoriaEntity;


public interface CategoriaRepository extends JpaRepository<CategoriaEntity, Integer>{

    @Query(value = "SELECT * FROM Categoria", nativeQuery = true)
    Collection<CategoriaEntity> darCategorias();

    @Query(value = "SELECT * FROM Categoria WHERE codigo= : codigo", nativeQuery=true)
    CategoriaEntity darCategoria(@Param("codigo") long codigo);

    @Modifying
    @Transactional
    @Query(value = "INSERT INTO Categoria(codigo, nombre, descripcion, caracteristicas) VALUES(:codigo, :nombre, :descripcion, :caracteristicas)", nativeQuery = true)
    void insertarCategoria(
        @Param("codigo") Integer codigo,
        @Param("nombre") String nombre,
        @Param("descripcion") String descripcion,
        @Param("caracteristicas") String caracteristicas
    );

    @Modifying
    @Transactional
    @Query(value = "UPDATE Categoria SET nombre=:nombre, descripcion=:descripcion, caracteristicas=:caracteristicas WHERE codigo=:codigo", nativeQuery = true)
    void actualizarCategoria(@Param("codigo") long codigo, @Param("nombre") String nombre, @Param("descripcion") String descripcion, @Param("caracteristicas") String caracteristicas);

    @Modifying
    @Transactional
    @Query(value = "DELETE FROM Categoria WHERE codigo = :codigo", nativeQuery = true)
    void eliminarCategoria(@Param("codigo") long codigo);
}
