package com.tsadigov.ingress.dao;

import com.tsadigov.ingress.domain.AppUser;
import com.tsadigov.ingress.domain.Role;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface AppUserRepo extends JpaRepository<AppUser, Long> {

    AppUser findByUsername(String username);
    List<AppUser> findByRolesMatches(String role);

}
