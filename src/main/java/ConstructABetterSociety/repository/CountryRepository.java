package ConstructABetterSociety.repository;

import ConstructABetterSociety.domain.Country;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import org.springframework.web.bind.annotation.CrossOrigin;

@CrossOrigin
@RepositoryRestResource
public interface CountryRepository extends PagingAndSortingRepository<Country, Long> {
    Country findByNameEquals(@Param("name") String name);
}