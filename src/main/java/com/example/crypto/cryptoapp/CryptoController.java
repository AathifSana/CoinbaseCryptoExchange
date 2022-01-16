package com.example.crypto.cryptoapp;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.time.Month;
import java.util.List;

@RestController
@RequestMapping(path="api/v1/crypto")
public class CryptoController {

        private final CryptoService cryptoService;

        @Autowired
        public CryptoController(CryptoService cryptoService){
                this.cryptoService = cryptoService;
        }

        @GetMapping
        public List<Crypto> getCrypto(){
          return cryptoService.getCrypto();
        }

        @PostMapping
        public void registerNewCrypto(@RequestBody Crypto crypto){
               cryptoService.addNewCrypto(crypto);
        }

        @DeleteMapping(path = "{cryptoId}")
        public void deleteCrypto(@PathVariable("cryptoId") Long cryptoId){
                cryptoService.deleteCrypto(cryptoId);
        }

        @PutMapping(path = "{cryptoId}")
        public void updateCrypto(
                @PathVariable("cryptoId") Long cryptoId,
                @RequestParam(required = false) String name,
                @RequestParam(required = false) String email){
                cryptoService.updateCrypto(cryptoId,name,email);
        }
}
