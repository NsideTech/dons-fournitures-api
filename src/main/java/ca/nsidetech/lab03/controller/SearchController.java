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

//    private final List<Search> searches = new ArrayList<>();

    @GetMapping(value = "/all")
    public ResponseEntity<List<Search>> getSearch() {
        List<Search> searches = searchService.getSearch();
        return ResponseEntity.ok().body(searches);
    }

    @GetMapping(value = "/all/{searchId}")
    public ResponseEntity<Object> getSearchById(@PathVariable Long searchId) {
        Optional<Search> foundSearch = searchService.getSearchById(searchId);
        if (foundSearch.isEmpty()) {
            return ResponseEntity.badRequest().body("Produit inexistant");
        }
        return ResponseEntity.ok().body(foundSearch);
    }

    @PostMapping(value = "/searches")
    public ResponseEntity<Object> saveSearch(@RequestBody Search search) {
        searchService.saveSearch(search);

        String message = "Sauvegarde demande de " + search.getName() + " reussie";
        return ResponseEntity.ok().body(message);
    }

//    @PutMapping(value = "/searches/{id}")
//    public ResponseEntity<Object> updateSearch(@RequestBody Search search, @PathVariable Long productId) {
//        searchService.updateSearch(search);

//        String message = "Mise à jour réussie";
//        return ResponseEntity.ok().body(message);
//    }

    @DeleteMapping(value = "/searches/{searchid}")
    public ResponseEntity<Object> deleteSearch(@PathVariable Long searchid) {

        Optional<Search> searches = searchService.getSearchById((searchid));

       if(searches.isPresent()){
           searchService.deleteSearch(searches.get());
           String message = "la demande " + searches.get().getName() + " a été supprimé";
           return ResponseEntity.ok().body(message);
       }

       return ResponseEntity.badRequest().build();
    }
}
