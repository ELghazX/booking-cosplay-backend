package cosplay.spring.core.service.impl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import cosplay.spring.core.entity.Kostum;
import cosplay.spring.core.repository.KostumRepository;
import cosplay.spring.core.service.KostumService;

@Service
public class KostumServiceImpl implements KostumService {

    @Autowired
    private KostumRepository kostumRepository;

    @Override
    public Kostum createKostum(Kostum kostum) {
        return kostumRepository.save(kostum);
    }

    @Override
    public List<Kostum> getAllKostums() {
        return kostumRepository.findAll();
    }

    @Override
    public Optional<Kostum> getKostumById(Long id) {
        return kostumRepository.findById(id);
    }

    @Override
    public Kostum updateKostum(Long id, Kostum kostumDetails) {
        Kostum kostum = kostumRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Kostum not found with id " + id));

        kostum.setNama(kostumDetails.getNama());
        kostum.setUkuran(kostumDetails.getUkuran());
        kostum.setDeskripsi(kostumDetails.getDeskripsi());
        kostum.setFoto(kostumDetails.getFoto());
        kostum.setHargaSewaHarian(kostumDetails.getHargaSewaHarian());
        kostum.setHargaSewaMingguan(kostumDetails.getHargaSewaMingguan());

        return kostumRepository.save(kostum);
    }

    @Override
    public void deleteKostum(Long id) {
        kostumRepository.deleteById(id);
    }
}
