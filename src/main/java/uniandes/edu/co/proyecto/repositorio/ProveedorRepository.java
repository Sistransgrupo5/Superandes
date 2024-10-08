package uniandes.edu.co.proyecto.repositorio;

import java.util.Collection;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.transaction.annotation.Transactional;

import uniandes.edu.co.proyecto.modelo.ProveedorEntity;

public interface ProveedorRepository extends JpaRepository<ProveedorEntity, String> {

        @Query(value = "SELECT * FROM proveedores", nativeQuery = true)
        Collection<ProveedorEntity> darProveedores();

        @Query(value = "SELECT * FROM proveedores WHERE NIT = :NIT", nativeQuery = true) // Eliminado el espacio
        ProveedorEntity darProveedor(@Param("NIT") String NIT); // Cambiado a String si NIT es de tipo String

        @Modifying
        @Transactional
        @Query(value = "INSERT INTO proveedores(NIT,nombre,direccion,nombre_contacto,telefono) VALUES(proyecto_sequence.nextval, :nombre, :direccion, :nombre_contacto, :telefono)", nativeQuery = true)
        void insertarProveedor(@Param("nombre") String nombre,
                        @Param("direccion") String direccion,
                        @Param("nombre_contacto") String nombre_contacto,
                        @Param("telefono") String telefono);

        @Modifying
        @Transactional
        @Query(value = "UPDATE proveedores SET nombre=:nombre, direccion=:direccion, nombre_contacto=:nombre_contacto, telefono=:telefono WHERE NIT=:NIT", nativeQuery = true)
        void actualizarProveedor(@Param("NIT") String NIT,
                        @Param("nombre") String nombre,
                        @Param("direccion") String direccion,
                        @Param("nombre_contacto") String nombre_contacto,
                        @Param("telefono") String telefono);

        @Modifying
        @Transactional
        @Query(value = "DELETE FROM proveedores WHERE NIT = :NIT", nativeQuery = true)
        void eliminarProveedor(@Param("NIT") String NIT);
}
