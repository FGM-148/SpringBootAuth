package com.example.bootauth.repository;

import java.util.List;

import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.data.repository.query.Param;

import com.example.bootauth.model.Account;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import org.springframework.stereotype.Repository;


//@RepositoryRestResource(collectionResourceRel = "user", path = "users")
@Repository
public interface AccountRepository extends PagingAndSortingRepository<Account, Long> {

    List<Account> findByLogin(@Param("login") String login);
    List<Account> findByLoginOrderByLogin(@Param("login") String login);

}
