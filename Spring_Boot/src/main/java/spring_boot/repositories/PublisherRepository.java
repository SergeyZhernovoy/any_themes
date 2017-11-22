package spring_boot.repositories;

import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import spring_boot.entity.Publisher;

/**
 * @author Sergey Zhernovoy
 * create on 22.11.2017.
 */
@RepositoryRestResource
public interface PublisherRepository extends PagingAndSortingRepository<Publisher,Long>{
}
