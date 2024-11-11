package uniandes.edu.co.proyecto.repositorio;

import java.util.Collection;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.transaction.annotation.Transactional;

import uniandes.edu.co.proyecto.modelo.SucursalEntity;

public interface SucursalRepositorio extends JpaRepository<SucursalEntity, Integer> {

    public interface RespuestaInformacionSucursales{
        Integer getIdSucursal();
        String getNombre();
    }

    @Query(value = "SELECT * FROM Sucursal", nativeQuery = true)
    Collection<SucursalEntity> darSucursales();

    @Query(value = "SELECT * FROM Sucursal WHERE id= : id", nativeQuery = true)
    SucursalEntity darSucursal(@Param("id") int id);

    @Modifying
    @Transactional
    @Query(value = "INSERT INTO Sucursal(id,nombre,tamanio,direccion,telefono) VALUES(proyecto_sequence.nextval, :nombre, :tamanio, :direccion, :telefono)", nativeQuery = true)
    void insertarSucursal(@Param("nombre") String nombre, @Param("tamanio") Integer tamanio, @Param("direccion") String direccion, @Param("telefono") String telefono);

    @Modifying
    @Transactional
    @Query(value = "UPDATE Sucursal SET nombre=:nombre, tamanio=:tamanio, direccion=:direccion, telefono=:telefono WHERE id=:id", nativeQuery = true)
    void actualizarSucursal(@Param("id") int id, @Param("nombre") String nombre, @Param("tamanio") Integer tamanio, @Param("direccion") String direccion, @Param("telefono") String telefono);

    @Modifying
    @Transactional
    @Query(value = "DELETE FROM Sucursal WHERE id = :id", nativeQuery = true)
    void eliminarSucursal(@Param("id") int id);

    @Query(value = "SELECT DISTINCT s.* " +
               "FROM Sucursal s " +
               "JOIN Bodega b ON s.id_sucursal = b.id_sucursal " +
               "JOIN Producto p ON b.id_bodega = p.bodega_id " +
               "WHERE p.id_producto = :producto_id", nativeQuery = true)
Collection<SucursalEntity> darSucursalesConProductoDisponible(@Param("producto_id") Integer producto_id);

}
