package uniandes.edu.co.proyecto.modelo;

import jakarta.persistence.Entity;
import jakarta.persistence.Table;

@Entity
@Table(name = "Info_Extra_Ventas")
public class InfoExtraVenta {

    private InfoExtraVentaPK pk;

    private Integer cantidad;
    private Integer precioUnitarioVenta;

    public InfoExtraVenta() {
    }

    public InfoExtraVenta(VentaEntity venta_id, ProductoEntity producto_id, Integer cantidad, Integer precioUnitarioVenta) {

        this.pk = new InfoExtraVentaPK(venta_id, producto_id);
        this.cantidad = cantidad;
        this.precioUnitarioVenta = precioUnitarioVenta;
    }

    public InfoExtraVentaPK getId() {
        return pk;
    }

    public Integer getCantidad() {
        return cantidad;
    }

    public Integer getPrecioUnitarioVenta() {
        return precioUnitarioVenta;
    }

    public void setCantidad(Integer cantidad) {
        this.cantidad = cantidad;
    }

    public void setPrecioUnitarioVenta(Integer precioUnitarioVenta) {
        this.precioUnitarioVenta = precioUnitarioVenta;
    }

}
