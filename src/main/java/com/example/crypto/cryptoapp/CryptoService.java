package com.example.crypto.cryptoapp;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.time.LocalDate;
import java.time.Month;
import java.util.List;
import java.util.Objects;
import java.util.Optional;


@Service
public class CryptoService{
    private final CryptoRepository cryptoRepository;

    @Autowired
    public CryptoService(CryptoRepository cryptoRepository) {
        this.cryptoRepository = cryptoRepository;
    }





    public List<Crypto> getCrypto(){
    return  cryptoRepository.findAll();
    }

    public void addNewCrypto(Crypto crypto) {
       Optional<Crypto> cryptoOptional = cryptoRepository
               .findCryptoByEmail(crypto.getEmail());

       if(cryptoOptional.isPresent()){
           throw new IllegalStateException("Email Taken");
       }
       cryptoRepository.save(crypto);
     //System.out.println(crypto);
    }

    public void deleteCrypto(Long cryptoId) {
       // cryptoRepository.findById(cryptoId);
        boolean exists = cryptoRepository.existsById(cryptoId);
        if(!exists){
            throw new IllegalStateException("crypto with id " + cryptoId + " does not exists");
        }
        cryptoRepository.deleteById(cryptoId);
    }

    @Transactional
    public void updateCrypto(Long cryptoId, String name, String email) {

        Crypto crypto = cryptoRepository.findById(cryptoId)
                .orElseThrow(() -> new IllegalStateException(
                "crypto with id " + cryptoId + " does not exists"
        ));

        if(name != null && name.length() > 0 && !Objects.equals(crypto.getName(),name)){
            crypto.setName(name);
        }
        System.out.println(name+email);

        if(email != null && email.length() > 0 &&
        !Objects.equals(crypto.getEmail(),email)){
            Optional<Crypto> cryptoOptional = cryptoRepository.findCryptoByEmail(email);
            if(cryptoOptional.isPresent()){
                throw  new IllegalStateException("email taken");
            }
            crypto.setEmail(email);
        }

    }
}
