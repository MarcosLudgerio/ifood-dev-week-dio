package me.dio.sacola.models;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Builder;
import me.dio.sacola.enumeration.PaymentForm;

import javax.persistence.*;
import java.util.List;
import java.util.Objects;

@Entity
@Builder
public class Bag {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JsonIgnore
    private Client client;
    private Double totalValue;
    @OneToMany(cascade = CascadeType.ALL)
    private List<Item> items;
    @Enumerated
    private PaymentForm paymentForm;
    private boolean closed;


    public Bag(Long id, Client client, Double totalValue, List<Item> items, PaymentForm paymentForm, boolean closed) {
        this.id = id;
        this.client = client;
        this.totalValue = totalValue;
        this.items = items;
        this.paymentForm = paymentForm;
        this.closed = closed;
    }

    public Bag() {
    }

    @Override
    public String toString() {
        return "Bag{" +
                "id=" + id +
                ", client=" + client +
                ", totalValue=" + totalValue +
                ", paymentForm=" + paymentForm +
                ", closed=" + closed +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Bag bag = (Bag) o;
        return closed == bag.closed && Objects.equals(id, bag.id) && Objects.equals(client, bag.client) && Objects.equals(totalValue, bag.totalValue) && paymentForm == bag.paymentForm;
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, client, totalValue, paymentForm, closed);
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Client getClient() {
        return client;
    }

    public void setClient(Client client) {
        this.client = client;
    }

    public Double getTotalValue() {
        return totalValue;
    }

    public void setTotalValue(Double totalValue) {
        this.totalValue = totalValue;
    }

    public PaymentForm getPayamentForm() {
        return paymentForm;
    }

    public void setPayamentForm(PaymentForm paymentForm) {
        this.paymentForm = paymentForm;
    }

    public boolean isClosed() {
        return closed;
    }

    public void setClosed(boolean closed) {
        this.closed = closed;
    }

    public List<Item> getItems() {
        return items;
    }

    public void setItems(List<Item> items) {
        this.items = items;
    }

    public PaymentForm getPaymentForm() {
        return paymentForm;
    }

    public void setPaymentForm(PaymentForm paymentForm) {
        this.paymentForm = paymentForm;
    }
}
