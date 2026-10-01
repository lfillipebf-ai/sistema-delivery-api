package br.com.luisfillipe.delivery.repository;
import br.com.luisfillipe.delivery.model.Client;
import org.springframework.data.jpa.repository.JpaRepository;
public interface ClientRepository extends JpaRepository<Client,Long>{}
