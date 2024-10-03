package uniandes.edu.co.proyecto.modelo;

import java.util.List;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;

@Entity
@Table(name = "info_extra_bodega")
public class InfoExtraBodegaEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    private double costoPromedio;
    private int totalExistencias;
    private int nivelMinimoReorden;
    private String capacidadAlmacenamiento;

    @ManyToOne
    private BodegaEntity bodega;

    @ManyToOne
    private ProveedorEntity proveedor;

    @OneToMany(mappedBy = "infoExtraBodega")
    private List<DetalleCostosBodegaEntity> detallesCostosBodega;

    public InfoExtraBodegaEntity() {
    }

    public InfoExtraBodegaEntity(double costoPromedio, int totalExistencias, int nivelMinimoReorden, String capacidadAlmacenamiento, BodegaEntity bodega, ProveedorEntity proveedor) {
        this.costoPromedio = costoPromedio;
        this.totalExistencias = totalExistencias;
        this.nivelMinimoReorden = nivelMinimoReorden;
        this.capacidadAlmacenamiento = capacidadAlmacenamiento;
        this.bodega = bodega;
        this.proveedor = proveedor;
    }

    public Long getId() {
        return id;
    }

    public double getCostoPromedio() {
        return costoPromedio;
    }

    public int getTotalExistencias() {
        return totalExistencias;
    }

    public int getNivelMinimoReorden() {
        return nivelMinimoReorden;
    }

    public String getCapacidadAlmacenamiento() {
        return capacidadAlmacenamiento;
    }

    public BodegaEntity getBodega() {
        return bodega;
    }

    public ProveedorEntity getProveedor() {
        return proveedor;
    }

    public List<DetalleCostosBodegaEntity> getDetallesCostosBodega() {
        return detallesCostosBodega;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public void setCostoPromedio(double costoPromedio) {
        this.costoPromedio = costoPromedio;
    }

    public void setTotalExistencias(int totalExistencias) {
        this.totalExistencias = totalExistencias;
    }

    public void setNivelMinimoReorden(int nivelMinimoReorden) {
        this.nivelMinimoReorden = nivelMinimoReorden;
    }

    public void setCapacidadAlmacenamiento(String capacidadAlmacenamiento) {
        this.capacidadAlmacenamiento = capacidadAlmacenamiento;
    }

    public void setBodega(BodegaEntity bodega) {
        this.bodega = bodega;
    }

    public void setProveedor(ProveedorEntity proveedor) {
        this.proveedor = proveedor;
    }

    public void setDetallesCostosBodega(List<DetalleCostosBodegaEntity> detallesCostosBodega) {
        this.detallesCostosBodega = detallesCostosBodega;
    }
}
