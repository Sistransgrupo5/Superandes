package uniandes.edu.co.proyecto.repositorio;

import java.util.Collection;
import java.util.Date;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.transaction.annotation.Transactional;

import uniandes.edu.co.proyecto.modelo.RecepcionProductoEntity;

public interface RecepcionProductoRepositorio extends JpaRepository<RecepcionProductoEntity, Integer> {

    @Query(value = "SELECT * FROM RecepcionProducto", nativeQuery = true)
    Collection<RecepcionProductoEntity> darRecepcionProductos();

    @Query(value = "SELECT * FROM RecepcionProducto WHERE id= : id", nativeQuery = true)
    RecepcionProductoEntity darRecepcionProducto(@Param("id") int id);

    @Modifying
    @Transactional
    @Query(value = "INSERT INTO RecepcionProducto(id,fechaRecepcion) VALUES(proyecto_sequence.nextval, :fechaRecepcion)", nativeQuery = true)
    void insertarRecepcionProducto(@Param("fechaRecepcion") Date fechaRecepcion);

    @Modifying
    @Transactional
    @Query(value = "UPDATE RecepcionProducto SET fechaRecepcion=:fechaRecepcion WHERE id=:id", nativeQuery = true)
    void actualizarRecepcionProducto(@Param("id") int id, @Param("fechaRecepcion") Date fechaRecepcion);

    @Modifying
    @Transactional
    @Query(value = "DELETE FROM RecepcionProducto WHERE id = :id", nativeQuery = true)
    void eliminarRecepcionProducto(@Param("id") int id);
}
