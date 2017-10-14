package ConstructABetterSociety.repository;

import ConstructABetterSociety.domain.Place;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import org.springframework.web.bind.annotation.CrossOrigin;

import java.util.List;

@CrossOrigin
@RepositoryRestResource
public interface PlaceRepository extends PagingAndSortingRepository<Place, Long> {
    List<Place>findByNameContains(@Param("q") String q);
    Place findByNameEquals(@Param("name") String name);
}
