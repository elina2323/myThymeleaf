package kg.megacom.mythymeleaf.domain;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;


public class User {

    private Long id;

    @NotEmpty(message = "Name is mandatory")
    @Size(min = 2, max = 20, message = "The name field should contain from 2 to 20 characters")
    @Pattern(regexp="^[A-Za-z]*$")
    private String name;

    @NotEmpty(message = "Email is mandatory")
    @Email(regexp = "^(.+)@(.+)$", message = "For instance: email@example.com")
    private String email;

    @NotEmpty(message = "Password is mandatory")
    @Size(min = 8, max = 20, message = "The password field should contain minimum 8 characters")
    @Pattern(regexp = "[a-zA-Z0-9!-&]*")
    private String password;

    private boolean isActive;

    public User(Long id, String name, String email, String password, boolean isActive) {
        this.id = id;
        this.name = name;
        this.email = email;
        this.password = password;
        this.isActive = isActive;
    }

    public User(){}

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public boolean isActive() {
        return isActive;
    }

    public void setActive(boolean active) {
        isActive = active;
    }
}
