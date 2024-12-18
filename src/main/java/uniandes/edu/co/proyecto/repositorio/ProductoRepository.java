package uniandes.edu.co.proyecto.repositorio;

import java.util.Collection;
import java.util.Date;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.transaction.annotation.Transactional;

import uniandes.edu.co.proyecto.modelo.ProductoEntity;

public interface ProductoRepository extends JpaRepository<ProductoEntity, Integer> {

    @Query(value = "SELECT * FROM Producto", nativeQuery = true)
    Collection<ProductoEntity> darProductos();

    @Query(value = "SELECT * FROM Producto WHERE codigoBarras = :codigoBarras", nativeQuery = true)
    ProductoEntity darProducto(@Param("codigoBarras") String codigoBarras);

    @Modifying
    @Transactional
    @Query(value = "INSERT INTO Producto(codigoBarras,nombre, precioUnitarioVenta, presentacion, cantidadPresentacion, unidadMedida, fechaExpiracion) VALUES(proyecto_sequence.nextval, :nombre, :precioUnitarioVenta, :presentacion, :cantidadPresentacion, :unidadMedida, :fechaExpiracion)", nativeQuery = true)
    void insertarProducto(@Param("nombre") String nombre, @Param("precioUnitarioVenta") Integer precioUnitarioVenta, @Param("presentacion") String presentacion, @Param("cantidadPresentacion") Integer cantidadPresentacion, @Param("unidadMedida") String unidadMedida, @Param("fechaExpiracion") Date fechaExpiracion);

    @Modifying
    @Transactional
    @Query(value = "UPDATE Producto SET nombre=:nombre, precioUnitarioVenta=:precioUnitarioVenta, presentacion=:presentacion, cantidadPresentacion=:cantidadPresentacion, unidadMedida=:unidadMedida, fechaExpiracion=:fechaExpiracion  WHERE codigoBarras=:codigoBarras", nativeQuery = true)
    void actualizarProducto(@Param("codigoBarras") String codigoBarras, @Param("nombre") String nombre, @Param("precioUnitarioVenta") Integer precioUnitarioVenta, @Param("presentacion") String presentacion, @Param("cantidadPresentacion") Integer cantidadPresentacion, @Param("unidadMedida") String unidadMedida, @Param("fechaExpiracion") Date fechaExpiracion);

    @Modifying
    @Transactional
    @Query(value = "DELETE FROM Producto WHERE codigoBarras = :codigoBarras", nativeQuery = true)
    void eliminarProducto(@Param("codigoBarras") String codigoBarras);

}
