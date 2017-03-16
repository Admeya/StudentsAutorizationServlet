package ru.students.spring.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import ru.students.spring.exceptions.UserDAOException;
import ru.students.spring.models.POJO.User;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Ирина on 13.03.2017.
 */
@Service
public class CustomUserDetailsService implements UserDetailsService {
    private IUserService userService;

    @Autowired(required = true)
    public void setUserService(IUserService userService) {
        this.userService = userService;
    }

    @Override
    public UserDetails loadUserByUsername(String s) throws UsernameNotFoundException {
        System.out.println("Login is " + s);

        User newUser = null;
        try {
            newUser = userService.authorize(s);
        } catch (UserDAOException e) {
            e.printStackTrace();
        }
        System.out.println(newUser.getLogin() + " " + newUser.getPassword());
        if (newUser == null) {
            throw new UsernameNotFoundException("User details not found with this username: " + s);
        }
        List<SimpleGrantedAuthority> authList = getAuthorities(newUser.getRole());
        System.out.println(authList);
        org.springframework.security.core.userdetails.User user = new org.springframework.security.core.userdetails.User(newUser.getLogin().trim(), newUser.getPassword().trim(), authList);

        return user;
    }

    private List<SimpleGrantedAuthority> getAuthorities(String role) {
        List<SimpleGrantedAuthority> authList = new ArrayList<>();
        authList.add(new SimpleGrantedAuthority("ROLE_USER"));

        if (role != null && role.trim().length() > 0) {
            if (role.equals("ROLE_ADMIN")) {
                authList.add(new SimpleGrantedAuthority("ROLE_ADMIN"));
            }
        }
        return authList;
    }
}
