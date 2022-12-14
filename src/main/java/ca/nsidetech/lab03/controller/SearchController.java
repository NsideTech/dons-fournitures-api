package ca.nsidetech.lab03.controller;

import ca.nsidetech.lab03.entity.Search;
import ca.nsidetech.lab03.service.SearchService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@RestController
public class SearchController {
    @Autowired
    private SearchService searchService;

    private final List<Search> searches = new ArrayList<>();

    @GetMapping(value = "/searches")
    public ResponseEntity<List<Search>> getSearch(@RequestParam(required = false) String name) {
        List<Search> searches = searchService.getSearch();
        return ResponseEntity.ok().body(searches);
    }

    @PostMapping(value = "/searches")
    public ResponseEntity<Object> saveSearch(@RequestBody Search search) {
        searchService.saveSearch(search);

        String message = "Sauvegarde réussie";
        return ResponseEntity.ok().body(message);
    }

    @PutMapping(value = "/searches/{id}")
    public ResponseEntity<Object> updateSearch(@RequestBody Search search, @PathVariable Long productId) {
        searchService.updateSearch(search);

        String message = "Mise à jour réussie";
        return ResponseEntity.ok().body(message);
    }

    @DeleteMapping(value = "/searches/{id}")
    public ResponseEntity<Object> deleteSearch(@PathVariable Long productId) {
       Optional<Search> product = searchService.getSearchById((productId));

       if(product.isPresent()){
           searchService.deleteSearch(product.get());
           String message = "Le produit a été supprimé";
           return ResponseEntity.ok().body(message);
       }
       return ResponseEntity.badRequest().build();
    }
}
