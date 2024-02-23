package app.GestioneEvento.repository;

import app.GestioneEvento.model.entities.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface UserRepo extends JpaRepository<User,Integer> {
    public Optional<User> findByUsername(String username);
}
