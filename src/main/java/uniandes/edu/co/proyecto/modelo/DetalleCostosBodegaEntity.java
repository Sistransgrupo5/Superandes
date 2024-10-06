package uniandes.edu.co.proyecto.modelo;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;

@Entity
@Table(name = "detalle_costos_bodega")
public class DetalleCostosBodegaEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    private double costoUnitarioBodega;
    private int cantidadExistencias;

    /* @ManyToOne
    private InfoExtraBodegaEntity infoExtraBodega; */

    public DetalleCostosBodegaEntity() {
    }

    public DetalleCostosBodegaEntity(double costoUnitarioBodega, int cantidadExistencias) {
        this.costoUnitarioBodega = costoUnitarioBodega;
        this.cantidadExistencias = cantidadExistencias;
        //this.infoExtraBodega = infoExtraBodega;
    }

    public Long getId() {
        return id;
    }

    public double getCostoUnitarioBodega() {
        return costoUnitarioBodega;
    }

    public int getCantidadExistencias() {
        return cantidadExistencias;
    }

    public InfoExtraBodegaEntity getInfoExtraBodega() {
        return infoExtraBodega;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public void setCostoUnitarioBodega(double costoUnitarioBodega) {
        this.costoUnitarioBodega = costoUnitarioBodega;
    }

    public void setCantidadExistencias(int cantidadExistencias) {
        this.cantidadExistencias = cantidadExistencias;
    }

    public void setInfoExtraBodega(InfoExtraBodegaEntity infoExtraBodega) {
        this.infoExtraBodega = infoExtraBodega;
    }
}
