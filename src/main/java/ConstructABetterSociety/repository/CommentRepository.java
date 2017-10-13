package ConstructABetterSociety.repository;

import ConstructABetterSociety.domain.Comment;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

@RepositoryRestResource
public interface CommentRepository extends PagingAndSortingRepository<Comment, Long> {
}
