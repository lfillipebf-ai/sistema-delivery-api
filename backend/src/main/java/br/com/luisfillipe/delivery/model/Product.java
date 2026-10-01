package br.com.luisfillipe.delivery.model;

import jakarta.persistence.*;
import jakarta.validation.constraints.*;
import java.math.BigDecimal;

@Entity
@Table(name="products")
public class Product {
    @Id @GeneratedValue(strategy=GenerationType.IDENTITY)
    private Long id;
    @NotBlank private String name;
    @NotNull @Positive private BigDecimal price;
    @ManyToOne(optional=false) private Restaurant restaurant;

    public Long getId(){return id;}
    public String getName(){return name;}
    public void setName(String name){this.name=name;}
    public BigDecimal getPrice(){return price;}
    public void setPrice(BigDecimal price){this.price=price;}
    public Restaurant getRestaurant(){return restaurant;}
    public void setRestaurant(Restaurant restaurant){this.restaurant=restaurant;}
}
