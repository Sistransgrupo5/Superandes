package uniandes.edu.co.proyecto.modelo;

import java.io.Serializable;

import jakarta.persistence.Embeddable;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;

@Embeddable
public class InfoExtraVentaPK implements Serializable {

    @ManyToOne
    @JoinColumn(name = "venta_id", referencedColumnName = "id")
    private VentaEntity venta;

    @ManyToOne
    @JoinColumn(name = "producto_id", referencedColumnName = "id")
    private ProductoEntity producto;

    public InfoExtraVentaPK(VentaEntity venta_id, ProductoEntity producto_id) {

        this.venta = venta_id;
        this.producto = producto_id;

    }

    public VentaEntity getVenta() {
        return venta;
    }

    public void setVenta(VentaEntity venta) {
        this.venta = venta;
    }

    public ProductoEntity getProducto() {
        return producto;
    }

    public void setProducto(ProductoEntity producto) {
        this.producto = producto;
    }

}
