package com.example.crypto.cryptoapp;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface CryptoRepository
        extends JpaRepository<Crypto,Long> {

    // SELECT * FROM crypto Where email = ?
     @Query("SELECT c FROM Crypto c WHERE c.email = ?1")
    Optional<Crypto> findCryptoByEmail(String email);

}
