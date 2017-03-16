package ru.students.spring.models.POJO;

import org.springframework.security.core.GrantedAuthority;

import javax.persistence.*;

/**
 * Created by Ирина on 23.02.2017.
 */
@Entity
@Table(name = "user", schema = "public")
public class User {
    @Id
    @GeneratedValue
    @Column(name = "id_user")
    private int id;

    @Column
    private String login;

    @Column
    private String password;

    @Column
    private String role;

    public User(int id, String login, String password, String role) {
        this.id = id;
        this.login = login;
        this.password = password;
        this.role = role;
    }

    public User(String username, String password, boolean b, boolean b1, boolean b2, boolean b3, GrantedAuthority[] role_users) {
    }

    public User() {
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getLogin() {
        return login;
    }

    public void setLogin(String login) {
        this.login = login;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getRole() {
        return role;
    }

    public void setRole(String role) {
        this.role = role;
    }
}
