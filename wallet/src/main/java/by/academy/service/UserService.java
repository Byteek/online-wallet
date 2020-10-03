package by.academy.service;

import by.academy.entity.AppUser;
import by.academy.entity.Role;
import by.academy.repository.RoleRepository;
import by.academy.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Collections;
import java.util.List;

@Service("userService")
public class UserService {

    @Autowired
    UserRepository userRepository;
    @Autowired
    RoleRepository roleRepository;
    @Autowired
    PasswordEncoder passwordEncoder;


    @Transactional
    public boolean saveUser(AppUser appUser) {
        AppUser appUserFromDB = userRepository.findByUsername(appUser.getUsername());

        if (appUserFromDB != null) {
            return false;
        }
        appUser.setUserPassword(passwordEncoder.encode(appUser.getUserPassword()));
        appUser.setRoles(Collections.singleton(new Role(null, "ROLE_USER")));
        userRepository.save(appUser);
        return true;
    }

    public AppUser getUser(String id) {
        return userRepository.findById(id).orElseThrow();
    }

    public void deleteUser(String id) {
        userRepository.delete(getUser(id));
    }

    public void update(AppUser appUser) {
        userRepository.save(appUser);
    }

    public List<AppUser> getAllUsers() {
        return userRepository.findAll();
    }

    public AppUser getUserByUsername(String username) {
        return userRepository.findByUsername(username);
    }

    public static String getUsernameAuthUser() {
        Authentication auth = SecurityContextHolder.getContext().getAuthentication();
        return auth.getName();//get logged in username
    }

    public AppUser getUserByWalletId(String walletId) {
        return userRepository.findByUsersWallet(walletId);
    }
}
