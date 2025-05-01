package cosplay.spring.core.service;

import java.util.List;
import java.util.Optional;

import cosplay.spring.core.entity.Kostum;

public interface KostumService {

    Kostum createKostum(Kostum kostum);

    List<Kostum> getAllKostums();

    Optional<Kostum> getKostumById(Long id);

    Kostum updateKostum(Long id, Kostum kostumDetails);

    void deleteKostum(Long id);
}
