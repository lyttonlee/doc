package cool.lytton.doc.service;

import cool.lytton.doc.dao.User;

import java.util.List;

public interface UserService {
    int insetUser(User user);
    List<User> findAll();
}
