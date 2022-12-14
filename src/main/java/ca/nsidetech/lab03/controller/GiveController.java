package ca.nsidetech.lab03.controller;

import ca.nsidetech.lab03.entity.Give;
import ca.nsidetech.lab03.service.GiveService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@RestController
public class GiveController {
    @Autowired
    private GiveService giveService;

    private final List<Give> gives = new ArrayList<>();

    @GetMapping(value = "/gives")
    public ResponseEntity<List<Give>> getSearch(@RequestParam(required = false) String name) {
        List<Give> gives = giveService.getGive();
        return ResponseEntity.ok().body(gives);
    }

    @PostMapping(value = "/gives")
    public ResponseEntity<Object> saveGive(@RequestBody Give give) {
        giveService.saveGive(give);

        String message = " Votre produit  Sauvegarde réussie";
        return ResponseEntity.ok().body(message);
    }

    @PutMapping(value = "/gives/{id}")
    public ResponseEntity<Object> updateSearch(@RequestBody Give give, @PathVariable Long id) {
        giveService.updateGive(give);

        String message = "Mise à jour réussie";
        return ResponseEntity.ok().body(message);
    }

    @DeleteMapping(value = "/gives/{id}")
    public ResponseEntity<Object> deleteGive(@PathVariable Long id) {
        Optional<Give> give = giveService.getGiveById((id));

        if(give.isPresent()){
            giveService.deleteGive(give.get());
            String message = "Le produit a été supprimé";
            return ResponseEntity.ok().body(message);
        }
        return ResponseEntity.badRequest().build();
    }
}
