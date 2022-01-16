package com.app;

import com.CryptoUtils;

import javax.persistence.*;
import java.time.LocalDate;
import java.time.Period;

@Entity
@Table
public class CoinbaseCrypto {
    @Id
    @SequenceGenerator(
            name = "coinbase_crypto_sequence",
            sequenceName= "coinbase_crypto_sequence",
            allocationSize = 1
    )
    @GeneratedValue(
            strategy = GenerationType.SEQUENCE,
            generator = "coinbase_crypto_sequence"
    )
    private Long cryptoId;
    private String ownerName;
    private Double quantity;
    private String cryptoType;
    private Double UnitPrice;
    private Double totalPrice;
    private LocalDate boughtDate;

    public CoinbaseCrypto() {
    }

    public CoinbaseCrypto(String ownerName, Double quantity, String cryptoType, LocalDate boughtDate) {
        this.ownerName = ownerName;
        this.quantity = quantity;
        this.cryptoType = cryptoType.toUpperCase();
        this.UnitPrice = CryptoUtils.getPrice(cryptoType.toUpperCase());
        this.totalPrice = CryptoUtils.getPrice(cryptoType.toUpperCase()) * quantity;
        this.boughtDate = boughtDate;
    }

    public CoinbaseCrypto(String ownerName, Double quantity, String cryptoType) {
        this.ownerName = ownerName;
        this.quantity = quantity;
        this.cryptoType = cryptoType.toUpperCase();
        this.UnitPrice = CryptoUtils.getPrice(cryptoType.toUpperCase());
        this.totalPrice = CryptoUtils.getPrice(cryptoType.toUpperCase()) * quantity;
        this.boughtDate = LocalDate.now();
    }

    public Long getCryptoId() {
        return cryptoId;
    }

    public void setCryptoId(Long cryptoId) {
        this.cryptoId = cryptoId;
    }

    public String getOwnerName() {
        return ownerName;
    }

    public void setOwnerName(String ownerName) {
        this.ownerName = ownerName;
    }

    public String getCryptoType() {
        return cryptoType;
    }

    public void setCryptoType(String cryptoType) {
        this.cryptoType = cryptoType;
    }

    public LocalDate getBoughtDate() {
        return boughtDate;
    }

    public void setBoughtDate(LocalDate boughtDate) {
        this.boughtDate = boughtDate;
    }

    public Double getQuantity() {
        return quantity;
    }

    public void setQuantity(Double quantity) {
        this.quantity = quantity;
    }

    public Double getUnitPrice() {
        return UnitPrice;
    }

    public void setUnitPrice(Double unitPrice) {
        UnitPrice = unitPrice;
    }

    public Double getTotalPrice() {
        return totalPrice;
    }

    public void setTotalPrice(Double totalPrice) {
        this.totalPrice = totalPrice;
    }

    @Override
    public String toString() {
        return "CoinbaseCrypto : {" +
                "cryptoId=" + cryptoId +
                ", ownerName='" + ownerName + '\'' +
                ", quantity=" + quantity +
                ", cryptoType='" + cryptoType + '\'' +
                ", UnitPrice=" + UnitPrice +
                ", totalPrice=" + totalPrice +
                ", boughtDate=" + boughtDate +
                '}';
    }
}
