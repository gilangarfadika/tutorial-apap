package apap.tutorial.bacabaca.repository;

import apap.tutorial.bacabaca.model.Penulis;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PenulisDB extends JpaRepository<Penulis, Long> {
}