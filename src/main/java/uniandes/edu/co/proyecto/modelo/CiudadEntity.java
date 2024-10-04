package uniandes.edu.co.proyecto.modelo;

import java.util.List;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;

@Entity
@Table(name = "Ciudad")
public class CiudadEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)

    private Integer codigo;
    private String nombre;

    @OneToMany(mappedBy = "Ciudad", cascade = CascadeType.ALL)
    private List<SucursalEntity> sucursales;

    public CiudadEntity(Integer codigo, String nombre, List<SucursalEntity> sucursales) {
        this.codigo = codigo;
        this.nombre = nombre;
        this.sucursales = sucursales;
    }

    public CiudadEntity() {
    }

    public Integer getCodigo() {
        return codigo;
    }

    public String getNombre() {
        return nombre;
    }

    public void setCodigo(Integer codigo) {
        this.codigo = codigo;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

}
