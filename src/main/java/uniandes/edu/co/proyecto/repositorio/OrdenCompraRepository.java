package uniandes.edu.co.proyecto.repositorio;

import java.util.Collection;
import java.util.Date;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.transaction.annotation.Transactional;
import uniandes.edu.co.proyecto.modelo.OrdenCompra;

public interface OrdenCompraRepository extends JpaRepository<OrdenCompra, Integer> {

    @Query(value = "SELECT * FROM ordenesCompra", nativeQuery = true)
    Collection<OrdenCompra> darOrdenesCompra();

    @Query(value = "SELECT * FROM ordenesCompra WHERE id = :id", nativeQuery = true)
    OrdenCompra darOrdenCompra(@Param("id") int id);

    @Modifying
    @Transactional
    @Query(value = "INSERT INTO ordenesCompra(fechaCreacion, estado, fechaEntrega) VALUES(:fechaCreacion, :estado, :fechaEntrega)", nativeQuery = true)
    void insertarOrdenCompra(@Param("fechaCreacion") Date fechaCreacion, @Param("estado") String estado, @Param("fechaEntrega") Date fechaEntrega);

    @Modifying
    @Transactional
    @Query(value = "UPDATE ordenesCompra SET fechaCreacion = :fechaCreacion, estado = :estado, fechaEntrega = :fechaEntrega WHERE id = :id", nativeQuery = true)
    void actualizarOrdenCompra(@Param("id") int id, @Param("fechaCreacion") Date fechaCreacion, @Param("estado") String estado, @Param("fechaEntrega") Date fechaEntrega);

    @Modifying
    @Transactional
    @Query(value = "DELETE FROM ordenesCompra WHERE id = :id", nativeQuery = true)
    void eliminarOrdenCompra(@Param("id") int id);
}
