package com.ch.happyhours.auth.repository;

import com.ch.happyhours.auth.domain.User;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface UserRepository extends CrudRepository<User, Long>
{

    Optional<User> findOneByEmail(String email);


}
