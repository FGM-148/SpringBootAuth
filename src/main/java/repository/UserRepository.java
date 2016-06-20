package repository;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

import model.User;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends PagingAndSortingRepository<User, Long> {
    /**
     * Method that returns a lista of clients doing a search by the passed name parameter.
     *
     * @param name
     * @return list of clients
     */
    List<User> findByName(@Param("login") String name);

    /**
     * Method that returns a client with only its name doing a search by the passed id parameter.
     *
     * @param id
     * @return client of the id passed as parameter.
     */

    /**
     * Method that returns a list of clients doing a search by the passed name parameter and sorting them by the name.
     *
     * @param name
     * @return list of clients
     */
    List<User> findByNameOrderByName(@Param("login") String name);

}
