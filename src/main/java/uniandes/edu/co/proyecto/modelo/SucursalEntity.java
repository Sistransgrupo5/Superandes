package uniandes.edu.co.proyecto.modelo;

import java.util.List;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;

@Entity
@Table(name = "Sucursal")
public class SucursalEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)

    private Integer id;
    private String nombre;
    private Integer tamanio;
    private String direccion;
    private String telefono;

    @ManyToOne
    private CiudadEntity ciudad;

    @OneToMany
    private List<VentaEntity> ventas;

    @OneToMany
    private List<BodegaEntity> bodegas;

    @OneToMany
    private List<OrdenCompraEntity> ordenCompras;

    public SucursalEntity(String nombre, Integer tamanio, String direccion, String telefono) {
        this.nombre = nombre;
        this.tamanio = tamanio;
        this.direccion = direccion;
        this.telefono = telefono;
    }

    public SucursalEntity() {
    }

    public Integer getId() {
        return id;
    }

    public String getNombre() {
        return nombre;
    }

    public Integer getTamanio() {
        return tamanio;
    }

    public String getDireccion() {
        return direccion;
    }

    public String getTelefono() {
        return telefono;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public void setTamanio(Integer tamanio) {
        this.tamanio = tamanio;
    }

    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }

    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }

}
