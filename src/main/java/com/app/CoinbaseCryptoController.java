package com.app;

import com.CryptoUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.util.List;

@RestController
@RequestMapping(path = "api/v1/crypto")
public class CoinbaseCryptoController {

    private final CoinbaseCryptoService cryptoService;

    @Autowired
    public CoinbaseCryptoController(CoinbaseCryptoService cryptoService) {
        this.cryptoService = cryptoService;
    }

    @GetMapping
    public List<CoinbaseCrypto> getCoinbaseCrypto() {
        return cryptoService.getCoinbaseCryptos();
    }

    @GetMapping(path = "/health")
    public String healthCheck() {
        return "Health Check Works!!!";
    }

    @PostMapping
    public void addCoinbaseCrypto(
            @RequestParam(required = true) String ownerName,
            @RequestParam(required = true) Double quantity,
            @RequestParam(required = true) String cryptoType,
            @RequestParam(required = false) String localDate) {
        CoinbaseCrypto obj;
        if(CryptoUtils.isEmpty(localDate)){
            obj = new CoinbaseCrypto(ownerName,quantity,cryptoType);

        }else {
            obj = new CoinbaseCrypto(ownerName,quantity,cryptoType, LocalDate.parse(localDate));
        }
        cryptoService.addCoinbaseCrypto(obj);
    }

    @DeleteMapping(path = "{cryptoId}")
    public void removeCoinbaseCrypto(@PathVariable("cryptoId") Long cryptoId) {
        cryptoService.removeCoinbaseCrypto(cryptoId);
    }

    @PutMapping(path = "{cryptoId}")
    public void updateCoinbaseCrypto(
            @PathVariable("cryptoId") Long cryptoId,
            @RequestParam(required = false) String ownerName,
            @RequestParam(required = false) Double quantity
    ) {
        cryptoService.updateCoinbaseCrypto(cryptoId, ownerName, quantity);
    }

}

