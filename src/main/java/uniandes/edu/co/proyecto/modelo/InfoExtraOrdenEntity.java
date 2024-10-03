package uniandes.edu.co.proyecto.modelo;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;

@Entity
@Table(name = "info_extra_orden")
public class InfoExtraOrdenEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    private Integer cantidad;
    private Integer costoUnitarioCompra;

    @ManyToOne
    @JoinColumn(name = "orden_compra_id", nullable = false)
    private OrdenCompraEntity ordenCompra;

    @ManyToOne
    @JoinColumn(name = "producto_id", nullable = false)
    private ProductoEntity producto;

    public InfoExtraOrdenEntity() {
    }

    public InfoExtraOrdenEntity(Integer cantidad, Integer costoUnitarioCompra, OrdenCompraEntity ordenCompra, ProductoEntity producto) {
        this.cantidad = cantidad;
        this.costoUnitarioCompra = costoUnitarioCompra;
        this.ordenCompra = ordenCompra;
        this.producto = producto;
    }

    public Long getId() {
        return id;
    }

    public Integer getCantidad() {
        return cantidad;
    }

    public Integer getCostoUnitarioCompra() {
        return costoUnitarioCompra;
    }

    public OrdenCompraEntity getOrdenCompra() {
        return ordenCompra;
    }

    public ProductoEntity getProducto() {
        return producto;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public void setCantidad(Integer cantidad) {
        this.cantidad = cantidad;
    }

    public void setCostoUnitarioCompra(Integer costoUnitarioCompra) {
        this.costoUnitarioCompra = costoUnitarioCompra;
    }

    public void setOrdenCompra(OrdenCompraEntity ordenCompra) {
        this.ordenCompra = ordenCompra;
    }

    public void setProducto(ProductoEntity producto) {
        this.producto = producto;
    }
}
