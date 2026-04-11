package com.klu.user;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.*;

@RestController
@RequestMapping("/api/users")
@CrossOrigin
public class Usercontroller {

    List<Map<String, String>> users = new ArrayList<>();

    @PostMapping("/register")
    public ResponseEntity<String> register(@RequestBody Map<String, String> user) {
        users.add(user);
        return ResponseEntity.ok("Registered Successfully");
    }

    @PostMapping("/login")
    public ResponseEntity<?> login(@RequestBody Map<String, String> user) {
        for (Map<String, String> u : users) {
            if (u.get("username").equals(user.get("username")) &&
                u.get("password").equals(user.get("password"))) {
                return ResponseEntity.ok(u);
            }
        }
        return ResponseEntity.status(401).body("Invalid Credentials");
    }

    @GetMapping("/{username}")
    public ResponseEntity<?> getUser(@PathVariable String username) {
        for (Map<String, String> u : users) {
            if (u.get("username").equals(username)) {
                return ResponseEntity.ok(u);
            }
        }
        return ResponseEntity.status(404).body("User Not Found");
    }
}