package apap.tutorial.bacabaca.repository;

import apap.tutorial.bacabaca.model.Penerbit;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface PenerbitDB extends JpaRepository<Penerbit, Long> {
    List<Penerbit> findAll();

    Optional<Penerbit> findById(Long idPenerbit);
}