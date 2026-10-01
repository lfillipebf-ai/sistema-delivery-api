package br.com.luisfillipe.delivery.model;

import jakarta.persistence.*;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name="orders")
public class OrderEntity {
    @Id @GeneratedValue(strategy=GenerationType.IDENTITY)
    private Long id;
    @ManyToOne(optional=false) private Client client;
    @Enumerated(EnumType.STRING) private OrderStatus status = OrderStatus.RECEIVED;
    @Column(nullable=false) private BigDecimal total = BigDecimal.ZERO;

    @OneToMany(mappedBy="order", cascade=CascadeType.ALL, orphanRemoval=true)
    private List<OrderItem> items = new ArrayList<>();

    public Long getId(){return id;}
    public Client getClient(){return client;}
    public void setClient(Client client){this.client=client;}
    public OrderStatus getStatus(){return status;}
    public void setStatus(OrderStatus status){this.status=status;}
    public BigDecimal getTotal(){return total;}
    public void setTotal(BigDecimal total){this.total=total;}
    public List<OrderItem> getItems(){return items;}
}
