package cool.lytton.doc.controller;

import cool.lytton.doc.dao.User;
import cool.lytton.doc.mapper.UserMapper;
import cool.lytton.doc.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.Mapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api")
public class UserController {
    @Autowired
    private UserService userService;

    @GetMapping("/user/all")
    public List<User> getUsers () {
        List<User> users = userService.findAll();
        return users;
    }
}
