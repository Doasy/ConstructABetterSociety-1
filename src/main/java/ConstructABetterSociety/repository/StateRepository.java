package ConstructABetterSociety.repository;

import ConstructABetterSociety.domain.State;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import org.springframework.web.bind.annotation.CrossOrigin;

@CrossOrigin
@RepositoryRestResource
public interface StateRepository extends PagingAndSortingRepository<State, Long> {
    State findByNameEquals(@Param("name") String name);
}
