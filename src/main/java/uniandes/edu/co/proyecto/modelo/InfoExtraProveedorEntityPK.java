package uniandes.edu.co.proyecto.modelo;

import java.io.Serializable;

import jakarta.persistence.Embeddable;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;


@Embeddable
public class InfoExtraProveedorEntityPK implements Serializable{

    @ManyToOne
    @JoinColumn(name = "proveedor_id", referencedColumnName = "NIT")
    private ProveedorEntity proveedor;

    @ManyToOne
    @JoinColumn(name = "producto_id", referencedColumnName = "id")
    private ProductoEntity producto;

    public InfoExtraProveedorEntityPK(ProveedorEntity proveedor_id, ProductoEntity producto_id){

        this.proveedor=proveedor_id;
        this.producto=producto_id;

    }

    public ProveedorEntity getProveedor() {
        return proveedor;
    }

    public void setProveedor(ProveedorEntity proveedor) {
        this.proveedor = proveedor;
    }

    public ProductoEntity getProducto() {
        return producto;
    }

    public void setProducto(ProductoEntity producto) {
        this.producto = producto;
    }
    
}
