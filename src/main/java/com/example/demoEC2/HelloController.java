package com.example.demoEC2;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;

import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.Map;

@RestController
@RequestMapping("/api")
@Tag(name = "Hello Controller", description = "Simple CRUD APIs")
public class HelloController {

    // GET API
    @GetMapping("/hello")
    @Operation(summary = "Get hello message")
    public String hello() {
        return "Hello from EC2!";
    }

    // POST API
    @PostMapping("/create")
    @Operation(summary = "Create a user")
    public Map<String, String> createUser(@RequestBody Map<String, String> request) {

        Map<String, String> response = new HashMap<>();
        response.put("message", "User created successfully");
        response.put("name", request.get("name"));

        return response;
    }

    // PUT API
    @PutMapping("/update/{id}")
    @Operation(summary = "Update user by ID")
    public Map<String, String> updateUser(
            @PathVariable int id,
            @RequestBody Map<String, String> request) {

        Map<String, String> response = new HashMap<>();
        response.put("message", "User updated successfully");
        response.put("id", String.valueOf(id));
        response.put("updatedName", request.get("name"));

        return response;
    }

    // DELETE API
    @DeleteMapping("/delete/{id}")
    @Operation(summary = "Delete user by ID")
    public Map<String, String> deleteUser(@PathVariable int id) {

        Map<String, String> response = new HashMap<>();
        response.put("message", "User deleted successfully");
        response.put("deletedId", String.valueOf(id));

        return response;
    }
}