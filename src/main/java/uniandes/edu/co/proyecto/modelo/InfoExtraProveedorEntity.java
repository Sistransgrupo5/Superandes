package uniandes.edu.co.proyecto.modelo;

import jakarta.persistence.EmbeddedId;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;

@Entity
@Table(name = "Info_Extra_Proveedor")
public class InfoExtraProveedorEntity {

    @EmbeddedId
    private InfoExtraProveedorEntityPK pk;

    private Integer cantidadExistencias;

    public InfoExtraProveedorEntity(ProveedorEntity proveedor_id, ProductoEntity producto_id, Integer cantidadExistencias) {

        this.pk = new InfoExtraProveedorEntityPK(proveedor_id,producto_id);
        this.cantidadExistencias = cantidadExistencias;

    }

    public Integer getCantidadExistencias() {
        return cantidadExistencias;
    }

    public void setCantidadExistencias(Integer cantidadExistencias) {
        this.cantidadExistencias = cantidadExistencias;
    }

    public InfoExtraProveedorEntityPK getPk() {
        return pk;
    }

    public void setPk(InfoExtraProveedorEntityPK pk) {
        this.pk = pk;
    }

}
