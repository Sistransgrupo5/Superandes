package uniandes.edu.co.proyecto.modelo;

import jakarta.persistence.EmbeddedId;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "info_extra_orden")
public class InfoExtraOrdenEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @EmbeddedId
    private InfoExtraOrdenEntityPK pk;

    private Integer cantidad;
    private Integer costoUnitarioCompra;

    public InfoExtraOrdenEntity() {
    }

    public InfoExtraOrdenEntity(OrdenCompraEntity ordenCompra_id, ProductoEntity producto_id, Integer cantidad, Integer costoUnitarioCompra) {

        this.pk = new InfoExtraOrdenEntityPK(ordenCompra_id,producto_id);
        this.cantidad = cantidad;
        this.costoUnitarioCompra = costoUnitarioCompra;

    }

    public InfoExtraOrdenEntityPK getId() {
        return pk;
    }

    public Integer getCantidad() {
        return cantidad;
    }

    public Integer getCostoUnitarioCompra() {
        return costoUnitarioCompra;
    }

    public void setCantidad(Integer cantidad) {
        this.cantidad = cantidad;
    }

    public void setCostoUnitarioCompra(Integer costoUnitarioCompra) {
        this.costoUnitarioCompra = costoUnitarioCompra;
    }

}
