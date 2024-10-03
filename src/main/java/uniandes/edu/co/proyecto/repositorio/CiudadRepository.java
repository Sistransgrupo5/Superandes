package uniandes.edu.co.proyecto.repositorio;

import java.util.Collection;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.transaction.annotation.Transactional;

import uniandes.edu.co.proyecto.modelo.CiudadEntity;

public interface CiudadRepository extends JpaRepository<CiudadEntity, Integer> {

    @Query(value = "SELECT * FROM ciudades", nativeQuery = true)
    Collection<CiudadEntity> darCiudades();

    @Query(value = "SELECT * FROM ciudades WHERE codigo= : codigo", nativeQuery = true)
    CiudadEntity darCiudad(@Param("codigo") long codigo);

    @Modifying
    @Transactional
    @Query(value = "INSERT INTO ciudades(codigo,nombre) VALUES(proyecto_sequence.nextval, :nombre )", nativeQuery = true)
    void insertarCiudad(@Param("nombre") String nombre);

    @Modifying
    @Transactional
    @Query(value = "UPDATE ciudades SET nombre=:nombre WHERE codigo=:codigo", nativeQuery = true)
    void actualizarCiudad(@Param("codigo") long codigo, @Param("nombre") String nombre);

    @Modifying
    @Transactional
    @Query(value = "DELETE FROM ciudades WHERE codigo = :codigo", nativeQuery = true)
    void eliminarCiudad(@Param("codigo") long codigo);

}
