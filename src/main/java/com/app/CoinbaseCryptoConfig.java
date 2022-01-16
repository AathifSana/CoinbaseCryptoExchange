package com.app;

import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import com.CryptoUtils;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Arrays;

import static java.time.Month.*;

@Configuration
public class CoinbaseCryptoConfig {
    @Bean
    CommandLineRunner commandLineRunner(CoinbaseCryptoRepository repository){

        CryptoUtils.initializeCryptoPrices();

        return  args -> {
            CoinbaseCrypto obj1 = new CoinbaseCrypto(
                    "Aathif Sanaya",
                    0.2,
                    "bitcoin",
                    LocalDate.of(2022, JANUARY,13)
            );

            CoinbaseCrypto obj2 = new CoinbaseCrypto(
                    "Peter Parker",
                    1.0,
                    "tether",
                    LocalDate.of(2022, JANUARY,14)
            );

            repository.saveAll(

                    new ArrayList<>(Arrays.asList(obj1, obj2))
            );

        };
    }
}
