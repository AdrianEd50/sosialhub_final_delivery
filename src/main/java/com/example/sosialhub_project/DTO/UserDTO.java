package com.example.sosialhub_project.DTO;

import lombok.Data;

@Data
public class UserDTO {
    private String username;
    private String email;
    private String password;

    // Hvis du vil beholde en parameterisert konstruktør:
    public UserDTO(String username, String email, String password) {
        this.username = username;
        this.email = email;
        this.password = password;
    }
}