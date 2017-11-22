package spring_boot.repositories;

import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import spring_boot.entity.Author;

/**
 * @author Sergey Zhernovoy
 * create on 22.11.2017.
 */
@RepositoryRestResource(collectionResourceRel = "writers", path = "writers")
public interface AuthorRepository extends PagingAndSortingRepository<Author,Long> {

}
