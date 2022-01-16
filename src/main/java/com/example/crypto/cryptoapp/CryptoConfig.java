package com.example.crypto.cryptoapp;

import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.time.LocalDate;
import java.time.Month;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static java.time.Month.*;

@Configuration
public class CryptoConfig {
    @Bean
    CommandLineRunner commandLineRunner(CryptoRepository repository){
        return  args -> {
            Crypto gaje = new Crypto(
                    "Gaje",
                    "gaje@gmail.com",
                    LocalDate.of(2000, JANUARY,5)
            );

            Crypto bit = new Crypto(
                    "Bit",
                    "bit@gmail.com",
                    LocalDate.of(2004, JANUARY,5)
            );

            repository.saveAll(

                    new ArrayList<>(Arrays.asList(gaje, bit))
            );

        };
    }
}
