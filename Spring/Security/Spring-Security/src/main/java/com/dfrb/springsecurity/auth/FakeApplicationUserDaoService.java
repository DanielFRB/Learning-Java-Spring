package com.dfrb.springsecurity.auth;

import com.google.common.collect.Lists;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Repository;

import java.util.*;
import java.util.Optional;

import static com.dfrb.springsecurity.security.ApplicationUserRole.*;

@Repository("fake")
public class FakeApplicationUserDaoService implements ApplicationUserDao {
    private final PasswordEncoder passwordEncoder;

    @Autowired
    public FakeApplicationUserDaoService(PasswordEncoder passwordEncoder) {
        this.passwordEncoder = passwordEncoder;
    }

    @Override
    public Optional<ApplicationUser> selectApplicationUserByUsername(String username) {
        return getApplicationUsers()
                .stream()
                .filter(applicationUser -> username.equals(applicationUser.getUsername()))
                .findFirst();
    }

    private List<ApplicationUser> getApplicationUsers() {
        List<ApplicationUser> applicationUsers = Lists.newArrayList(
                new ApplicationUser(
                        "daniel",
                        passwordEncoder.encode("123456"),
                        CLIENT.getSimpleGrantedAuthority(),
                        true,
                        true,
                        true,
                        true
                ),
                new ApplicationUser(
                        "yaneth",
                        passwordEncoder.encode("om27032002"),
                        ADMIN.getSimpleGrantedAuthority(),
                        true,
                        true,
                        true,
                        true
                ),
                new ApplicationUser(
                        "oswaldo",
                        passwordEncoder.encode("om27032002"),
                        ADMINTRAINEE.getSimpleGrantedAuthority(),
                        true,
                        true,
                        true,
                        true
                )
        );
        return applicationUsers;
    }
}
