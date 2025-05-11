package com.example.sosialhub_project.controller;
import com.example.sosialhub_project.DTO.UserDTO;
import com.example.sosialhub_project.service.UserService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/users")
@CrossOrigin(origins = "http://localhost:3000")
public class UserController {

    private final UserService userService;

    public UserController(UserService userService) {
        this.userService = userService;
    }

    @PostMapping("/register")
    public ResponseEntity<String> registerUser(@RequestBody UserDTO userDto) {
        if (userService.isUsernameTaken(userDto.getUsername())) {
            return ResponseEntity.badRequest().body("Username already taken");
        }

        if (userService.isEmailTaken(userDto.getEmail())) {
            return ResponseEntity.badRequest().body("Email already taken");
        }

        userService.createUser(userDto); // DTO håndteres i service
        return ResponseEntity.ok("User created");
    }

    @GetMapping("/{username}")
    public ResponseEntity<UserDTO> getUser(@PathVariable String username) {
        return userService.findByUsername(username)
                .map(user -> new UserDTO(user.getUsername(), user.getEmail(), null)) // Ikke returner passord!
                .map(ResponseEntity::ok)
                .orElseGet(() -> ResponseEntity.notFound().build());
    }
}