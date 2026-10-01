package br.com.luisfillipe.delivery.repository;
import br.com.luisfillipe.delivery.model.Product;
import org.springframework.data.jpa.repository.JpaRepository;
public interface ProductRepository extends JpaRepository<Product,Long>{}
