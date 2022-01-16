package com.example.crypto.cryptoapp;

import javax.persistence.*;
import java.time.LocalDate;
import java.time.Period;

@Entity
@Table
public class Crypto {
    @Id
    @SequenceGenerator(
            name = "crypto_sequence",
            sequenceName= "crypto_sequence",
            allocationSize = 1
    )
    @GeneratedValue(
            strategy = GenerationType.SEQUENCE,
            generator = "crypto_sequence"
    )
    private Long id;
    private String name;
    private  String email;
    private LocalDate AffectedDate;
    @Transient
    private Integer age;

    public Crypto() {
    }

    public Crypto(Long id, String name, String email, LocalDate affectedDate) {
        this.id = id;
        this.name = name;
        this.email = email;
        AffectedDate = affectedDate;
    }

    public Crypto(String name, String email, LocalDate affectedDate) {
        this.name = name;
        this.email = email;
        AffectedDate = affectedDate;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public LocalDate getAffectedDate() {
        return AffectedDate;
    }

    public void setAffectedDate(LocalDate affectedDate) {
        AffectedDate = affectedDate;
    }

    public Integer getAge() {
        return Period.between(this.AffectedDate,LocalDate.now()).getYears();
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    @Override
    public String toString() {
        return "Crypto{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", email='" + email + '\'' +
                ", AffectedDate=" + AffectedDate +
                ", age=" + age +
                '}';
    }
}
