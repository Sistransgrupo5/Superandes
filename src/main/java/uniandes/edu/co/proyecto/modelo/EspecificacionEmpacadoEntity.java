package uniandes.edu.co.proyecto.modelo;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "especificacion_empacado")
public class EspecificacionEmpacadoEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;

    private double volumen;
    private double peso;

    /* @OneToMany
    private List<ProductoEntity> productos; */

    public EspecificacionEmpacadoEntity() {
    }

    public EspecificacionEmpacadoEntity(double volumen, double peso) {
        this.volumen = volumen;
        this.peso = peso;
        //this.productos =  productos;
    }

    public int getId() {
        return id;
    }

    public double getVolumen() {
        return volumen;
    }

    public double getPeso() {
        return peso;
    }

    /* public List<ProductoEntity> getProducto() {
        return productos;
    } */

    public void setId(int id) {
        this.id = id;
    }

    public void setVolumen(double volumen) {
        this.volumen = volumen;
    }

    public void setPeso(double peso) {
        this.peso = peso;
    }

    /* public void setProducto(List<ProductoEntity> productos) {
        this.productos = productos;
    } */
}
