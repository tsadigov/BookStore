package com.tsadigov.ingress.dao;

import com.tsadigov.ingress.domain.AppUser;
import com.tsadigov.ingress.domain.Role;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AppUserRepo extends JpaRepository<AppUser, Long> {

    AppUser findByUsername(String username);
    AppUser findByRolesMatches(String role);

}
