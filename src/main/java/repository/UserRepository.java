package repository;

import java.util.List;

import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.data.repository.query.Param;

import model.Account;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;


@RepositoryRestResource(collectionResourceRel = "user", path = "users")
public interface UserRepository extends PagingAndSortingRepository<Account, Long> {

    List<Account> findByLogin(@Param("login") String login);
    List<Account> findByLoginOrderByLogin(@Param("login") String login);

}
