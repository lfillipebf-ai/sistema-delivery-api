package br.com.luisfillipe.delivery.repository;
import br.com.luisfillipe.delivery.model.Restaurant;
import org.springframework.data.jpa.repository.JpaRepository;
public interface RestaurantRepository extends JpaRepository<Restaurant,Long>{}
