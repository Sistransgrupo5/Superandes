package uniandes.edu.co.proyecto.repositorio;

import java.util.Collection;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.transaction.annotation.Transactional;

import uniandes.edu.co.proyecto.modelo.Sucursal;

public interface SucursalRepositorio extends JpaRepository<Sucursal, Integer>{

    @Query(value = "SELECT * FROM sucursales")
    Collection<Sucursal> darSucursales();
    
    @Query(value = "SELECT * FROM sucursales WHERE id= : id", nativeQuery=true)
    Sucursal darSucursal(@Param("id") int id);

    @Modifying
    @Transactional
    @Query(value = "INSERT INTO sucursales(id,nombre,tamanio,direccion,telefono) VALUES(proyecto_sequence.nextval, :nombre, :tamanio, :direccion, :telefono)", nativeQuery = true)
    void insertarSucursal(@Param("nombre") String nombre, @Param("tamanio") Integer tamanio, @Param("direccion") String direccion, @Param("telefono") String telefono);


    @Modifying
    @Transactional
    @Query(value = "UPDATE sucursales SET nombre=:nombre, tamanio=:tamanio, direccion=:direccion, telefono=:telefono WHERE id=:id", nativeQuery = true)
    void actualizarSucursal(@Param("id") int id, @Param("nombre") String nombre, @Param("tamanio") Integer tamanio, @Param("direccion") String direccion, @Param("telefono") String telefono);

    @Modifying
    @Transactional
    @Query(value = "DELETE FROM sucursales WHERE id = :id", nativeQuery = true)
    void eliminarSucursal(@Param("id") int id);
    
}
