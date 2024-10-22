package uniandes.edu;

import java.util.Collection;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import uniandes.edu.co.proyecto.modelo.CategoriaEntity;
import uniandes.edu.co.proyecto.repositorio.CategoriaRepository;

@SpringBootApplication
public class ProyectoApplication implements CommandLineRunner {

    @Autowired
    private CategoriaRepository categoriaRepository;

    public static void main(String[] args) {
        SpringApplication.run(ProyectoApplication.class, args);
    }

    @Override
    public void run(String... arg) {

        Collection<CategoriaEntity> categorias = categoriaRepository.darCategorias();
        for(CategoriaEntity b: categorias){
            System.err.println(b);
        }
    }

}

