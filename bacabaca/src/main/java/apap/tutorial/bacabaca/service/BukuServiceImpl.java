package apap.tutorial.bacabaca.service;

import java.util.List;
import java.util.UUID;

import apap.tutorial.bacabaca.DTO.BukuMapper;
import apap.tutorial.bacabaca.repository.BukuDB;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import apap.tutorial.bacabaca.model.Buku;

@Service
public class BukuServiceImpl implements BukuService {

    @Autowired
    BukuDB bukuDb;

    @Autowired
    BukuMapper bukuMapper;

    @Override
    public void createBuku(Buku buku) {
        bukuDb.save(buku);
    }

    @Override
    public void saveBuku(Buku buku) {
        bukuDb.save(buku);
    }

    @Override
    public List<Buku> getAllBuku() {
        return bukuDb.findAll();
    }

    @Override
    public Buku getBukuById(UUID idBuku) {
        for (Buku buku : getAllBuku()) {
            if (buku.getId().equals(idBuku)) {
                return buku;
            }
        }
        return null;
    }

    

    @Override
    public Buku updateBuku(Buku bukuFromDTO) {
        Buku buku = getBukuById(bukuFromDTO.getId());

        if (buku != null) {
            buku.setHarga(bukuFromDTO.getHarga());
            buku.setJudul(bukuFromDTO.getJudul());
            buku.setListPenulis(bukuFromDTO.getListPenulis());
            buku.setTahunTerbit(bukuFromDTO.getTahunTerbit());
            buku.setPenerbit(bukuFromDTO.getPenerbit());
            bukuDb.save(buku);
        }

        return buku;
    }

    @Override
    public boolean isJudulExist(String judul) {
        return getAllBuku().stream().anyMatch(b -> b.getJudul().equals((judul)));
    }

    @Override
    public boolean isJudulExist(String judul, UUID id) {
        return getAllBuku().stream().anyMatch(b -> b.getJudul().equals(judul) && !b.getId().equals(id));
    }

    @Override
    public void deleteBuku(Buku buku) {
        bukuDb.delete(buku);
    }

    @Override
    public  List<Buku> getBukuByJudul(String judul) {

        List<Buku> listbuku = bukuDb.findJudulBuku(judul);

        if (listbuku.isEmpty() == true){
            listbuku = getAllBuku();
        }

        return listbuku;
    }

    // @Override
    // public void softdeleteBuku(Buku buku) {
        
    //     buku.setDeleted(true);

    //     bukuDb.save(buku);

        

    // }
}