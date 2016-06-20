package repository;

import java.util.List;

import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.data.repository.query.Param;

import model.Client;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;


@RepositoryRestResource(collectionResourceRel = "user", path = "users")
public interface UserRepository extends PagingAndSortingRepository<Client, Long> {

    List<Client> findByLogin(@Param("login") String login);
    List<Client> findByLoginOrderByLogin(@Param("login") String login);

}
