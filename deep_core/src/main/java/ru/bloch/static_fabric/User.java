package ru.bloch.static_fabric;

import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.extern.slf4j.Slf4j;

import java.time.LocalDate;

/**
 * @author Sergey Zhernovoy
 */
@Slf4j
public class User {
    @Getter
    private String name;
    @Getter
    @Setter
    private String token;
    @Getter
    @Setter
    private String password;
    @Getter
    private LocalDate birthDay;

    private User(String name, LocalDate birthDay) {
        this.name = name;
        this.birthDay = birthDay;
    }

    public static User create(String name, LocalDate birthDay) {
        return new User(name, birthDay);
    }

    public static void main(String[] args) {
        User user = User.create("Sergey", LocalDate.now());
        System.out.println(user);
    }

}
