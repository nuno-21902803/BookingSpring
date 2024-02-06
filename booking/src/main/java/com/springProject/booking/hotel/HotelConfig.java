package com.springProject.booking.hotel;

import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.List;


@Configuration
public class HotelConfig {

    @Bean
    CommandLineRunner commandLineRunner(HotelRepository repository){
        return args -> {
            Hotel ssb = new Hotel("Sesimbra", 105.45,"R. Navegador Rodrigues Soromenho, 2970-773 Sesimbra");
            Hotel troia = new Hotel("Troia Design", 131.55,"Troia Design Hotel, Marina de Tróia, 7570-789");

            repository.saveAll(List.of(ssb,troia));
        };
    }

}
