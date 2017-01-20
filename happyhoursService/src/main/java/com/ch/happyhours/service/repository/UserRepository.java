package com.ch.happyhours.service.repository;


import com.ch.happyhours.service.domain.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface UserRepository extends JpaRepository<User, Long>
{

    Optional<User> findOneByEmail(String email);

    Optional<User> findOneByEmailKey(String activationKey);

    Optional<User> findOneBySmsKey(String smsKey);

    Optional<User> findOneByResetPasswordKey(String key);

    Optional<User> findOneByReference(String key);
}
