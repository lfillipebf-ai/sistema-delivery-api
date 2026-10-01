package br.com.luisfillipe.delivery.controller;

import br.com.luisfillipe.delivery.model.*;
import br.com.luisfillipe.delivery.repository.*;
import org.springframework.http.*;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;
import java.math.BigDecimal;
import java.util.List;

@RestController @RequestMapping("/api/orders")
public class OrderController {
    private final OrderRepository orders;
    private final ClientRepository clients;
    private final ProductRepository products;

    public OrderController(OrderRepository orders, ClientRepository clients, ProductRepository products){
        this.orders=orders; this.clients=clients; this.products=products;
    }

    @GetMapping public List<OrderEntity> list(){return orders.findAll();}

    @PostMapping @Transactional
    public ResponseEntity<OrderEntity> create(@RequestBody CreateOrderRequest request){
        Client client=clients.findById(request.clientId())
            .orElseThrow(()->new ResponseStatusException(HttpStatus.NOT_FOUND,"Cliente não encontrado"));
        OrderEntity order=new OrderEntity();
        order.setClient(client);
        BigDecimal total=BigDecimal.ZERO;
        for(ItemRequest item: request.items()){
            Product product=products.findById(item.productId())
                .orElseThrow(()->new ResponseStatusException(HttpStatus.NOT_FOUND,"Produto não encontrado"));
            OrderItem oi=new OrderItem();
            oi.setOrder(order); oi.setProduct(product); oi.setQuantity(item.quantity()); oi.setUnitPrice(product.getPrice());
            order.getItems().add(oi);
            total=total.add(product.getPrice().multiply(BigDecimal.valueOf(item.quantity())));
        }
        order.setTotal(total);
        return ResponseEntity.status(HttpStatus.CREATED).body(orders.save(order));
    }

    @PatchMapping("/{id}/status")
    public OrderEntity status(@PathVariable Long id,@RequestParam OrderStatus value){
        OrderEntity order=orders.findById(id)
            .orElseThrow(()->new ResponseStatusException(HttpStatus.NOT_FOUND,"Pedido não encontrado"));
        order.setStatus(value);
        return orders.save(order);
    }

    public record CreateOrderRequest(Long clientId,List<ItemRequest> items){}
    public record ItemRequest(Long productId,Integer quantity){}
}
