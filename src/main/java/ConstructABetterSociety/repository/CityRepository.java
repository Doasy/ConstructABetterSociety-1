package ConstructABetterSociety.repository;

import ConstructABetterSociety.domain.City;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import org.springframework.web.bind.annotation.CrossOrigin;

import java.util.List;

@CrossOrigin
@RepositoryRestResource
public interface CityRepository extends PagingAndSortingRepository<City, Long> {
    City findByNameEquals(@Param("name") String name);
    List<City> findByNameContains(@Param("name") String name);
}
