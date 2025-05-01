package cosplay.spring.core.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import cosplay.spring.core.entity.Kostum;
import cosplay.spring.core.service.KostumService;

@RestController
@RequestMapping("/api/kostums")
@CrossOrigin(origins = "*") // sementara buka semua origin
public class KostumController {

    @Autowired
    private KostumService kostumService;

    @PostMapping
    public ResponseEntity<Kostum> createKostum(@RequestBody Kostum kostum) {
        return ResponseEntity.ok(kostumService.createKostum(kostum));
    }

    @GetMapping
    public ResponseEntity<List<Kostum>> getAllKostums() {
        return ResponseEntity.ok(kostumService.getAllKostums());
    }

    @GetMapping("/{id}")
    public ResponseEntity<Kostum> getKostumById(@PathVariable Long id) {
        return kostumService.getKostumById(id)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @PutMapping("/{id}")
    public ResponseEntity<Kostum> updateKostum(@PathVariable Long id, @RequestBody Kostum kostum) {
        return ResponseEntity.ok(kostumService.updateKostum(id, kostum));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteKostum(@PathVariable Long id) {
        kostumService.deleteKostum(id);
        return ResponseEntity.noContent().build();
    }
}
