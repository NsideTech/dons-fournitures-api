package ca.nsidetech.lab03.service;

import ca.nsidetech.lab03.entity.Search;
import ca.nsidetech.lab03.repository.SearchRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class SearchService {
    @Autowired
    private SearchRepository searchRepository;

    public void saveSearch(Search search) {
        searchRepository.save(search);
    }

    public List<Search> getSearch() {
        return (List<Search>) searchRepository.findAll();
    }

 //   public void updateSearch(Search search) {
 //       searchRepository.save(search);
 //   }

    public Optional<Search> getSearchById(Long id) {
        return searchRepository.findById(id);
    }

    public void deleteSearch(Search search) {
        searchRepository.delete(search);
    }
}
