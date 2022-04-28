package com.tsadigov.ingress.service;

import com.tsadigov.ingress.configuration.PasswordConfig;
import com.tsadigov.ingress.dao.AppUserRepo;
import com.tsadigov.ingress.dao.RoleRepo;
import com.tsadigov.ingress.domain.AppUser;
import com.tsadigov.ingress.domain.Role;
import com.tsadigov.ingress.dto.AppUserDTO;
import com.tsadigov.ingress.dto.SignUpDTO;
import com.tsadigov.ingress.exception.ResourceNotFoundException;
import com.tsadigov.ingress.utils.Mapper;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import static com.tsadigov.ingress.bootstrap.Constants.*;

@Service
@RequiredArgsConstructor
@Slf4j
public class AppUserServiceImpl implements UserDetailsService, AppUserService {

    private final PasswordEncoder passwordEncoder;
    private final AppUserRepo userRepo;
    private final RoleRepo roleRepo;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {

        AppUser user = userRepo.findByUsername(username);
        if (user == null) {
            log.info("User not found in the database");
            throw new ResourceNotFoundException(USER_NOT_FOUND);
        }
        log.info("User found in the database");

        Collection<SimpleGrantedAuthority> authorities = new ArrayList<>();
        user.getRoles().forEach(role -> {
            authorities.add(new SimpleGrantedAuthority(role.getRoleName()));
        });
        return new User(user.getUsername(), user.getPassword(), authorities);
    }

    @Override
    public void addRoleToUser(String username, String roleName) {
        log.info("Adding rol {} to user {}", roleName, username);
        AppUser user = userRepo.findByUsername(username);
        Role role = roleRepo.findRoleByRoleName(roleName);

        List<Role> roles = new ArrayList<>();
        roles.add(role);
        user.setRoles(roles);
        userRepo.save(user);
    }

    @Override
    @Transactional
    public AppUserDTO signUp(SignUpDTO signUpDTO) {

        AppUser user = AppUser.builder()
                .username(signUpDTO.getUsername())
                .email(signUpDTO.getEmail())
                .password(passwordEncoder.encode(signUpDTO.getPassword()))
                .name(signUpDTO.getName())
                .build();

        userRepo.save(user);
        this.addRoleToUser(user.getUsername(), ROLE_USER);

        AppUserDTO userDTO = Mapper.map(user, AppUserDTO.class);
        return userDTO;
    }

    @Override
    public List<AppUserDTO> getPublishers() {
        List<AppUserDTO> publishers = userRepo.findByRolesMatches(ROLE_PUBLISHER);
        return null;
    }

}
