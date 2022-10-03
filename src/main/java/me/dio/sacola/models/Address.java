package me.dio.sacola.models;

import lombok.Builder;

import javax.persistence.*;

@Embeddable
@Builder
public class Address {
    private String cep;
    private String number;
    private String street;
    private String city;
    private String state;
    private String complement;

    public Address(String cep, String number, String street, String city, String state, String complement) {
        this.cep = cep;
        this.number = number;
        this.street = street;
        this.city = city;
        this.state = state;
        this.complement = complement;
    }

    public Address() {
    }

    @Override
    public String toString() {
        return "Address{" +
                ", cep='" + cep + '\'' +
                ", number='" + number + '\'' +
                ", street='" + street + '\'' +
                ", city='" + city + '\'' +
                ", state='" + state + '\'' +
                ", complement='" + complement + '\'' +
                '}';
    }

    public String getCep() {
        return cep;
    }

    public void setCep(String cep) {
        this.cep = cep;
    }

    public String getNumber() {
        return number;
    }

    public void setNumber(String number) {
        this.number = number;
    }

    public String getStreet() {
        return street;
    }

    public void setStreet(String street) {
        this.street = street;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
    }

    public String getComplement() {
        return complement;
    }

    public void setComplement(String complement) {
        this.complement = complement;
    }
}
