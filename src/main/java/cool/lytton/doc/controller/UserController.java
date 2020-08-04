package cool.lytton.doc.controller;

import cool.lytton.doc.model.User;
import cool.lytton.doc.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api")
public class UserController {
    @Autowired
    UserService userService;

    @GetMapping("/user/all")
    public List<User> getAllUsers() {
        return userService.getAll();
    }

    @GetMapping("/user")
    public User getUserById(@RequestParam("id") int id) {
        return userService.getById(id);
    }
}
