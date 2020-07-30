package cool.lytton.doc.mapper;

import cool.lytton.doc.dao.User;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

import java.util.List;

@Mapper
public interface UserMapper {
    @Insert("insert into user(id, username, password)values(#{id},#{username},#{password})")
    int insert(User user);
    @Select("select * from user")
    List<User> findAll();
}
