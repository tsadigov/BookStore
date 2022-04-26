package com.tsadigov.ingress.bootstrap;

import com.tsadigov.ingress.dao.AppUserRepo;
import com.tsadigov.ingress.dao.BookRepo;
import com.tsadigov.ingress.dao.RoleRepo;
import com.tsadigov.ingress.domain.AppUser;
import com.tsadigov.ingress.domain.Book;
import com.tsadigov.ingress.domain.Role;
import com.tsadigov.ingress.service.AppUserService;
import lombok.RequiredArgsConstructor;
import org.springframework.boot.CommandLineRunner;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Component;

import static com.tsadigov.ingress.bootstrap.Constants.*;

@Component
@RequiredArgsConstructor
public class DataInitializer implements CommandLineRunner {

    private final AppUserRepo userRepo;
    private final RoleRepo roleRepo;
    private final BookRepo bookRepo;
    private final PasswordEncoder passwordEncoder;
    private final AppUserService userService;

    @Override
    public void run(String... args) throws Exception {
//        Add Roles to db
        Role roleUser = Role.builder()
                .roleName(ROLE_USER)
                .build();
        Role rolePublisher = Role.builder()
                .roleName(ROLE_PUBLISHER)
                .build();

        roleRepo.save(roleUser);
        roleRepo.save(rolePublisher);

//        Adding User to db
        AppUser user = AppUser.builder()
                .username("user")
                .email("user@gmail.com")
                .name("User")
                .password(passwordEncoder.encode("123"))
                .build();
        AppUser publisher1 = AppUser.builder()
                .username("publisher1")
                .email("publisher1@gmail.com")
                .name("publisher1")
                .password(passwordEncoder.encode("123"))
                .build();

        AppUser publisher2 = AppUser.builder()
                .username("publisher2")
                .email("publisher2@gmail.com")
                .name("publisher2")
                .password(passwordEncoder.encode("123"))
                .build();

        userRepo.save(user);
        userRepo.save(publisher1);
        userRepo.save(publisher2);

        userService.addRoleToUser(user.getUsername(), ROLE_USER);
        userService.addRoleToUser(publisher1.getUsername(), ROLE_PUBLISHER);
        userService.addRoleToUser(publisher2.getUsername(), ROLE_PUBLISHER);

        Book book1 = Book.builder()
                .bookName("Titans1")
                .bookDetails("About ancient")
                .author(publisher1)
                .build();

        Book book2 = Book.builder()
                .bookName("Titans2")
                .bookDetails("About ancient")
                .author(publisher2)
                .build();

        bookRepo.save(book1);
        bookRepo.save(book2);

    }
}
