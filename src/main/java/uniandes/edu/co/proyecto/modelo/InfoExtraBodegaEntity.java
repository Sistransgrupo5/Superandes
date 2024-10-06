package uniandes.edu.co.proyecto.modelo;

import java.util.List;

import jakarta.persistence.EmbeddedId;
import jakarta.persistence.Entity;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;

@Entity
@Table(name = "InfoExtraBodega")
public class InfoExtraBodegaEntity {

    @EmbeddedId
    private InfoExtraBodegaEntityPK pk;

    private double costoPromedio;
    private int totalExistencias;
    private int nivelMinimoReorden;
    private double capacidadAlmacenamiento;

    @OneToMany
    private List<DetalleCostosBodegaEntity> detallesCostosBodega;

    public InfoExtraBodegaEntity() {
    }

    public InfoExtraBodegaEntity(BodegaEntity bodega_id, ProductoEntity producto_id, DetalleCostosBodegaEntity id_detalle, double costoPromedio, int totalExistencias, int nivelMinimoReorden, double capacidadAlmacenamiento) {
        this.pk = new InfoExtraBodegaEntityPK(bodega_id, producto_id);
        this.costoPromedio = costoPromedio;
        this.totalExistencias = totalExistencias;
        this.nivelMinimoReorden = nivelMinimoReorden;
        this.capacidadAlmacenamiento = capacidadAlmacenamiento;
    }

    public InfoExtraBodegaEntityPK getId() {
        return pk;
    }

    public void setId(InfoExtraBodegaEntityPK pk) {
        this.pk = pk;
    }

    public double getCostoPromedio() {
        return costoPromedio;
    }

    public void setCostoPromedio(double costoPromedio) {
        this.costoPromedio = costoPromedio;
    }

    public int getTotalExistencias() {
        return totalExistencias;
    }

    public void setTotalExistencias(int totalExistencias) {
        this.totalExistencias = totalExistencias;
    }

    public int getNivelMinimoReorden() {
        return nivelMinimoReorden;
    }

    public void setNivelMinimoReorden(int nivelMinimoReorden) {
        this.nivelMinimoReorden = nivelMinimoReorden;
    }

    public double getCapacidadAlmacenamiento() {
        return capacidadAlmacenamiento;
    }

    public void setCapacidadAlmacenamiento(double capacidadAlmacenamiento) {
        this.capacidadAlmacenamiento = capacidadAlmacenamiento;
    }

    public List<DetalleCostosBodegaEntity> getDetallesCostosBodega() {
        return detallesCostosBodega;
    }

    public void setDetallesCostosBodega(List<DetalleCostosBodegaEntity> detallesCostosBodega) {
        this.detallesCostosBodega = detallesCostosBodega;
    }
}
