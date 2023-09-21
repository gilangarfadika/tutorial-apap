package apap.tutorial.bacabaca.repository;

import apap.tutorial.bacabaca.model.Buku;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.Optional;
import java.util.UUID;
import java.util.List;


@Repository
public interface BukuDB extends JpaRepository<Buku, UUID> {

    
    @Query("SELECT b FROM Buku b WHERE LOWER(b.judul) = LOWER(:judul) order by b.judul")
    List<Buku> findJudulBuku(@Param("judul") String judul);

    @Query("SELECT b FROM Buku b order by b.judul")
    List<Buku> findAll();

}