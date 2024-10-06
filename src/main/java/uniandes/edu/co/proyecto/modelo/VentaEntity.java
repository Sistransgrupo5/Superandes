package uniandes.edu.co.proyecto.modelo;

import java.util.Date;
import java.util.List;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;

@Entity
@Table(name = "ventas")
public class VentaEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)

    private Integer id;
    private Date fecha;

    /* @ManyToOne
    private ClienteEntity cliente;

    @ManyToOne
    private SucursalEntity sucursal;

    @ManyToMany
    private List<ProductoEntity> productos; */

    public VentaEntity(Integer id, Date fecha) {
        this.fecha = fecha;
    }

    public VentaEntity() {
    }

    public Integer getId() {
        return id;
    }

    public Date getFecha() {
        return fecha;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public void setFecha(Date fecha) {
        this.fecha = fecha;
    }

}
