package uniandes.edu.co.proyecto.modelo;

import java.util.Date;
import java.util.List;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;

@Entity
@Table(name = "OrdenesCompra")
public class OrdenCompraEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)

    private Integer id;
    private Date fechaCreacion;
    private String estado;
    private Date fechaEntrega;

    @ManyToMany
    private List<ProductoEntity> producto;

    @ManyToOne
    private SucursalEntity sucursal;

    @ManyToOne
    private ProveedorEntity proveedor;

    @OneToOne
    private RecepcionProductoEntity recepcionProducto;

    public OrdenCompraEntity(Date fechaCreacion, String estado, Date fechaEntrega) {
        this.fechaCreacion = fechaCreacion;
        this.estado = estado;
        this.fechaEntrega = fechaEntrega;
    }

    public OrdenCompraEntity() {
    }

    public Integer getId() {
        return id;
    }

    public Date getFechaCreacion() {
        return fechaCreacion;
    }

    public String getEstado() {
        return estado;
    }

    public Date getFechaEntrega() {
        return fechaEntrega;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public void setFechaCreacion(Date fechaCreacion) {
        this.fechaCreacion = fechaCreacion;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }

    public void setFechaEntrega(Date fechaEntrega) {
        this.fechaEntrega = fechaEntrega;
    }

}
