package com.ch.happyhours.auth.repository;

import com.ch.happyhours.auth.domain.Authority;
import com.ch.happyhours.auth.domain.Client;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 * Created by Chemakh on 03/02/2017.
 */
@Repository
public interface ClientRepository extends JpaRepository<Client,Long> {
}
