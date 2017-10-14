package ConstructABetterSociety.repository;

import ConstructABetterSociety.domain.Comment;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import org.springframework.web.bind.annotation.CrossOrigin;

import java.util.List;

@CrossOrigin
@RepositoryRestResource
public interface CommentRepository extends PagingAndSortingRepository<Comment, Long> {
    @Query("SELECT c FROM Comment c WHERE c.place.name = :place")
    List<Comment> findByPlace(@Param("place") String place);
}
