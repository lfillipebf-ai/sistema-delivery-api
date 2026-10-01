package br.com.luisfillipe.delivery.controller;
import br.com.luisfillipe.delivery.model.Product;
import br.com.luisfillipe.delivery.repository.ProductRepository;
import jakarta.validation.Valid;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController @RequestMapping("/api/products")
public class ProductController {
    private final ProductRepository repo;
    public ProductController(ProductRepository repo){this.repo=repo;}
    @GetMapping public List<Product> list(){return repo.findAll();}
    @PostMapping public Product create(@Valid @RequestBody Product product){return repo.save(product);}
}
