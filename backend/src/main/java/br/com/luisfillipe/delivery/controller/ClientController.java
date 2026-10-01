package br.com.luisfillipe.delivery.controller;
import br.com.luisfillipe.delivery.model.Client;
import br.com.luisfillipe.delivery.repository.ClientRepository;
import jakarta.validation.Valid;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController @RequestMapping("/api/clients")
public class ClientController {
    private final ClientRepository repo;
    public ClientController(ClientRepository repo){this.repo=repo;}
    @GetMapping public List<Client> list(){return repo.findAll();}
    @PostMapping public Client create(@Valid @RequestBody Client client){return repo.save(client);}
}
