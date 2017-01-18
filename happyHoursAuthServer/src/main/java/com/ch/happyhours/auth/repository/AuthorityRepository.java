package com.ch.happyhours.auth.repository;

import com.ch.happyhours.auth.domain.Authority;
import org.springframework.data.jpa.repository.JpaRepository;


public interface AuthorityRepository extends JpaRepository<Authority,Long>
{
}
