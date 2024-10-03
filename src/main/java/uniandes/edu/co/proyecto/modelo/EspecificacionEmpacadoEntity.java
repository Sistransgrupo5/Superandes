package uniandes.edu.co.proyecto.modelo;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;

@Entity
@Table(name = "especificacion_empacado")
public class EspecificacionEmpacadoEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    private double volumen;
    private double peso;

    @ManyToOne
    private ProductoEntity producto;

    public EspecificacionEmpacadoEntity() {
    }

    public EspecificacionEmpacadoEntity(double volumen, double peso, ProductoEntity producto) {
        this.volumen = volumen;
        this.peso = peso;
        this.producto = producto;
    }

    public Long getId() {
        return id;
    }

    public double getVolumen() {
        return volumen;
    }

    public double getPeso() {
        return peso;
    }

    public ProductoEntity getProducto() {
        return producto;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public void setVolumen(double volumen) {
        this.volumen = volumen;
    }

    public void setPeso(double peso) {
        this.peso = peso;
    }

    public void setProducto(ProductoEntity producto) {
        this.producto = producto;
    }
}
