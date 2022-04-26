package com.tsadigov.ingress.dao;

import com.tsadigov.ingress.domain.Role;
import org.springframework.data.jpa.repository.JpaRepository;

public interface RoleRepo extends JpaRepository<Role, Long> {
    Role findRoleByRoleName(String roleName);
}
