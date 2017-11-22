package spring_boot.repositories;

import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import spring_boot.entity.Reviewers;

/**
 * @author Sergey Zhernovoy
 * create on 22.11.2017.
 */
@RepositoryRestResource
public interface ReviewersRepository extends PagingAndSortingRepository<Reviewers,Long> {
}
