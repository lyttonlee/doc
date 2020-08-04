package cool.lytton.doc.mapper;

import cool.lytton.doc.model.User;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

//@Mapper
public interface UserMapper {
    List<User> getAll();
    User getById(int id);
}
