package ca.nsidetech.lab03.repository;

import ca.nsidetech.lab03.entity.Search;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface SearchRepository extends CrudRepository<Search, Long> {
}
