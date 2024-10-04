package uniandes.edu.co.proyecto.repositorio;

import java.util.Collection;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.transaction.annotation.Transactional;

import uniandes.edu.co.proyecto.modelo.BodegaEntity;

public interface BodegaRepository extends JpaRepository<BodegaEntity, Integer> {

    @Query(value = "SELECT * FROM Bodega", nativeQuery = true)
    Collection<BodegaEntity> darBodegas();

    @Query(value = "SELECT * FROM Bodega WHERE id_bodega = :id", nativeQuery = true)
    BodegaEntity darBodega(@Param("id") int id);

    @Modifying
    @Transactional
    @Query(value = "INSERT INTO Bodega(id_bodega, nombre, tamanio) VALUES(proyecto_sequence.nextval, :nombre, :tamanio)", nativeQuery = true)
    void insertarBodega(@Param("nombre") String nombre, @Param("tamanio") int tamanio);

    @Modifying
    @Transactional
    @Query(value = "UPDATE Bodega SET nombre=:nombre, tamanio=:tamanio WHERE id_bodega=:id", nativeQuery = true)
    void actualizarBodega(@Param("id") int id, @Param("nombre") String nombre, @Param("tamanio") int tamanio);

    @Modifying
    @Transactional
    @Query(value = "DELETE FROM Bodega WHERE id_bodega = :id", nativeQuery = true)
    void eliminarBodega(@Param("id") int id);
}
