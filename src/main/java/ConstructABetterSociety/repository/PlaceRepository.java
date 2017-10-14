package ConstructABetterSociety.repository;

import ConstructABetterSociety.domain.City;
import ConstructABetterSociety.domain.Place;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import org.springframework.data.rest.core.config.Projection;
import org.springframework.web.bind.annotation.CrossOrigin;

import java.util.List;

@Projection(name = "inlineAddress", types = { City.class })
interface CityInlinePlacesProjection {
    Long getId();
    String getName();
    String getDescription();
    City getCity();
    Double getLatitude();
    Double getLongitude();
}


@CrossOrigin
@RepositoryRestResource(excerptProjection = CityInlinePlacesProjection.class)
public interface PlaceRepository extends PagingAndSortingRepository<Place, Long> {
    List<Place> findByNameContains(@Param("q") String q);

    @Query("SELECT p FROM Place p WHERE p.city.name = :name")
    List<Place> findByCity(@Param("name")String name);

    Place findByNameEquals(@Param("name") String name);
}
