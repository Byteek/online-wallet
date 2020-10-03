package by.academy.entity;

import lombok.*;
import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

import java.util.List;
import java.util.Set;


@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
public final class AppUser {
    @Id
    @GeneratedValue(generator = "system-uuid")
    @GenericGenerator(name = "system-uuid", strategy = "uuid2")
    private String id;

    @NotBlank(message = "Username cannot be null")
    private String username;

    @NotBlank(message = "Password cannot be null")
    private String userPassword;

    private String usersWallet;

    @Email(message = "Email should be valid")
    private String email;

    @NotBlank(message = "You haven't entered anything")
    private String phoneNumber;

    @ManyToMany(fetch = FetchType.EAGER, cascade = CascadeType.ALL)
    private Set<Role> roles;
}
