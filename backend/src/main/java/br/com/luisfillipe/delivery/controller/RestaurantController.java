package br.com.luisfillipe.delivery.controller;
import br.com.luisfillipe.delivery.model.Restaurant;
import br.com.luisfillipe.delivery.repository.RestaurantRepository;
import jakarta.validation.Valid;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController @RequestMapping("/api/restaurants")
public class RestaurantController {
    private final RestaurantRepository repo;
    public RestaurantController(RestaurantRepository repo){this.repo=repo;}
    @GetMapping public List<Restaurant> list(){return repo.findAll();}
    @PostMapping public Restaurant create(@Valid @RequestBody Restaurant restaurant){return repo.save(restaurant);}
}
