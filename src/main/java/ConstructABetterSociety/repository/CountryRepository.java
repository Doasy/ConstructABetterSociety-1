package ConstructABetterSociety.repository;

import ConstructABetterSociety.domain.Country;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

@RepositoryRestResource
public interface CountryRepository extends PagingAndSortingRepository<Country, Long> {

}