package by.academy.config;

import by.academy.entity.AppUser;
import by.academy.service.UserService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.stream.Collectors;

@Service("authService")
public class AuthenticationService implements UserDetailsService {

    private static final Logger log = LoggerFactory.getLogger(AuthenticationService.class);

    @Autowired
    UserService userService;


    @Override
    public UserDetails loadUserByUsername(String username) {
        log.info("Calling loadUserByUsername:{}", username);
        AppUser appUser = userService.getUserByUsername(username);

        if (appUser == null) throw new UsernameNotFoundException("User not found: " + username);

        return new User(
                appUser.getUsername(),
                appUser.getUserPassword(),
                appUser.getRoles()
                        .stream()
                        .map(appRole -> new SimpleGrantedAuthority(appRole.getName()))
                        .collect(Collectors.toList())
        );
    }
}
