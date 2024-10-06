package uniandes.edu.co.proyecto.modelo;

import java.util.Date;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;

@Entity
@Table(name = "recepcionesProductos")
public class RecepcionProductoEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)

    private Integer id;
    private Date fechaRecepcion;

   /*  @ManyToOne
    private BodegaEntity bodega;

    @OneToOne
    private OrdenCompraEntity ordenCompra; */

    public RecepcionProductoEntity(Date fechaRecepcion) {
        this.fechaRecepcion = fechaRecepcion;
    }

    public RecepcionProductoEntity() {
    }

    public Integer getId() {
        return id;
    }

    public Date getFechaRecepcion() {
        return fechaRecepcion;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public void setFechaRecepcion(Date fechaRecepcion) {
        this.fechaRecepcion = fechaRecepcion;
    }

}
