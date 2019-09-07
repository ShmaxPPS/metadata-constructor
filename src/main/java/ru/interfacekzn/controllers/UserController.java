package ru.interfacekzn.controllers;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.StreamSupport;

import ru.interfacekzn.entities.User;
import ru.interfacekzn.repositories.UserRepository;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;


/**
 * @author m.popov
 */

@RestController
@CrossOrigin(origins = "http://localhost:4200")
public class UserController {

  private final UserRepository userRepository;

  public UserController(final UserRepository userRepository) {
    this.userRepository = userRepository;
  }

  @GetMapping("/users")
  public List<User> getUsers() {
    return StreamSupport
        .stream(userRepository.findAll().spliterator(), false)
        .collect(Collectors.toList());
  }

  @PostMapping("/users")
  public void addUser(@RequestBody User user) {
    userRepository.save(user);
  }
}
