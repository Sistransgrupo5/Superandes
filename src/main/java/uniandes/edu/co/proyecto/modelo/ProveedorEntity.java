package uniandes.edu.co.proyecto.modelo;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "Proveedores")
public class ProveedorEntity {

    @Id
    private String NIT;

    private String nombre;
    private String direccion;
    private String nombre_contacto;
    private String telefono;

    public ProveedorEntity(String NIT, String nombre, String direccion, String nombre_contacto, String telefono) {
        this.NIT = NIT;
        this.nombre = nombre;
        this.direccion = direccion;
        this.nombre_contacto = nombre_contacto;
        this.telefono = telefono;
    }

    public ProveedorEntity() {
    }

    public String getNIT() {
        return NIT;
    }

    public String getNombre() {
        return nombre;
    }

    public String getDireccion() {
        return direccion;
    }

    public String getNombre_contacto() {
        return nombre_contacto;
    }

    public String getTelefono() {
        return telefono;
    }

    public void setNIT(String nIT) {
        NIT = nIT;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }

    public void setNombre_contacto(String nombre_contacto) {
        this.nombre_contacto = nombre_contacto;
    }

    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }

}
