package uniandes.edu.co.proyecto.modelo;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;

@Entity
@Table(name = "Info_Extra_Ventas")
public class InfoExtraVenta {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;

    private Integer cantidad;
    private Integer precioUnitarioVenta;

    @ManyToOne
    @JoinColumn(name = "venta_id", nullable = false)
    private VentaEntity ventaEntity;

    @ManyToOne
    @JoinColumn(name = "producto_id", nullable = false)
    private ProductoEntity producto;

    public InfoExtraVenta() {
    }

    public InfoExtraVenta(Integer cantidad, Integer precioUnitarioVenta, VentaEntity ventaEntity, ProductoEntity producto) {
        this.cantidad = cantidad;
        this.precioUnitarioVenta = precioUnitarioVenta;
        this.ventaEntity = ventaEntity;
        this.producto = producto;
    }

    public Integer getId() {
        return id;
    }

    public Integer getCantidad() {
        return cantidad;
    }

    public Integer getPrecioUnitarioVenta() {
        return precioUnitarioVenta;
    }

    public VentaEntity getVentaEntity() {
        return ventaEntity;
    }

    public ProductoEntity getProducto() {
        return producto;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public void setCantidad(Integer cantidad) {
        this.cantidad = cantidad;
    }

    public void setPrecioUnitarioVenta(Integer precioUnitarioVenta) {
        this.precioUnitarioVenta = precioUnitarioVenta;
    }

    public void setVentaEntity(VentaEntity ventaEntity) {
        this.ventaEntity = ventaEntity;
    }

    public void setProducto(ProductoEntity producto) {
        this.producto = producto;
    }
}
