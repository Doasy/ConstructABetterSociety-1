package ConstructABetterSociety.repository;

import ConstructABetterSociety.domain.Place;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import org.springframework.web.bind.annotation.CrossOrigin;

@CrossOrigin
@RepositoryRestResource
public interface PlaceRepository extends PagingAndSortingRepository<Place, Long> {
}
