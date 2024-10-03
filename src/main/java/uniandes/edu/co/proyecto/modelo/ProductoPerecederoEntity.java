package uniandes.edu.co.proyecto.modelo;

import java.util.Date;

import jakarta.persistence.Entity;
import jakarta.persistence.Table;

@Entity
@Table(name = "producto_perecedero")
public class ProductoPerecederoEntity extends ProductoEntity {

    private Date fechaVencimiento;

    public ProductoPerecederoEntity() {
    }

    public ProductoPerecederoEntity(String nombre, Integer precioUnitarioVenta, String presentacion, Integer cantidadPresentacion, String unidadMedida, Date fechaExpiracion, Date fechaVencimiento) {
        super(nombre, precioUnitarioVenta, presentacion, cantidadPresentacion, unidadMedida, fechaExpiracion);
        this.fechaVencimiento = fechaVencimiento;
    }

    public Date getFechaVencimiento() {
        return fechaVencimiento;
    }

    public void setFechaVencimiento(Date fechaVencimiento) {
        this.fechaVencimiento = fechaVencimiento;
    }
}
