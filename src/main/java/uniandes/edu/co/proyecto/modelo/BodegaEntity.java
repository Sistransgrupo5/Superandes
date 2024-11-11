package uniandes.edu.co.proyecto.modelo;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;

@Entity
@Table(name = "Bodega")
public class BodegaEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)

    private Integer bodega_id;
    private String nombre;
    private Integer tamanio;

    @ManyToOne
    @JoinColumn(name = "id_sucursal", referencedColumnName = "id_sucursal")
    private SucursalEntity sucursal_id;




    public BodegaEntity(String nombre, Integer tamanio, SucursalEntity sucursal_id) {
        this.nombre = nombre;
        this.tamanio = tamanio;
        this.sucursal_id = sucursal_id;
    }

    public BodegaEntity() {
    }


    public Integer getId() {
        return bodega_id;
    }

    public void setId(Integer id_bodega) {
        this.bodega_id = id_bodega;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public Integer getTamanio() {
        return tamanio;
    }

    public void setTamanio(Integer tamanio) {
        this.tamanio = tamanio;
    }

    public void setSucursal(SucursalEntity sucursal_id) {
        this.sucursal_id = sucursal_id;
    }

    /*public SucursalEntity getSucursal() {
        return sucursal;
    }

    public void setSucursal(SucursalEntity sucursal) {
        this.sucursal = sucursal;
    }

    public InfoExtraBodegaEntity getInfoExtraBodega() {
        return infoExtraBodega;
    }

    public void setInfoExtraBodega(InfoExtraBodegaEntity infoExtraBodega) {
        this.infoExtraBodega = infoExtraBodega;
    }

    public List<ProductoEntity> getProductos() {
        return productos;
    }

    public void setProductos(List<ProductoEntity> productos) {
        this.productos = productos;
    }

    public List<RecepcionProductoEntity> getRecepcionProductos() {
        return recepcionProductos;
    }

    public void setRecepcionProductos(List<RecepcionProductoEntity> recepcionProductos) {
        this.recepcionProductos = recepcionProductos;
    } */

    public SucursalEntity getSucursal_id() {
        return sucursal_id;
    }

    public void setSucursal_id(SucursalEntity sucursal_id) {
        this.sucursal_id = sucursal_id;
    }

}
