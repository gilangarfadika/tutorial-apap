package apap.tutorial.bacabaca.service;

import apap.tutorial.bacabaca.model.Buku;

import java.util.List;
import java.util.UUID;

public interface BukuService {
    // Method to add book
    void createBuku(Buku buku);

    void saveBuku(Buku buku);

    // Method to get stored book
    List<Buku> getAllBuku();

    // Method to get book by id
    Buku getBukuById(UUID idBuku);

    // Method to check if book with specific title already exists
    boolean isJudulExist(String judul);

    boolean isJudulExist(String judul, UUID id);

    Buku updateBuku(Buku buku);

    void deleteBuku(Buku buku);

    // void softdeleteBuku(Buku buku);

    List<Buku> getBukuByJudul(String judul);
}