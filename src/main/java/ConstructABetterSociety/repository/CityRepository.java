package ConstructABetterSociety.repository;


import ConstructABetterSociety.domain.City;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

@RepositoryRestResource
public interface CityRepository extends PagingAndSortingRepository<City, Long> {

}