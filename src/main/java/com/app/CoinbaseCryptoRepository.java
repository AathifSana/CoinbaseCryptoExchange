package com.app;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface CoinbaseCryptoRepository
        extends JpaRepository<CoinbaseCrypto,Long> {


}
