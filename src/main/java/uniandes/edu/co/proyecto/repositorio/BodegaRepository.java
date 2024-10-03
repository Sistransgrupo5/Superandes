package uniandes.edu.co.proyecto.repositorio;

import java.util.Collection;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.transaction.annotation.Transactional;

import uniandes.edu.co.proyecto.modelo.BodegaEntity;

public interface BodegaRepository extends JpaRepository<BodegaEntity, Integer> {

    @Query(value = "SELECT * FROM bodegas", nativeQuery = true)
    Collection<BodegaEntity> darBodegas();

    @Query(value = "SELECT * FROM bodegas WHERE id= : id", nativeQuery = true)
    BodegaEntity darBodega(@Param("id") long id);

    @Modifying
    @Transactional
    @Query(value = "INSERT INTO bodegas(id,nombre,tamanio) VALUES(proyecto_sequence.nextval, :nombre, :tamanio)", nativeQuery = true)
    void insertarBodega(@Param("nombre") String nombre, @Param("tamanio") Integer tamanio);

    @Modifying
    @Transactional
    @Query(value = "UPDATE bodegas SET nombre=:nombre, tamanio=:tamanio WHERE id=:id", nativeQuery = true)
    void actualizarBodega(@Param("id") long id, @Param("nombre") String nombre, @Param("tamanio") Integer tamanio);

    @Modifying
    @Transactional
    @Query(value = "DELETE FROM bodegas WHERE id = :id", nativeQuery = true)
    void eliminarBodega(@Param("id") long id);

}
