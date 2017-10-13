package ConstructABetterSociety.repository;

import ConstructABetterSociety.domain.State;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

@RepositoryRestResource
public interface StateRepository extends PagingAndSortingRepository<State, Long> {
}
