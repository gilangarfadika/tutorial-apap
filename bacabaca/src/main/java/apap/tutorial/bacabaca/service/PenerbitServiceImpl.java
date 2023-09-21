package apap.tutorial.bacabaca.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import apap.tutorial.bacabaca.repository.PenerbitDB;
import apap.tutorial.bacabaca.model.Penerbit;

import java.util.List;

@Service
public class PenerbitServiceImpl implements PenerbitService {
    @Autowired
    PenerbitDB penerbitDb;

    @Override
    public Penerbit createPenerbit(Penerbit penerbit) {
        return penerbitDb.save(penerbit);
    }

    @Override
    public List<Penerbit> getAllPenerbit() {
        return penerbitDb.findAll();
    }

    @Override
    public Penerbit getPenerbitById(long idPenerbit) {
        return penerbitDb.findById(idPenerbit).get();
    }
}