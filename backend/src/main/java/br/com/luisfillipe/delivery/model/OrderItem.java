package br.com.luisfillipe.delivery.model;

import jakarta.persistence.*;
import java.math.BigDecimal;

@Entity
@Table(name="order_items")
public class OrderItem {
    @Id @GeneratedValue(strategy=GenerationType.IDENTITY)
    private Long id;
    @ManyToOne(optional=false) private OrderEntity order;
    @ManyToOne(optional=false) private Product product;
    private Integer quantity;
    private BigDecimal unitPrice;

    public Long getId(){return id;}
    public OrderEntity getOrder(){return order;}
    public void setOrder(OrderEntity order){this.order=order;}
    public Product getProduct(){return product;}
    public void setProduct(Product product){this.product=product;}
    public Integer getQuantity(){return quantity;}
    public void setQuantity(Integer quantity){this.quantity=quantity;}
    public BigDecimal getUnitPrice(){return unitPrice;}
    public void setUnitPrice(BigDecimal unitPrice){this.unitPrice=unitPrice;}
}
