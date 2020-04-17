package ru.bloch.static_fabric;

import lombok.*;
import lombok.extern.slf4j.Slf4j;

import java.sql.Date;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.ZoneId;

/**
 * Пример использования фабричных статических методов для создания объектв.
 * Данный метод обладает преимуществами перед обычными конструкторами
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
        User user = User.create("Sergey", LocalDate.of(1978, 2, 28));
        System.out.println(user);
    }

    @Override
    public String toString() {
        SimpleDateFormat sdf = new SimpleDateFormat("dd.MM.yyyy");
        return "User{" +
                "name='" + name + '\'' +
                ", birthDay=" + sdf.format(Date.from(birthDay.atStartOfDay().atZone(ZoneId.systemDefault()).toInstant())) +
                '}';
    }
}
