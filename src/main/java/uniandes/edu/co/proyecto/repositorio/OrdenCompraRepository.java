package uniandes.edu.co.proyecto.repositorio;

import java.util.Collection;
import java.util.Date;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.transaction.annotation.Transactional;

import uniandes.edu.co.proyecto.modelo.OrdenCompraEntity;

public interface OrdenCompraRepository extends JpaRepository<OrdenCompraEntity, Integer> {

    @Query(value = "SELECT * FROM OrdenCompra", nativeQuery = true)
    Collection<OrdenCompraEntity> darOrdenCompras();

    @Query(value = "SELECT * FROM OrdenCompra WHERE id = :id", nativeQuery = true)
    OrdenCompraEntity darOrdenCompra(@Param("id") int id);

    @Modifying
    @Transactional
    @Query(value = "INSERT INTO OrdenCompra(fechaCreacion, estado, fechaEntrega) VALUES(:fechaCreacion, :estado, :fechaEntrega)", nativeQuery = true)
    void insertarOrdenCompra(@Param("fechaCreacion") Date fechaCreacion, @Param("estado") String estado, @Param("fechaEntrega") Date fechaEntrega);

    @Modifying
    @Transactional
    @Query(value = "UPDATE OrdenCompra SET fechaCreacion = :fechaCreacion, estado = :estado, fechaEntrega = :fechaEntrega WHERE id = :id", nativeQuery = true)
    void actualizarOrdenCompra(@Param("id") int id, @Param("fechaCreacion") Date fechaCreacion, @Param("estado") String estado, @Param("fechaEntrega") Date fechaEntrega);

    @Modifying
    @Transactional
    @Query(value = "DELETE FROM OrdenCompra WHERE id = :id", nativeQuery = true)
    void eliminarOrdenCompra(@Param("id") int id);
}
