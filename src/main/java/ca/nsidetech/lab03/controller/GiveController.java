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

    @PostMapping(value = "/give")
    public ResponseEntity<Object> saveGive(@RequestBody Give give) {
        giveService.saveGive(give);

        String message = "Votre " + give.getNom() + " Sauvegarde réussie";
        return ResponseEntity.ok().body(message);
    }
}
