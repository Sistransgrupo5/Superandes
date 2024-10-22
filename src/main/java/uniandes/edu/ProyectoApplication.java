package uniandes.edu;

import java.util.Collection;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import uniandes.edu.co.proyecto.modelo.ClienteEntity;
import uniandes.edu.co.proyecto.repositorio.ClienteRepository;

@SpringBootApplication
public class ProyectoApplication implements CommandLineRunner {

    @Autowired
    private ClienteRepository ClienteRepository;

    public static void main(String[] args) {
        SpringApplication.run(ProyectoApplication.class, args);
    }

    @Override
    public void run(String... arg) {

        Collection<ClienteEntity> Clientes = ClienteRepository.darClientes();
        for(ClienteEntity b: Clientes){
            System.err.println(b);
        }
    }

}

