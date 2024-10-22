package uniandes.edu.co.proyecto.modelo;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "Bodega")
public class BodegaEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)

    private Integer id_bodega;
    private String nombre;
    private Integer tamanio;

    /*@ManyToOne
    @JoinColumn(name = "id_sucursal", referencedColumnName = "id_bodega")
    private SucursalEntity sucursal;


    @OneToOne
    @JoinColumn(name = "id_info_extra_bodega", referencedColumnName = "id_bodega")
    private InfoExtraBodegaEntity infoExtraBodega;


    @ManyToMany
    @JoinTable(
        name = "ProductoBodega",
        joinColumns = @JoinColumn(name = "id_bodega", referencedColumnName = "id_bodega"),
        inverseJoinColumns = @JoinColumn(name = "id_producto", referencedColumnName = "id_bodega")
    )
    private List<ProductoEntity> productos;


    @OneToMany(mappedBy = "Bodega", cascade = CascadeType.ALL)
    private List<RecepcionProductoEntity> recepcionProductos; */

    public BodegaEntity(String nombre, Integer tamanio) {
        this.nombre = nombre;
        this.tamanio = tamanio;
        /*this.sucursal = sucursal;
        this.infoExtraBodega = infoExtraBodega;
        this.productos = productos;
        this.recepcionProductos = recepcionProductos; */
    }

    public BodegaEntity() {
    }


    public Integer getId() {
        return id_bodega;
    }

    public void setId(Integer id_bodega) {
        this.id_bodega = id_bodega;
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

}
