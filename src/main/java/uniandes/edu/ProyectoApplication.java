package uniandes.edu;

import java.util.Collection;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import uniandes.edu.co.proyecto.modelo.CiudadEntity;
import uniandes.edu.co.proyecto.repositorio.CiudadRepository;

@SpringBootApplication
public class ProyectoApplication implements CommandLineRunner {

    @Autowired
    private CiudadRepository CiudadRepository;

    public static void main(String[] args) {
        SpringApplication.run(ProyectoApplication.class, args);
    }

    @Override
    public void run(String... arg) {

        Collection<CiudadEntity> Ciudads = CiudadRepository.darCiudades();
        for(CiudadEntity b: Ciudads){
            System.err.println(b);
        }
    }

}

