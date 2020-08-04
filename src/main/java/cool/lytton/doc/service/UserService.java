package cool.lytton.doc.service;

import cool.lytton.doc.mapper.UserMapper;
import cool.lytton.doc.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserService {

    @Autowired
    UserMapper userMapper;

    public List<User> getAll() {
        return userMapper.getAll();
    }

    public User getById(int id) {
        return userMapper.getById(id);
    }
}
