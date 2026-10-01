package br.com.luisfillipe.delivery.repository;
import br.com.luisfillipe.delivery.model.OrderEntity;
import org.springframework.data.jpa.repository.JpaRepository;
public interface OrderRepository extends JpaRepository<OrderEntity,Long>{}
