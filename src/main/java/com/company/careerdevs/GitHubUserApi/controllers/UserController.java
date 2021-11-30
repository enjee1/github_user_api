package com.company.careerdevs.GitHubUserApi.controllers;

import com.company.careerdevs.GitHubUserApi.models.User;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

@RestController
@RequestMapping("/api/github")
public class UserController {
    private static final String GHURL = "https://api.github.com/users";

    @GetMapping("/users")
    public Object getAllUsers(RestTemplate restTemplate) {
        User[] users;

        try {
            users = restTemplate.getForObject(GHURL, User[].class);

        } catch (Exception exc) {
            return exc.getMessage();
        }

        return users;
    }

    @GetMapping("/users/{id}")
    public Object getUserById(RestTemplate restTemplate,
                          @PathVariable(name = "id") String id) {
        User user;

        try {
            user = restTemplate.getForObject(GHURL + "/" + id, User.class);

        } catch (Exception exc) {
            return exc.getMessage();
        }

        return user;

    }
}
