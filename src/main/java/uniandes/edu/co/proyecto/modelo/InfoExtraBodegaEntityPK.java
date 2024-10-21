package uniandes.edu.co.proyecto.modelo;

import java.io.Serializable;

import jakarta.persistence.Embeddable;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;


@Embeddable
public class InfoExtraBodegaEntityPK implements Serializable {

    @ManyToOne
    @JoinColumn(name = "id_bodega", referencedColumnName = "id_bodega")
    private BodegaEntity bodega;

    @ManyToOne
    @JoinColumn(name = "producto_id", referencedColumnName = "id")
    private ProductoEntity producto;


    public InfoExtraBodegaEntityPK(BodegaEntity bodega_id, ProductoEntity producto_id) {

        super();
        this.bodega = bodega_id;
        this.producto = producto_id;

    }


    public ProductoEntity getProducto() {
        return producto;
    }

    public void setProducto(ProductoEntity producto) {
        this.producto = producto;
    }

    public BodegaEntity getBodega() {
        return bodega;
    }

    public void setBodega(BodegaEntity bodega) {
        this.bodega = bodega;
    }

}
