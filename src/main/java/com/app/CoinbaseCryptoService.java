package com.app;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.time.LocalDate;
import java.util.List;
import java.util.Objects;
import java.util.Optional;

import com.CryptoUtils;


@Service
public class CoinbaseCryptoService{

    private final CoinbaseCryptoRepository cryptoRepository;

    @Autowired
    public CoinbaseCryptoService(CoinbaseCryptoRepository cryptoRepository) {
        this.cryptoRepository = cryptoRepository;
    }


    public List<CoinbaseCrypto> getCoinbaseCryptos(){
    return  cryptoRepository.findAll();
    }

    public void addCoinbaseCrypto(CoinbaseCrypto crypto) {
       cryptoRepository.save(crypto);
    }

    public void removeCoinbaseCrypto(Long cryptoId) {
        boolean exists = cryptoRepository.existsById(cryptoId);
        if(!exists){
            throw new IllegalStateException("Coinbase Crypto with id " + cryptoId + " does not exist.");
        }
        cryptoRepository.deleteById(cryptoId);
    }

    @Transactional
    public void updateCoinbaseCrypto(Long cryptoId, String ownerName, Double quantity) {

        CoinbaseCrypto crypto = cryptoRepository.findById(cryptoId)
                .orElseThrow(() -> new IllegalStateException(
                "Coinbase Crypto with id " + cryptoId + " does not exist."
        ));

        if(!CryptoUtils.isEmpty(ownerName) && !Objects.equals(crypto.getOwnerName(), ownerName)){
            crypto.setOwnerName(ownerName);
        }

        if(!Objects.equals(crypto.getQuantity(), quantity)){
            crypto.setQuantity(quantity);
        }

    }
}
