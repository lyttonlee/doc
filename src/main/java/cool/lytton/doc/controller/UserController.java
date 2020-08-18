package cool.lytton.doc.controller;

import cool.lytton.doc.annotation.JwtToken;
import cool.lytton.doc.model.User;
import cool.lytton.doc.model.base.BaseResponse;
import cool.lytton.doc.service.UserService;
import cool.lytton.doc.util.QiniuUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api")

public class UserController {
    @Autowired
    UserService userService;

    @GetMapping("/user/all")
    @ResponseBody
    public BaseResponse getAllUsers() {
        List<User> users = userService.getAll();
        BaseResponse res = new BaseResponse();
//        res.setResult(users);
        return res;
    }

    @GetMapping("/uptoken")
    public String getToken() {
        String token = QiniuUtil.createToken();
        return token;
    }

    @JwtToken
    @GetMapping("/user")
    public User getUserById(@RequestParam("id") int id) {
        return userService.getById(id);
    }
}
