package paginator.mapper;

import paginator.po.User;

import java.util.List;

/**
 * TODO
 *
 * @author fanwh
 * @version V1.0
 * @create 2017-04-08 14:01
 *  
 */
public interface UserMapper {
    public int save(User user);

    public int delete(User user);

    public List<User> select(User user);
}
