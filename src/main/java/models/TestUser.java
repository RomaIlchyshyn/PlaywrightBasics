package models;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public class TestUser {
    private final String firstName;
    private final String lastName;
    private final String email;
    private final String password;


}