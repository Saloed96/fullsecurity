package com.example.demo.auth;

import com.google.common.collect.Lists;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

import static com.example.demo.security.ApplicationUserRole.ADMIN;
import static com.example.demo.security.ApplicationUserRole.ADMINTRAINEE;
import static com.example.demo.security.ApplicationUserRole.STUDENT;

@Repository("fake")
public class FakeApplicationUserDaoImpl implements ApplicationUserDao {

    private final PasswordEncoder passwordEncoder;

    @Autowired
    public FakeApplicationUserDaoImpl(PasswordEncoder passwordEncoder) {
        this.passwordEncoder = passwordEncoder;
    }

    @Override
    public Optional<ApplicationUser> selectUserByUsername(String username) {
        return getApplicationUsers().stream()
            .filter(applicationUser -> username.equals(applicationUser.getUsername()))
            .findFirst();
    }

    public List<ApplicationUser> getApplicationUsers() {
        List<ApplicationUser> applicationUsers = Lists.newArrayList(
            new ApplicationUser(
                "annasmith",
                passwordEncoder.encode("password"),
                STUDENT.getGrantedAuthorities(),
                true,
                true,
                true,
                true
            ),
            new ApplicationUser(
                "linda",
                passwordEncoder.encode("password123"),
                ADMIN.getGrantedAuthorities(),
                true,
                true,
                true,
                true
            ),
            new ApplicationUser(
                "tom",
                passwordEncoder.encode("password123"),
                ADMINTRAINEE.getGrantedAuthorities(),
                true,
                true,
                true,
                true
            )
        );
        return applicationUsers;
    }
}
