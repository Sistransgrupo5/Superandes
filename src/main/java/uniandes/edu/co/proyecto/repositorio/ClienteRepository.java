package uniandes.edu.co.proyecto.repositorio;

import java.util.Collection;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.transaction.annotation.Transactional;

import uniandes.edu.co.proyecto.modelo.Cliente;

public interface ClienteRepository extends JpaRepository<Cliente, Integer>{

    @Query(value = "SELECT * FROM clientes")
    Collection<Cliente> darClientes();
    
    @Query(value = "SELECT * FROM clientes WHERE cedula= : cedula", nativeQuery=true)
    Cliente darCliente(@Param("cedula") int cedula);

    @Modifying
    @Transactional
    @Query(value = "INSERT INTO clientes(cedula,nombre) VALUES(proyecto_sequence.nextval, :nombre)", nativeQuery = true)
    void insertarCliente(@Param("nombre") String nombre);


    @Modifying
    @Transactional
    @Query(value = "UPDATE clientes SET nombre=:nombre WHERE cedula=:cedula", nativeQuery = true)
    void actualizarCliente(@Param("cedula") int cedula, @Param("nombre") String nombre);

    @Modifying
    @Transactional
    @Query(value = "DELETE FROM clientes WHERE cedula = :cedula", nativeQuery = true)
    void eliminarCliente(@Param("cedula") int cedula);
    
}
