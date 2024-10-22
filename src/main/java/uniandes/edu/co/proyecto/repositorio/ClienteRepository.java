package uniandes.edu.co.proyecto.repositorio;

import java.util.Collection;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.transaction.annotation.Transactional;

import uniandes.edu.co.proyecto.modelo.ClienteEntity;

public interface ClienteRepository extends JpaRepository<ClienteEntity, Integer> {

    @Query(value = "SELECT * FROM Cliente", nativeQuery = true)
    Collection<ClienteEntity> darClientes();

    @Query(value = "SELECT * FROM Cliente WHERE cedula= : cedula", nativeQuery = true)
    ClienteEntity darCliente(@Param("cedula") int cedula);

    @Modifying
    @Transactional
    @Query(value = "INSERT INTO Cliente(cedula,nombre) VALUES(proyecto_sequence.nextval, :nombre)", nativeQuery = true)
    void insertarCliente(@Param("nombre") String nombre);

    @Modifying
    @Transactional
    @Query(value = "UPDATE Cliente SET nombre=:nombre WHERE cedula=:cedula", nativeQuery = true)
    void actualizarCliente(@Param("cedula") int cedula, @Param("nombre") String nombre);

    @Modifying
    @Transactional
    @Query(value = "DELETE FROM Cliente WHERE cedula = :cedula", nativeQuery = true)
    void eliminarCliente(@Param("cedula") int cedula);

}
