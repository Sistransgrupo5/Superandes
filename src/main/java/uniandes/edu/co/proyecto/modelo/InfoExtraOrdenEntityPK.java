package uniandes.edu.co.proyecto.modelo;

import java.io.Serializable;

import jakarta.persistence.Embeddable;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;

@Embeddable
public class InfoExtraOrdenEntityPK implements Serializable {

    @ManyToOne
    @JoinColumn(name = "orden_compra_id", referencedColumnName = "id")
    private OrdenCompraEntity ordenCompra;

    @ManyToOne
    @JoinColumn(name = "producto_id", referencedColumnName = "id")
    private ProductoEntity producto;


    public InfoExtraOrdenEntityPK(OrdenCompraEntity ordenCompra_id, ProductoEntity producto_id){

        super();
        this.ordenCompra=ordenCompra_id;
        this.producto=producto_id;

    }

    public InfoExtraOrdenEntityPK(){
    }

    public OrdenCompraEntity getOrdenCompra() {
        return ordenCompra;
    }

    public void setOrdenCompra(OrdenCompraEntity ordenCompra) {
        this.ordenCompra = ordenCompra;
    }

    public ProductoEntity getProducto() {
        return producto;
    }

    public void setProducto(ProductoEntity producto) {
        this.producto = producto;
    }

}
